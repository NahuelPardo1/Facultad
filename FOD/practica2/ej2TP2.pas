program ejercicio2;
const
    valorAlto=999;
type

    producto=record
        cod: integer;
        nombre: string;
        precio: real;
        stockActual: integer;
        stockMinimo: integer;
    end;
    venta=record
        cod: integer;
        cantV:integer;
    end;
    detalle=file of venta;
    maestro=file of producto;

procedure leer(var det: detalle; var v:venta);
begin
    if(not eof(det))then
        read(det,v)
    else
        v.cod:=valorAlto;
end;

procedure actualizarMaestro(var mae: maestro; var det: detalle);
var
    v:venta;
    p:producto;
begin
    reset(mae);
    reset(det);
    leer(det,v);
    while(v.cod<>valorAlto)do
    begin
        read(mae,p);
        while(p.cod<>v.cod) do
            read(mae,p);
        while(p.cod = v.cod)do
            begin
                if(v.cantV >= p.stockActual)then
                    p.stockActual:=0;
                else
                    p.stockActual:= p.stockActual-v.cantV;
                leer(det,v);
            end;
        seek(mae,filepos(mae)-1);
        write(mae,p);
    end;
    close(mae);
    close(det);
end;
procedure listarProductos(var mae:maestro);
var
    p:producto;
    txt:text;
begin
    assign(txt,'stock_minimo.txt');
    rewrite(txt);
    reset(mae);
    while(not eof(mae))do
    begin
        read(mae,p);
        if(p.stockActual<=p.stockMinimo)then
        begin
            with p do
                writeln(txt,'Codigo= ', cod, ' Precio= ',precio:0:2, ' Stock Actual= ',stockActual, ' Stock minimo= ',stockMinimo,' Nombre= ',nombre);
        end;
    end;
    writeln('Archivo exportado a TXT - stockMin');
    close(mae);
    close(txt);
end;
procedure menu;
    var
            detalle: detalle;
            maestro: maestro;
            opcion:integer;
    begin
        assign(maestro,'maestro');
        assign(detalle,'detalle');
        writeln('|| Menu de opciones ||');
        writeln('Ingrese 1 para actualizar el archivo maestro');
        writeln('Ingrese 2 para listar los productos debajo del stock minimo');
        readln(opcion);
        while(opcion<1) or (opcion>2) do begin
            writeln('Ingresa un valor valido: ');
            read(opcion);
        end;
        case opcion of
            1:actualizarMaestro(maestro,detalle);
            2:listarProductos(maestro);
        end;
    end;
begin
    menu();
end.