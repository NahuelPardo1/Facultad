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
    min.codigo:= valoralto;
    for i:= 1 to DF do
        if(vecReg[i].codigo < min.codigo) then
            begin
                min:= vecReg[i];
                pos:= i;
            end;
    if(min.codigo <> valoralto) then
        leer(vec[pos], vecReg[pos]);
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
end;