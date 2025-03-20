type
    empleado=record
        num:integer;
        apellido:string[20];
        nombre:string[20];
        edad:integer;
        dni:integer;
    end;
    archivo=file of empleado;
procedure leerEmpleado(var e:empleado);
begin
    writeln('Ingrese el apellido del empleado: ');
    readln(e.apellido);
    if(e.apellido<>'fin')then
    begin
        writeln('Ingrese el nombre del empleado: ');
        readln(e.nombre);
        writeln('Ingrese el numero del empleado: ');
        readln(e.num);
        writeln('Ingrese la edad del empleado: ');
        readln(e.edad);
        writeln('Ingrese el dni del empleado: ');
        readln(e.dni);
    end;
end;

procedure crearArchivo(var empleados:archivo);
var
    e:empleado;
    arc_fisico: string[20];
begin
    writeln('Ingrese el nombre del archivo: ');
    readln(arc_fisico);
    assign(empleados, arc_fisico);
    rewrite(empleados);
    leerEmpleado(e);
    while (e.apellido<>'fin') do
    begin
        write(empleados,e);
        leerEmpleado(e);
    end;
    close(empleados);
end;
procedure leerArchivo(var empleados:archivo);
var
    e:empleado;
begin
    reset(empleados);
    while not eof(empleados) do
    begin
        read(empleados,e);
        write('Numero: ',e.num);
        write(' Apellido: ',e.apellido);
        write(' Nombre: ',e.nombre);
        write(' Edad: ',e.edad);
        write(' Dni: ',e.dni);
    end;
    close(empleados);
end;

procedure buscarEmpleado(var empleados:archivo);
var
    nom:string[20];
    e:empleado;
begin
    reset(empleados);
    writeln;
    writeln('Ingrese el nombre o apellido del empleado a buscar: ');
    readln(nom);
    read(empleados,e);
    while (not eof(empleados)) and ((e.nombre <> nom) and (e.apellido <> nom)) do
    begin
        if(e.nombre=nom) or (e.apellido=nom) then
        begin
            writeln('Empleado encontrado');
        end;
        read(empleados,e);
    end;
    close(empleados);
end;

procedure mayor70(var empleados:archivo);
var
    e:empleado;
begin
    reset(empleados);
    while not eof(empleados) do
    begin
        read(empleados,e);
        if(e.edad>=70)then
        begin
            write('Empleado proximo a jubilarse: ');
            write('Numero: ',e.num);
            write(' Apellido: ',e.apellido);
            write(' Nombre: ',e.nombre);
            write(' Edad: ',e.edad);
            write(' Dni: ',e.dni);
        end;
    end;
    close(empleados);
end;

var
    empleados: archivo;
    opcion:integer;
Begin

    writeln('||Bienvenido al sistema de empleados||');
    writeln;
    writeln('Ingrese 1 para crear un archivo de empleados');
    writeln('Ingrese 2 para leer el archivo de empleados');
    writeln('Ingrese 3 para buscar un empleado');
    writeln('Ingrese 4 para buscar empleados mayores a 70');
    readln(opcion);
    while(opcion<1) or (opcion>4) do
    begin
        if(opcion=1)then
        begin
            crearArchivo(empleados);
        end
        else if(opcion=2)then
        begin
            leerArchivo(empleados);
        end
        else if(opcion=3)then
        begin
            buscarEmpleado(empleados);
        end
        else if(opcion=4)then
        begin
            mayor70(empleados);
        end
        else
            writeln('Ingresa un valor valido');
        end;
        readln(opcion);
    end;
End.