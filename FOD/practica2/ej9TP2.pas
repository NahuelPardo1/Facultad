program ejercicio9TP2;
const
    valorAlto = 9999;
type
    venta= record
        codigo:integer;
        nombre:string;
        apellido: string;
        anio:integer;
        mes:integer;
        dia:integer;
        monto: real;
    end;
    maestro = file of venta;
procedure leer(var mae: maestro; var reg: venta);
begin
    if(not eof(det))then read(mae,reg)
    else venta.codigo:=valorAlto;
end;

procedure recorrerMaestro(var mae:maestro);
var
    infoMae:venta;
    montoTotalVentas,montoAnio,montoMes:real;
    codigoActual,anioActual,mesActual:integer;
begin
    reset(mae);
    montoTotalVentas:=0;
    leer(mae,infoMae);
    while(infoMae.codigo<>valorAlto)do
    begin
        writeln();
        writeln('Cliente = ',infoMae.codigo,' Nombre = ',infoMae.nombre,' Apellido = ',infoMae.apellido);
        codigoActual:=infoMae.codigo;
        while(codigoActual=infoMae.codigo)do
        begin
            anioActual:= infoMae.anio;
            montoAnio:=0;
            writeln('Anio= ',infoMae.anio);
            while(codigoActual = infoMae.codigo) and (anioActual = infoMae.anio)do
            begin
                mesActual:=infoMae.mes;
                montoMes:=0;
                while(codigoActual = infoMae.codigo) and (anioActual = infoMae.anio) and (mesActual = infoMae.mes)do
                begin
                    montoMes:= montoMes +infoMae.monto;
                    leer(mae,infoMae);
                end;
                if(montoMes<>0)then
                begin
                    writeln('Mes= ',mesActual,' Recaudado= ',montoMes:0:2);
                    montoAnio:= montoAnio+montoMes;
                end;
            end;
            writeln('Recaudado en el anio ', anioActual, '=', montoAnio:0:2);
            if(codigoActual = infoMae.codigo)then
                writeln();
            montoTotalVentas:=montoTotalVentas+montoAnio;
        end;
        
    end;
    writeln('Monto total recaudado de la empresa=', montoTotalVentas:0:2);
    close(mae);
end;
begin

end.