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

var
        detalle: detalle;
        maestro: maestro;
        regm: producto;
        regd: venta;
        cod_actual:string[4];
        tot_vendido:integer;
Begin
    assign(maestro,'maestro');
    assign(detalle,'detalle');
    
    
End.