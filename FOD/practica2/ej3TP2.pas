program ejercicio3;
const
    valorAlto = 'ZZZ'
type
    alfabetizacion=record
        provincia:string;
        cantPerAlf:integer;
        totalEnc:integer;
    end;
    censo = record
        provincia:string;
        codLocalidad:integer;
        cantPerAlf:integer;
        cantEnc:integer;
    end;
    maestro = file of alfabetizacion;
    detalle = file of censo;

procedure actualizarMaestro(var mae:maestro; var det1,det2:detalle);
    procedure leer(var det: detalle;var dato: censo)
    begin   
        if(not eof(det))then
            read(det,dato)
        else
            dato.provincia:=valorAlto;
    end;
    procedure minimo(var det1,det2:detalle; var r1,r2: censo; var min:censo);
    begin
        if(r1.provincia<= r2.provincia)then
        begin
            min:=r1;
            leer(det1,r1);
        end
        else begin
            min:=r2;
            leer(det2,r2);
        end;
    end;
    var
        regM:alfabetizacion;
        regD1,regD2,min:censo;
    begin
        reset(mae);
        reset(det1);
        reset(det2);
        leer(det1,regD1);
        leer(det2,regD2);
        minimo(det1,det2,regD1,regD2,min);
        while(min.provincia<>valorAlto)do begin
            read(mae,regM);
            while(regM.provincia<>min.provincia)do
                read(mae,regM);
            while(regM.provincia = min.provincia) do begin
                regM.cantPerAlf:= regM.cantPerAlf+min.cantPerAlf;
                regM.totalEnc:= regM.totalEnc+min.cantEnc;
                minimo(det1,det2,regD1,regD2,min);
            end;
            seek(mae,filepos(mae)-1);
            write(mae,regM);
        end;
        close(mae);
        close(det1);
        close(det2);
    end;
var
begin
End.