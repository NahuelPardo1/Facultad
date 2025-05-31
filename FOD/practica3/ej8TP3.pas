program ejercicio8TP3;
type
    distribucion = record
        nombre: string[15];
        anio: string[10];
        numKernel: integer;
        cantDev: integer;
        descripcion: string[30];
    end; 
    archivo = file of distribucion;

procedure buscarDistribucion(var a:archivo; nombre:string; var pos:integer);
var
    encontre: boolean;
    dis: distribucion;
begin
    encontre:=false;
    reset(a);
    while(not eof(a) and not encontre)do
    begin
        read(a,dis);
        if(dis.nombre = nombre)then
        begin
            encontre:=true;
            pos:= filepos(a)-1;
        end;

    end;
    if(encontre = false)then pos:= -1;
    
end;

procedure altaDistribucion(var a:archivo; dis:distribucion);
var
    pos:integer;
    posLibre:integer;
    cabecera,aux:distribucion;
begin
    pos:=0;
    buscarDistribucion(a,dis.nombre,pos);
    if(pos= -1)then
    begin
        reset(a);
        read(a,cabecera);
        if(cabecera.cantDev = 0)then
        begin
            seek(a,filesize(a));
            write(a,dis);
        end
        else
        begin
            posLibre:= cabecera.cantDev * -1;
            seek(a,posLibre);
            read(a,aux);
            cabecera.cantDev:= aux.cantDev;
            seek(a,posLibre);
            write(a,dis);
            seek(a,0);
            write(a,cabecera);
        end;
    end
    else writeln('Ya existe la distribucion');
end;

procedure bajaDistribucion(var a:archivo; nombre:string);
var
    pos:integer;
    posEliminar:integer;
    cabecera,aux:distribucion;
begin
    reset(a);
    pos:=-1;
    buscarDistribucion(a,nombre,pos);
    if(pos <> -1)then
    begin
        read(a,cabecera);
        seek(a,pos);
        read(a,aux);
        aux.cantDev:= cabecera.cantDev;
        seek(a,0);
        cabecera.cantDev:= pos * -1;
        write(a,cabecera);
        seek(a,pos);
        write(a,aux);
    end
    else writeln('Distribucion no existente');
end;