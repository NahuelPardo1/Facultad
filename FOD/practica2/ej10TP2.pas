program ejercicio10Tp2;
const
    valorAlto = 99999;
type
    archivo = record
        codProvincia:integer;
        codLocalidad:integer;
        numMesa:integer;
        cantVotos:integer;
    end;
    maestro = file of archivo;
procedure leer(var mae:maestro; var reg:archivo);
begin
    if(not eof(mae))then read(mae,reg)
    else reg.codProvincia:=valorAlto;
end;

procedure recorrerMaestro(var mae:maestro);
var
    regM:archivo;
    provinciaActual,localidadActual,totalVotos,totalProvincia,totalLocalidad:integer;
begin
    totalVotos:=0;
    reset(mae);
    leer(mae,regM);
    while(regM.codProvincia <> valorAlto)do
    begin
        writeln();
        writeln('Codigo de provincia =',regM.codProvincia);
        provinciaActual:= regM.codProvincia;
        totalProvincia:=0;
        while(provinciaActual = regM.codProvincia)do
        begin
            writeln();
            writeln('Codigo de localidad = ',regM.codLocalidad);
            localidadActual:= regM.codLocalidad;
            totalLocalidad:= 0;
            while(localidadActual = regM.codLocalidad) and (provinciaActual = regM.codProvincia)do
            begin
                writeln('Numero de mesa: ',regM.numMesa,' Cantidad de votos: ',regM.cantVotos);
                totalLocalidad:=totalLocalidad + regM.cantVotos;
                leer(mae,regM);
            end;
            writeln('Total de Votos Localidad = ', totalLocalidad);
            totalProvincia:= totalProvincia+totalLocalidad;
        end;
        writeln('Total de votos provincia = ',totalProvincia);
        totalVotos:=totalVotos+totalProvincia;
    end;
    writeln();
    writeln('Total general de votos = ',totalVotos);
end;

begin

end.
