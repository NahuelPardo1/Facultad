program ejercicio2TP3;
const

type
    asistente = record
        nro:integer;
        apellidoNombre: string[30];
        email: string[20];
        telefono:string[15];
        dni:string[10];
    end;
    archivo = file of asistente;

procedure leerAsistente(var a:asistente);
begin
    writeln('Ingrese el nro de asistente: ');
    read(a.nro);
    if(a.nro <> 0)then begin
        writeln('Ingrese su apellido y nombre: ');
        read(a.apellidoNombre);
        writeln('Ingrese su email: ');
        read(a.email);
        writeln('Ingrese su telefono: ');
        read(a.telefono);
        writeln('Ingrese su dni: ');
        read(a.dni);
    end;
end;


procedure agregarAsistentes(var arc:archivo);
var
    a:asistente;
begin
    reset(arc);
    leerAsistente(a);
    while(a.nro <>0)do
    begin
        write(arc,a);
        leerAsistente(a);
    end;
end;

procedure bajaLogica(var arc:archivo);
var
    nro:integer;
    a:asistente;
begin
    reset(arc);
    read(arc,a);
    while(not eof(arc))do
    begin
        if(a.nro < 1000)then
        begin
            a.dni := '@'+a.dni;
            seek(arc,filepos(arc)-1);
            write(arc,a);
        end;
        read(arc,a);
    end;

end;

begin

end.