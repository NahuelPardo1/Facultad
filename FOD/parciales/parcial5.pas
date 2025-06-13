program parcial5;
const
    valorAlto = 9999;
type
    producto = record
        cod:integer;
        nombre:string[15];
        desc:string[15];
        codBarras:integer;
        categoria:string[20];
        stockAct:integer;
        stockMin:integer;
    end;

    pedido = record
        cod:integer;
        cantPed:integer;
        desc:string[50];
    end;

    maestro = file of producto;
    detalle = file of pedido;

procedure leer(var d:detalle; var p:pedido);
begin
    if(not eof(d))then
    begin
        read(d,p);
    end;
end;

procedure minimo(var d,d2,d3:detalle; var p,p2,p3:pedido; var min:pedido);
begin
    if(p.cod <= p2.cod)and(p.cod<= p3.cod)then
    begin
        min:=p;
        leer(d,p);
    end
    else if(p2.cod< p.cod) and(p2.cod < p3.cod)then
    begin
        min:=p2;
        leer(d2,p2);
    end
    else if(p3.cod<p.cod) and(p3.cod<p2.cod)then
    begin
        min:=p3;
        leer(d3,p3);
    end;
end;

procedure actualizarMaestro(var m:maestro; var d,d2,d3:detalle);
var
    p,p2,p3,min:pedido;
    pM:producto;
    i:integer;
begin
    reset(m);
    reset(d);
    reset(d2);
    reset(d3);
    leer(d,p);
    leer(d2,p2);
    leer(d3,p3);
    read(m,pM);
    minimo(d,d2,d3,p,p2,p3,min);
    while(min.cod<>valorAlto)do
    begin
        while(pM.cod<>min.cod)do
        begin
            read(m,pM);
        end;

    end;

end;