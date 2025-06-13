program parcial3;
const
    DF = 30;
    valorAlto = 9999;
type
    subrango = 1..DF;
    infoM = record
        codMun:integer;
        nombreMun:string;
        cantCasos:integer;
    end;

    infoD = record
        codMun:integer;
        cantCasos:integer;
    end;

    maestro = file of infoM;
    detalle = file of infoD;

    vDet = array[subrango] of detalle;
    regDet = array[subrango] of infoD;

procedure leer(var d:detalle; var regD:infoD);
begin
    if(not eof(d))then
    begin
        read(d,regD);
    end
    else
    begin
        regD.codMun:= valorAlto;
    end;
end;

procedure minimo(var v: vDet; var r:regDet; var min: infoD);
var
    pos,i:integer;
begin
    min.codMun:= valorAlto;
    for i:= 1 to DF do
    begin
        if(r[i].codMun< min.codMun)then
        begin
            min:= r[i];
            pos:=i;
        end;
    end;
    if(min.codMun<> valorAlto)then
    begin
        leer(v[pos],r[pos]);
    end;
end;

procedure actualizar(var m:maestro; var v:vDet);
var
    min:infoD;
    vR:regDet;
    i:subrango;
    rM:infoM;
begin
    reset(m);
    for i:= 1 to DF do
    begin
        reset(v[i]);
        leer(v[i],vR)
    end;
    minimo(v,vR,min);
    while(min.codMun<>valorAlto)do
    begin
        read(m,rM);
        while(rM.codMun<>min.codMun)do
        begin
            read(m,rM);
        end;
        while(min.codMun<>valorAlto)and (min.codMun = rM.codMun)do
        begin
            rM.cantCasos:= rM.cantCasos+min.cantCasos;
            minimo(v,vR,min);
        end;
        if(rM.cantCasos>15)then writeln(rM.codMun, ' ',rM.nombreMun);
        seek(m,filepos(m)-1);
        write(m,rM);
    end;
    close(m);
    for i:= 1 to DF do
    begin
        close(v[i]);
    end;
end;

var
    m:maestro;
    v:vDet;
    nombre:string;
    i:integer;
begin
    writeln('Ingrese el nombre del archivo maestro: ');
    readln(nombre);
    assign(m,nombre);
    for i:= 1 to DF do begin
        writeln('Ingrese el nombre del archivo detalle nro ',i,': ');
        read(nombre);
        assign(v[i],nombre);
    end;
    actualizar(m,v);
end.