program parcial2;
const
    valorAlto= 9999;
type
    prestamo = record
        num:integer;
        DNI:integer;
        numPrest:integer;
        fecha:integer;
        monto:real;
    end;

    maestro = file of prestamo;

procedure leer(var m :maestro; var p:prestamo);
begin
    if(not eof(m))then
    begin
        read(m,p);
    end
    else
        p.num:=valorAlto
end;

procedure informar(var m:maestro);
var
    p:prestamo;
    sucAct,dniAct,fechaAct,cantVentEmp,cantVentSuc,cantEmpr,cantAnio:integer;
    sucTotal,empresaTotal,totalEmp,montoAnio:real;
begin
    empresaTotal:=0;
    cantEmpr:=0;
    reset(m);
    leer(m,p);
    writeln('Informe de ventas de la empresa');
    while(p.num<>valorAlto)do
    begin
        cantVentSuc:=0;
        sucTotal:=0;
        sucAct:= p.num;
        writeln('Sucursal: ',p.num);
        while(p.num = sucAct)do
        begin
            cantVentEmp:=0;
            totalEmp:=0;
            dniAct:=p.DNI;
            writeln('Empleado: DNI ',p.DNI);
            while(dniAct = p.DNI)and(p.num = sucAct)do
            begin
                cantAnio:=0;
                montoAnio:=0;
                writeln('Año  ', 'Cantidad de ventas  ','Monto de ventas')
                fechaAct:=extraerAnio(p.fecha);
                while(fechaAct = extraerAnio(p.fecha))and(dniAct = p.DNI)and (p.num = sucAct)do
                begin
                    cantAnio:=cantAnio+1;
                    montoAnio:=montoAnio+p.monto;
                    leer(m,p);
                end;
                writeln(fechaAct,'  ', cantAnio,'  ', montoAnio);
                cantVentEmp:= cantVentEmp+cantAnio;
                totalEmp:= totalEmp+montoAnio;
            end;
            writeln('Totales ', cantVentEmp, '  ',totalEmp);
            cantVentSuc:= cantVentSuc+cantVentEmp;
            sucTotal:=sucTotal+totalEmp;
        end;
        writeln('Cantidad de ventas sucursal: ',cantVentSuc);
        writeln('Monto total vendido por sucursal: ',sucTotal);
        cantEmpr:=cantEmpr+cantVentSuc;
        empresaTotal:=empresaTotal+sucTotal;
    end;
    writeln('Cantidad de ventas de la empresa: ', cantEmpr);
    writeln('Monto total vendido por la empresa: ',empresaTotal);
end;