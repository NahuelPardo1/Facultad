program ejercicio1TP3p2;
const

type
    producto = record
        codProd:integer;
        nombre:string[20];
        precio:real;
        stockAct:integer;
        stockMin:integer;
    end;

    venta = record
        codProd:integer;
        cantVend:integer;
    end;

    maestro = file of producto;
    detalle = file of venta;

procedure actualizarMaestro(var m:maestro; var d:detalle);
var
    v:venta;
    p:producto;
    encontre:boolean;
begin
    reset(m);
    reset(d);
    while(not eof(d))do
    begin
        encontre:=false;
        read(d,v);
        while(not eof(m) and not encontre)do
        begin
            read(m,p);
            if(v.codProd = p.codProd)then
            begin
                encontre:=true;
                p.stockAct:= p.stockAct - v.cantVend;
                seek(m,filepos(m)-1);
                write(m,p);
            end;
        end;
        seek(m,0);
    end;
end;
