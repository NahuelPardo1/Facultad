program ejercicio8Prac2;
const
    DF = 16;
    valorAlto = 99999;
type
    subrango = 1..DF;

    infoM= record
        codProvincia:integer;
        nomProvincia:string;
        cantHabitantes:integer;
        cantKilos:integer;
    end;

    regDetalle = record
        codProvincia:integer;
        cantKilos:integer;
    end;

    maestro = file of infoM;
    detalle = file of regDetalle;
    vecDetalle = array[subrango] of detalle;  
    vecReg = array[subrango] of regDetalle;

procedure leer(var archivo:detalle; var dato: regDetalle);
begin
    if(not eof(archivo))then read(archivo,dato)
    else dato.codProvincia := valorAlto;
end;

procedure minimo(var reg_det: vecReg; var min: regDetalle ; var deta: vecDetalle);
var 
    i,pos:integer;
begin
    min.codProvincia := valorAlto;
    for i:= 1 to DF do
    begin
        if(reg_det[i].codProvincia < min.codProvincia)then
        begin
            pos:=i;
            min := reg_det[i]
        end;
    end;
    if(min.codProvincia<>valorAlto)then begin
        leer(deta[pos],reg_det[pos]);
    end;
end;

procedure actualizarMaestro(var mae:maestro; var vDet:vecDetalle);
var
    min: regDetalle;
    vecReg: vecReg;
    i:subrango;
    regM: infoM;
    promedio: real;
begin
    reset(mae);
    for i:= 1 to DF do
    begin
        reset(vDet[i]);
        leer(vDet[i],vecReg[i]);
    end;
    minimo(vecReg,min,vDet);
    read(mae,regM);
    while(minimo.codProvincia<>valorAlto)do
    begin
        while(minimo.codProvincia <> regM.codProvincia and not eof(mae))do
        begin
            if(regM.cantKilos>10000)then begin
                promedio:= regM.cantKilos / regM.cantHabitantes;
                writeln('Codigo provincia: ',regM.codProvincia,' nombre: ',regM.nomProvincia);
            end;
            read(mae,regM);
        end;
        while(minimo.codProvincia = regM.codProvincia)do
        begin
            regM.cantKilos:= regM.cantKilos + minimo.cantKilos;
            minimo(vecReg,min,vDet);
        end;
        seek(mae,filepos(mae)-1);
        write(mae,regM);
    end;
end.

