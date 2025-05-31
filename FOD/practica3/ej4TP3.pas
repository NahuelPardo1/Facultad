program ejercicio4TP3;
type
    reg_flor = record
        nombre: string[45];
        codigo: integer;
    end;

    tArchFlores = file of reg_flor;

procedure agregarFlor(var a: tArchFlores; nombre:string; codigo: integer);
var
   flor,cabecera,aux: reg_flor;
   posLibre,sigLibre:integer;
begin
    reset(a);
    flor.codigo:= codigo;
    flor.nombre:= nombre;
    read(a,cabecera);
    if(cabecera.codigo = 0)then
    begin
        seek(a,filesize(a));
        write(a,flor);
    end
    else begin
        posLibre:= cabecera.codigo * -1;
        seek(a,posLibre);
        read(a,aux);
        sigLibre:=aux.codigo;
        seek(a,posLibre);
        write(a,flor);
        seek(a,0);
        cabecera.codigo:= sigLibre;
        write(a,cabecera);
    end;
end;

procedure eliminarFlor(var a: tArchFlores; flor:reg_flor);
var
    encontre:boolean;
    aux,cabecera:reg_flor;
    posEliminar:integer;
begin
    encontre:=false;
    reset(a)
    while(not eof(a) and not encontre)do
    begin
        read(a,aux);
        if(aux.codigo = flor.codigo)then
        begin
            encontre:=true;
            posEliminar:= filepos(a)-1;
            seek(a,0);
            read(a,cabecera);
            aux.codigo:=cabecera.codigo;
            seek(a,posEliminar);
            write(arc,aux);
            cabecera.codigo:= posEliminar * -1;
            seek(a,0);
            write(a,cabecera);
            writeln('Se ha eliminado la flor con exito');
        end;
    end;
    if(encontre = false)then writeln('No se ha encontrado la flor ingresada');
end;