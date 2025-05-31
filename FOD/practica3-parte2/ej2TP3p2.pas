program ejercicio2TP3p2;
type
    mesa = record
        codLocalidad:integer;
        numMesa: integer;
        cantVotos:integer;
    end;

    archivo = file of mesa;
    archivoAux = file of integer;

function yaProcesada(var aux: archivoAux; cod:integer): boolean
var
    c:integer;
    esta:boolean;
begin
    esta:=false;
    reset(aux);
    while(not eof(aux) and not esta)do
    begin
        read(aux,c);
        if(c = cod)then
            esta:=true;
    end;
    close(aux);
    yaProcesada:=esta;
end;

procedure procesarVotos(var a: archivo);
var
    m:mesa;
    aux:archivoAux;
    localidadActual,votosLocalidad,totalGeneral:integer;
begin
    assign(aux,'procesadas');
    rewrite(aux);
    totalGeneral:= 0;
    reset(a);
    while(not eof(a))do
    begin
        read(a,m);
        localidadActual:= m.codLocalidad;
        if(not yaProcesada(aux,localidadActual))then
        begin
            seek(aux,filesize(aux));
            write(aux,localidadActual);
            votosLocalidad:=0;
            reset(a)
            while(not eof(a))do
            begin
                read(a,m);
                if(m.codLocalidad = localidadActual)then
                begin
                    votosLocalidad:= votosLocalidad+ m.cantVotos;
                end;
            end;
            writeln('Codigo de localidad: ',localidadActual,' - Total de votos: ',votosLocalidad);
            totalGeneral:=totalGeneral+votosLocalidad;
        end;
    end;
    writeln('Total general de votos: ', totalGeneral);
    close(a);
    close(aux);
end;