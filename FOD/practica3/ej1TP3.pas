type
    empleado=record
        num:integer;
        apellido:string[20];
        nombre:string[20];
        edad:integer;
        dni:string[8];
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
begin
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
procedure agregarEmpleado(var emp: archivo);
var
    e:empleado;
    aux:empleado;
    repetido:boolean;
begin
    repetido:=false;
    reset(emp);
    leerEmpleado(e);
    while(e.nombre <> 'fin')do begin
        while not eof and repetido=true do
        begin
            read(emp,aux);
            if(aux.num=e.num)then repetido:=true;
        end;
        if(repetido=false)then begin
            seek(emp,filesize(emp));
            write(emp,e);
        end
        else
            writeln('Empleado ya existente');
        leerEmpleado(e);
    end;
    close(emp);
end;
procedure modificarEmpleado(var emp: archivo);
var
    num:integer;
    aux:empleado;
    edad:integer;
begin
    writeln('Ingrese el numero de empleado a modificar');
    readln(num);
    reset(emp);
    read(emp,aux);
    while (not eof) and (num<>aux.num) do
    begin
        read(emp,aux);
    end;
    if(num=aux.num)then
    begin
        seek(emp,(filePos(emp))-1);
        writeln('Ingrese la nueva edad: ');
        readln(edad);
        aux.edad:=edad;
        write(emp,aux);
    end
    else writeln('Empleado no encontrado');
end;
procedure eliminarEmpleado(var emp: archivo);
var
    numABorrar: integer;
    e, ultimo: empleado;
    posABorrar, totalRegistros: integer;
    encontrado: boolean;
begin
    writeln('Ingrese el número del empleado a eliminar: ');
    readln(numABorrar);
    
    reset(emp);
    encontrado := false;
    totalRegistros := filesize(emp);
    
    // Buscar el registro a borrar
    while (not eof(emp)) and (not encontrado) do
    begin
        read(emp, e);
        if (e.num = numABorrar) then
        begin
            posABorrar := filepos(emp) - 1;  // Guardar posición para sobreescribir
            encontrado := true;
        end;
    end;

    if (encontrado) then
    begin
        // Leer el último registro
        seek(emp, totalRegistros - 1);
        read(emp, ultimo);

        // Sobrescribir el registro a borrar con el último
        seek(emp, posABorrar);
        write(emp, ultimo);

        // Truncar el archivo para eliminar el duplicado al final
        seek(emp, totalRegistros - 1);
        truncate(emp);

        writeln('Empleado eliminado exitosamente.');
    end
    else
        writeln('Empleado no encontrado.');

    close(emp);
end;
procedure exportarCont(var emp:archivo; var c:Text);
var
    e:empleado;
begin
    reset(emp);
    rewrite(c);
    writeln(c,'Empleados: ');
    while(not eof(emp))do begin
        read(emp,e);
        writeln(c, e.num,' ',e.nombre,' ',e.apellido,' ',e.edad,' ',e.dni);
    end;
    close(emp);
    close(c);

end;
procedure exportarEmp(var emp:archivo; var c:Text);
var
    e:empleado;
begin
    reset(emp);
    rewrite(c);
    writeln(c,'EMPLEADOS SIN DNI CARGADO: ');
    while(not eof(emp))do begin
        read(emp,e);
        if(e.dni= '00')then
        writeln(c, e.num,' ',e.nombre,' ',e.apellido,' ',e.edad,' ',e.dni);
    end;
    close(emp);
    close(c);

end;

var
    empleados: archivo;
    opcion:integer;
    arc_fisico: string[20];
    carga: Text;
    carga2:Text;
Begin
    assign(carga,'todos_empleados.txt');
    assign(carga2,'faltaDNIEmpleado.txt');
    writeln('||Bienvenido al sistema de empleados||');
    writeln;
    writeln('Ingrese el nombre del archivo a utilizar: ');
    read(arc_fisico);
    assign(empleados,arc_fisico);
    writeln('Ingrese 1 para crear un archivo de empleados');
    writeln('Ingrese 2 para leer el archivo de empleados');
    writeln('Ingrese 3 para buscar un empleado');
    writeln('Ingrese 4 para buscar empleados mayores a 70');
    writeln('Ingrese 5 para agregar uno o mas empleados');
    writeln('Ingrese 6 para modificar la edad de un empleado');
    writeln('Ingrese 7 exportar el contenido a un archivo de texto');
    writeln('Ingrese 8 exportar a un archivo de texto los empleados que no tengan dni cargado');
    writeln('Ingrese 9 para eliminar un empleado');

    readln(opcion);
    while(opcion<1) or (opcion>9) do begin
        writeln('Ingresa un valor valido: ');
        read(opcion);
    end;
    case opcion of
        1:crearArchivo(empleados);
        2:leerArchivo(empleados);
        3:buscarEmpleado(empleados);
        4:mayor70(empleados);
        5:agregarEmpleado(empleados);
        6:modificarEmpleado(empleados);
        7:exportarCont(empleados,carga);
        8:exportarEmp(empleados,carga2);
        9:eliminarEmpleado(empleados);
    end;
    close(empleados);
    close(carga);
    
End.