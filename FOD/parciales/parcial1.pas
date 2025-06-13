program parcial1;
const

type
    profesional = record
        DNI:integer;
        nombre: string[15];
        apellido: string[15];
        sueldo:real;
    end;

    tArchivo = file of profesional;

procedure crear(var arch: tArchivo; var info:TEXT);
var
    p:profesional;
begin
    reset(info);
    rewrite(arch);
    //Creo el registro cabecera
    p.DNI := 0;
    p.nombre:='';
    p.apellido:='';
    p.sueldo:=0;
    writeln(arch,p);
    while(not eof(info))do begin
        readln(info,p.DNI,p.nombre,p.apellido,p.sueldo);
        writeln(arch,p);
    end;
end;

procedure agregar(var arch: tArchivo; p:profesional);
var
    cabecera,aux:profesional;
    sigPos:integer;
begin
    reset(arch);
    readln(arch,cabecera);
    sigPos:=cabecera.DNI;
    if(sigPos = 0 )begin
        seek(arch,filesize(arch));
        writeln(arch,p);
    end
    else
    begin
        seek(arch,sigPos);
        readln(arch,aux);
        cabecera.DNI:= aux.DNI;
        seek(arch,0);
        writeln(arch,cabecera);
        seek(arch,sigPos);
        writeln(arch,p);
    end;
end;

procedure eliminar(var arch:tArchivo; DNI:integer; var bajas:TEXT);
var
    cabecera,regP:profesional;
    posElim:integer;
    encontre:boolean;
begin
    encontre:=false;
    reset(arch);
    reset(bajas);
    readln(arch,cabecera);
    while(not eof(arch) and not encontre)do
    begin
        readln(arch,regP);
        if(regP.DNI = DNI)then
            encontre:=true;
            posElim:=filepos(arch)-1;
            regP.DNI:= cabecera.DNI;
            cabecera.DNI:= posElim * -1;
            seek(arch,0);
            writeln(arch,cabecera);
            seek(arch,posElim);
            writeln(arch,regP);
        begin
    end;
    if(not encontre)then
    begin
        writeln('La persona ingresada no existe');
    end;
end;
