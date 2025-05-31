program ejercicio6TP3;
type
    prenda = record
        cod_prenda:integer;
        descripcion:string[30];
        colores: string[15];
        tipo_prenda: string[20];
        stock:integer;
        precio_unitario: real;
    end;

    maestro = file of prenda;
    codigo = file of integer;
procedure bajaLogica(var m: maestro; var c:codigo);
var
    p:prenda;
    cod:integer;
    encontre:boolean;
begin
    reset(m);
    reset(c);
    while(not eof(c))do
    begin
        encontre:=false;
        read(c,cod);
        seek(m,0);
        while(not eof(m) and not encontre)do
        begin
            read(m,p);
            if(p.cod_prenda = cod) then
            begin
                p.stock:= -1;
                seek(m,filepos(m)-1);
                write(m,p);
                encontre:=true;
            end;
        end;
    end;
    close(m);
    close(c);
end;

procedure nuevoArchivo(var m1: maestro; var m2:maestro);
var
    nombre1,nombre2:string;
    p:prenda;
begin
    assign(m1,'maestroPrendas');
    assign(m2,'maestroPrendas_nuevo');
    reset(m1);
    rewrite(m2);
    while(not eof(m1))do
    begin
        read(m1,p);
        if(p.stock>0)then write(m2,p);
    end;
    close(m1);
    close(m2);
    rename(m1,'maestroPrendas_old');
    rename(m2,'maestroPrendas');
end;

