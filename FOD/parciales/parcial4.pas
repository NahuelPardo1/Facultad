program parcial4;

type

    empleado = record
        numero:integer;
        nombre:string[15];
        apellido: string[15];
        dni:integer;
        fecha:integer;
        genero:string;
    end;

    maestro = file of empleado;

procedure ExisteEmpleado(var m:maestro; num:integer; var pos:integer);
var
    encontre:boolean;
    e:empleado;
begin
    encontre:=false;
    reset(m);
    pos:=0;
    seek(m,1);
    read(m,e);
    while(not eof(m)) and (not encontre)do
    begin
        if(e.numero = num)then
        begin
            encontre:=true;
            pos:= filepos(m)-1;
        end;
        read(m,e);
    end;
end;

procedure AltaEmpleado(var m:maestro);
var
    e,cabecera,aux:empleado;
    pos,sigPos:integer;
begin
    writeln('Ingrese numero de empleado: ');
    read(e.numero);
    writeln('Ingrese nombre de empleado: ');
    read(e.nombre);
    writeln('Ingrese apellido de empleado: ');
    read(e.apellido);
    writeln('Ingrese dni de empleado: ');
    read(e.dni);
    writeln('Ingrese fecha de nacimiento de empleado: ');
    read(e.fecha);
    writeln('Ingrese el genero del empleado: ');
    read(e.genero);
    reset(m);
    ExisteEmpleado(m,e.numero,pos);
    if(pos=0)then
    begin
        read(m,cabecera);
        if(cabecera.numero = 0)then
        begin
            seek(m,filesize(m));
            write(m,e);
        end
        else
        begin
            pos:= cabecera.numero *-1;
            seek(m,pos);
            read(m,aux);
            cabecera.numero:= aux.numero;
            seek(m,0);
            write(m,cabecera);
            seek(m,pos);
            write(m,e);
        end;
    end
    else
    begin
        writeln('Empleado ya existente');
    end;
    close(m);
end;

procedure BajaEmpleado(var m:maestro);
var
    numEmpleado,pos:integer;
    cabecera,aux:empleado;
begin
    writeln('Ingresa el numero del empleado a borrar: ');
    read(numEmpleado);
    reset(m);
    ExisteEmpleado(m,numEmpleado,pos);
    if(pos<>0)then
    begin
        read(m,cabecera);
        seek(m,pos);
        read(m,aux);
        aux.numero:=cabecera.numero;
        cabecera.numero:=pos*-1;
        seek(m,0);
        write(m,cabecera);
        seek(m,pos);
        write(m,aux);
    end
    else
    begin
        writeln('El empleado ingresado no existe');
    end;
end;