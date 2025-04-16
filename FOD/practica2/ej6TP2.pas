program ejercicio6;
const
    DF=10;
    valorAlto: 999;
type
    subrango = 1..DF;
    info=record
        codLocalidad:integer;
        codCepa:integer;
        cantCasosAct:integer;
        cantCasosNue:integer;
        cantRecu:integer;
        cantFall:integer;
    end;

    infoM= record
        codLocalidad:integer;
        nombreLoc:string;
        codCepa:integer;
        nombreCepa:integer;
        cantCasosAct:integer;
        cantCasosNue:integer;
        cantRecu:integer;
        cantFall:integer;
    end;
    detalle= file of info;
    maestro = file of infoM;
    vecDetalle= array[subrango] of detalle;
    vecRegistro= array[subrango] of info;

procedure leer(var det:detalle; var inf:info);
begin
    if(not eof(det))then
        read(det,inf);
    else
        inf.codLocalidad:=valoralto;
end;

procedure minimo(var vDet:vecDetalle; var vReg:vecRegistro; var min:info);
var
    pos,i:subrango;
begin
    min.codLocalidad:=valorAlto;
    min.codCepa:=valorAlto;
    for i:= 1 to DF do 
    begin
        if(vReg[i].codLocalidad<min.codLocalidad) or ((vReg[i].codLocalidad = min.codLocalidad) and (vReg[i].codCepa < min.codCepa))then
        begin
            pos:=i;
            min:=vReg[i];
        end;
    end;
    if(min.localidad<>valorAlto)then
        leer(vDet[pos],vReg[pos]);
end;

procedure actualizarMaestro(var mae:maestro; var vDet: vecDetalle;)
var
    min:info;
    regM:infoM;
    vReg:vecReg;
    i:subrango;
    cantCasosLocalidad,cantLocalidades:integer;
begin
    cantLocalidades:=0;
    reset(mae);
    for i:= 1 to DF do
    begin
        reset(vDet[i]);
        leer(vDet[i],vReg[i])
    end;
    minimo(vDet,vReg,min);
    read(mae,regM);
    while(min.localidad<>valorAlto)do
    begin
        cantCasosLocalidad:=0;
        while(regM.codLocalidad<>min.codLocalidad)do
        begin
            read(mae,regM);
        end;
        while(regM.codLocalidad = min.localidad)do
        begin
            while(regM.codCepa<>min.codCepa)do
            begin
                read(mae,regM);
            end;
            while(regM.codLocalidad = min.codLocalidad and regM.codCepo = min.codCepo)do
            begin
                regM.cantFall:= regM.cantFall + min.cantFall;
                regM.cantRecu:= regM.cantRecu + min.cantRecu;
                regM.cantCasosAct:= regM.cantCasosAct+ min.cantCasosAct;
                regM.cantCasosNue:= regM.cantCasosNue+min.cantCasosNue;
                cantCasosLocalidad:= cantCasosLocalidad + min.cantCasosAct;
                minimo(vDet,vReg,min);
            end;
        seek(mae,filepos(mae)-1);
        write(mae,regM);
        end;
    writeln('Cantidad de casos en la localidad: ',cantCasosLocalidad);
    if(cantCasosLocalidad>50)then
        cantLocalidades:= cantLocalidades+1;
    end;
    close(mae);
    for i:= 1 to DF do
        close(vDet[i]);
    writeln('La cantidad de localidades con mas de 50 casos es: ',cantLocalidades);
end;