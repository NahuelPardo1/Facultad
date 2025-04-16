program ejercicio5;
const
    valorAlto: 999;
    DF= 5;
type

    infoDetalle = record
        cod_usuario:integer;
        fecha:string;
        tiempo_sesion:integer;
    end;

    infoMaestro = record
        cod_usuario:integer;
        fecha:string;
        tiempo_total_de_sesiones_abiertas:integer;
    end;

    maestro= file of infoMaestro;
    detalle = file of infoDetalle;
    detalles = array [1..DF] of detalle;
    regDetalles = array [1..DF] of infoDetalle;
procedure leer(var det:detalle; infoDetalle: infoDetalle);
begin
    if(not eof(detalle))then
        read(detalle,infoDetalle)
    else
        infoDetalle.cod_usuario:= valorAlto;
end;

procedure minimo(var vDetalle:detalles; var rDetalle: regDetalles; var min: infoDetalle)
var
    pos,i:integer;
begin
    min.cod_usuario:= valorAlto;
    for i:= 1 to DF do
    begin
        if(rDetalle[i].cod_usuario < min.cod_usuario)then
        begin
            min:= rDetalle[i];
            pos:=i;
        end;
    end;
    if(min.cod_usuario <> valoralto) then
    leer(vDetalle[pos], rDetalle[pos]);
end;

procedure crearMaestro(var mae: maestro; var vec: vecDetalles)
var
    min,aux: infoDetalle;
    vecReg: rDetalle;
    i: integer;
begin
    assign(mae,'./var/log')
    rewrite(mae);
    for i:= 1 to DF do
    begin
        reset(vec[i]);
        leer(vec[i],vecReg[i]);
    end;
    minimo(vec,vecReg,min);
    while(min.cod_usuario<>valorAlto) do
    begin
        aux.fecha
    end;
end;
