program ejercicio3TP3;
const
type
    novela=record
        codigo:integer;
        genero:string[15];
        nombre: string[15];
        duracion: real;
        director: string[25];
        precio:real;
    end;
    archivo = file of novela;
procedure leerNovela(var n:novela);
begin
    writeln('Ingrese codigo de la novela');
    readln(n.codigo);
    if(n.codigo <> -1) then
        begin
            writeln('Ingrese el genero de la novela');
            readln(n.genero);
            writeln('Ingrese el nombre de la novela');
            readln(n.nombre);
            writeln('Ingrese la duracion de la novela');
            readln(n.duracion);
            writeln('Ingrese el director de la novela');
            readln(n.director);
            writeln('Ingrese el precio de la novela');
            readln(n.precio);
        end;
end;
procedure crearArchivo(var arc: archivo);
var
    n: novela;
    nombre: string;
begin
    writeln('Ingrese el nombre del archivo');
    readln(nombre);
    assign(arc, nombre);
    rewrite(arc);
    n.codigo:= 0;
    n.genero:= '';
    n.nombre:= '';
    n.duracion:= 0;
    n.director:= '';
    n.precio:= 0;
    write(arc, n);
    leerNovela(n);
    while(n.codigo <> -1) do
        begin
            write(arc, n);
            leerNovela(n);
        end;
    close(arc);
    writeln('Archivo generado correctamente');
end;
procedure alta(var arc: archivo);
var
    n, aux: novela;
    sigLibre,posLibre:integer;
begin
    reset(arc);
    read(arc, aux);
    leerNovela(n);
    if(aux.codigo = 0) then
        begin
            seek(arc, filesize(arc));
            write(arc, n);
        end
    else
        begin
            // Hay espacio libre → reutilizar
        posLibre := aux.codigo * -1;
        seek(arc, posLibre);
        read(arc, aux); // aux ahora contiene el "enlace" al siguiente espacio libre
        sigLibre := aux.codigo;

        seek(arc, posLibre);
        write(arc, n);

        // Actualizar cabecera con el nuevo primer libre
        seek(arc, 0);
        aux.codigo := sigLibre;
        write(arc, aux);
    end;
    close(arc);
end;
procedure modificarNovela(var n: novela);
var
    opcion: char;
begin
    writeln('MENU DE NOVELAS');
    writeln('Opcion A: Modificar la novela entera (el codigo no puede ser modificado)');
    writeln('Opcion B: Modificar el genero de la novela');
    writeln('Opcion C: Modificar el nombre de la novela');
    writeln('Opcion D: Modificar la duracion de la novela');
    writeln('Opcion E: Modificar el director de la novela');
    writeln('Opcion F: Modificar el precio de la novela');
    readln(opcion);
    case opcion of
        'A': 
            begin
                writeln('Ingrese el genero de la novela');
                readln(n.genero);
                writeln('Ingrese el nombre de la novela');
                readln(n.nombre);
                writeln('Ingrese la duracion de la novela');
                readln(n.duracion);
                writeln('Ingrese el director de la novela');
                readln(n.director);
                writeln('Ingrese el precio de la novela');
                readln(n.precio);
            end;
        'B': 
            begin
                writeln('Ingrese el genero de la novela');
                readln(n.genero);
            end;
        'C':
            begin
                writeln('Ingrese el nombre de la novela');
                readln(n.nombre);
            end;
        'D':
            begin
                writeln('Ingrese la duracion de la novela');
                readln(n.duracion);
            end;
        'E':
            begin
                writeln('Ingrese el director de la novela');
                readln(n.director);
            end;
        'F':
            begin
                writeln('Ingrese el precio de la novela');
                readln(n.precio);
            end;
    else
        writeln('Opcion invalida');
    end;
end;
procedure modificarNovela(var arc: archivo);
var
    n: novela;
    cod: integer;
    ok: boolean;
begin
    ok:= false;
    reset(arc);
    writeln('Ingrese el codigo de novela a modificar');
    readln(cod);
    while(not eof(arc) and (not ok)) do
        begin
            read(arc, n);
            if(n.codigo = cod) then
                begin
                    ok:= true;
                    modificarNovela(n);
                    seek(arc, filepos(arc)-1);
                    write(arc, n);
                end;
        end;
    if(ok) then
        writeln('Se modifico la novela con codigo ', cod)
    else
        writeln('No se encontro la novela con codigo ', cod);
    close(arc);
end;
procedure bajaNovela(var arc:archivo);
var
    nro:integer;
    n,cabecera:novela;
    posEliminar:integer;
    encontre:boolean;
begin
    encontre:=false;
    writeln('Ingrese el codigo de la novela a eliminar:  ');
    readln(nro);
    reset(arc);
    while(not eof(arc)and not encontre)do
    begin
        read(arc,n);
        if(n.codigo = nro)then
        begin
            posEliminar:= filepos(arc)-1;

            //Leo cabecera
            seek(arc,0);
            read(arc,cabecera);

            //Enlazo el reg eliminado con la cabecera
            n.codigo:= cabecera.codigo;

            // Voy a la posicion del registro eliminado
            seek(arc,posEliminar);
            write(arc,n);
            cabecera.codigo := posEliminar * -1;
            seek(arc,0);
            write(arc,cabecera);
            encontre:=true;
            writeln('Se ha eliminado correctamente la novela');
        end;   
    end;
    if(encontre = false)then writeln('La novela con el codigo ingresado no existe');

end;
procedure pasarTxt(var arc: archivo);
var
    txt: text;
    n: novela;
begin
    reset(arc);
    seek(arc, 1);
    assign(txt, 'novelas.txt');
    rewrite(txt);
    while(not eof(arc)) do
        begin
            read(arc, n);
            if(n.codigo < 1) then
                write(txt, 'Novela eliminada: ');
            write(txt, ' Codigo=', n.codigo, ' Genero=', n.genero, ' Nombre=', n.nombre, ' Duracion=', n.duracion:0:2, ' Director=', n.director, ' Precio=', n.precio:0:2);
        end;
    writeln('Archivo de texto creado');
    close(arc);
    close(txt);
procedure menu();
var
    arc: archivo;
    opcion: integer;
begin
    writeln('MENU DE OPCIONES');
    writeln('Opcion 1: Crear el archivo');
    writeln('Opcion 2: Dar de alta una novela');
    writeln('Opcion 3: Modificar los datos de una novela');
    writeln('Opcion 4: Eliminar una novela');
    writeln('Opcion 5: Listar en un archivo de texto todas las novelas, incluyendo las borradas');
    writeln('Opcion 6: Imprimir archivo');
    writeln('Opcion 7: Salir del menu');
    readln(opcion);
    while(opcion <> 7) do
        begin
            case opcion of
                1: crearArchivo(arc);
                2: alta(arc);
                3: modificarNovela(arc);
                4: baja(arc);
                5: pasarTxt(arc);
                6: imprimirArchivo(arc);
            else
                writeln('Opcion invalida');
            end;
            writeln('MENU DE OPCIONES');
            writeln('Opcion 1: Crear el archivo');
            writeln('Opcion 2: Dar de alta una novela');
            writeln('Opcion 3: Modificar los datos de una novela');
            writeln('Opcion 4: Eliminar una novela');
            writeln('Opcion 5: Listar en un archivo de texto todas las novelas, incluyendo las borradas');
            writeln('Opcion 6: Imprimir archivo');
            writeln('Opcion 7: Salir del menu');
            readln(opcion);
        end;
end;
begin
    menu;
end.