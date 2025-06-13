program ejercicio4;
const
    valorAlto= 999;
    DF = 30;
type
    subrango = 1..DF;
    producto=record
        codigo:integer;
        nombre:string;
        descripcion:string;
        stockDisp:integer;
        stockMin:integer;
        precio:real;
    end;
    infoDetalle=record
        codigo:integer;
        cant:integer;
    end;
    detalle = file of infoDetalle;
    maestro = file of producto;
    vecDetalle = array[subrango] of detalle;
    vecRegistro = array[subrango] of infoDetalle;
procedure leer(var det: detalle; var infoDet: infoDetalle);
begin
    if(not eof(det)) then
        read(det, infoDet)
    else
        infoDet.codigo := valoralto;
end;

procedure minimo(var vec: vecDetalles; var vecReg: vecRegistros; var min: infoDetalle);
var
    i, pos: subrango;
begin
    min.codigo:=valorAlto;
    for i:= 1 to DF do
    begin
        if(vecReg[i].codigo < min.codigo) then
            begin
                min:= vecReg[i];
                pos:= i;
            end;
    end;
    if(min.codigo <> valoralto) then
        leer(vec[pos], vecReg[pos]);
end;
procedure reporte(var mae: maestro);
var
    p:producto;
    txt:text;
begin
    assign(txt,'reporte.txt')
    reset(mae);
    rewrite(txt);
    while(not eof(mae))do
    begin
        read(mae,p)
        if(p.stockDisp< p.stockMin)then
            writeln(txt, p.nombre, ' ', p.descripcion, ' ', p.stockDisp, ' ', p.precio:0:2);
    end;
    close(txt);
end;
procedure actualizarMaestro(var mae: maestro; var vec: vecDetalle);
var
    min:infoDetalle;
    regM:producto;
    vecReg: vecRegistros;
    i:subrango;
    aux,cant:integer;
begin
    reset(mae);
    for i:= 1 to DF do
    begin
        reset(vec[i]);
        leer(vec[i],vecReg[i]);
    end;
    minimo(vec,vecReg,min);
    while(min.codigo<>valorAlto)do begin
        aux:=min.codigo;
        cant:=0;
        while(min.codigo<>valorAlto) and (min.codigo=aux) do 
        begin
            cant:=cant+min.cant;
            minimo(vec,vecReg,min);
        end;
        read(mae,infoMae);
        seek(mae,filepos(mae)-1)
        regM.stockDisp:= regM.stockDisp- cant;
        write(maem,infoMae);
    end;
    reporte(mae);
    close(mae);
    for i:= 1 to DF do
        close(vec[i]);
    
end;