program ej1TP2;
type
    empleado=record
    cod: integer;
    nombre: string;
    montoCom: real;
    end;
    archivo= file of empleado;
procedure leerEmp(var e:empleado);
begin
    writeln('Ingrese el codigo de empleado: ');
    readln(e.cod);
    if(e.cod<>0)then 
    begin
        writeln('Ingrese su nombre: ');
        readln(e.nombre);
        writeln('Ingrese el monto de comision :');
        readln(e.montoCom);
    end;
end;
procedure crearArchivo(var empleados:archivo);
var
    e:empleado;
begin
    rewrite(empleados);
    leerEmp(e);
    while (e.cod<>0) do
    begin
        write(empleados,e);
        leerEmp(e);
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
        write('Codigo de empleado: ',e.cod);
        write(' Nombre: ',e.nombre);
        write(' Monto de comision: ',e.montoCom:0:2);
    end;
    close(empleados);
end;
procedure compactar(var detalle: archivo; var maestro: archivo);
var
    e:empleado;
    codAux: integer;
    total:real;
begin
    reset(detalle);
    rewrite(maestro);
    while(not eof(detalle)) do begin
        total:=0;
        read(detalle,e);
        codAux:=e.cod;    
        while((e.cod = codAux) and (not eof))do begin
            total:=total+e.montoCom;
            read(detalle,e);
        end;
        seek(detalle, filepos(detalle)-1);
        read(detalle,e);
        e.montoCom:=total;
        write(maestro,e);
    end;
    close(detalle);
    close(maestro);
end;
var
    maestro:archivo;
    detalle: archivo;
Begin
    assign(detalle,'detalle');
    assign(maestro,'maestro');
    crearArchivo(detalle);
    leerArchivo(detalle);
    compactar(detalle,maestro);
    leerArchivo(maestro);
    writeln('FIN DEL PROGRAMA');


End.