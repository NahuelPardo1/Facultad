program ejercicio7TP2;
const
    valorAlto = 

type
    infoM = record
        codAlumno: integer;
        nombreApellido: string;
        cantCursadasAprob: integer;
        cantFinalAprob: integer;
    end;
    regDetalle=record
        codAlumno:integer;
        codMateria:integer;
        res:real;
    end;
    detalle = file of regDetalle;
    maestro = file of infoM;

procedure crearArchivoMaestro(var arc: maestro; var carga: text);
var
    nombre:string;
    alu: infoM;
begin
    writeln('Ingrese un nombre del archivo a crear');
    readln(nombre);
    assign(arc,nombre);
    reset(carga);
    rewrite(arc);
    while(not eof(carga))do
    begin
        with alu do
            begin 
                readln(carga,codAlumno,cantCursadasAprob,cantFinalAprob,nombreApellido);
                write(arc,alu);
            end;
    end;
    writeln('Archivo binario maestro creado');
    close(arc);
    close(carga);
end;

procedure leer(var det: detalle; var reg: regDetalle);
begin
    if(not eof(det))then
        read(det,reg)
    else
        reg.codAlumno:= valorAlto;
end;

procedure actualizarMaestro(var mae:maestro; var det1:detalle; var det2: detalle);
var
    regDet1: regDetalle;
    regDet2: regDetalle;
    alu: infoM;
begin
    reset(mae);
    reset(det);
    leer(det1,regDet1);
    leer(det2,regDet2);
    while(regDet1.codAlumno<>valorAlto or regDet2<>valorAlto)do
    begin
        while(regDet1.codAlumno <> valorAlto and regDet1.codAlumno = alu.codAlumno)do
        begin
            if(regDet1.nota >= 4)then
            begin
                alu.cantCursadasAprob: = alu.cantCursadasAprob+1;
            end;
            leer(det,regDet1);
        end;
        while(regDet2.codAlumno<> valorAlto and regDet2.codAlumno = alu.codAlumno) do
        begin
            if(regDet2.nota >= 4)then
            begin
                alu.cantFinalesAprob := alu.cantFinalesAprob+1;
            end;
            leer(det2,regDet2);
        end;
    end;
end;

begin







end.