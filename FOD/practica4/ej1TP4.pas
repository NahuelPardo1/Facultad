const
    M = .. //orden del arbol
type
    alumno = record
        nombre: string[15];
        apellido: string[15];
        DNI: integer;
        legajo: integer;
        anioIngreso: integer;
    end;
    nodo = record
        cant_datos: integer;
        datos: array[1..M-1] of alumno;
        hijos: array[1..M]of integer;
    end;

    arbolB = file of nodo;

var
    archivoDatos: arbolB;


// N = (M-1)* A + M * B + C
// 512 = (M-1) * 64 + M * 4 + 4
// 512 = 64M - 64 +4M + 4
// 512 + 64 - 4 = 68M
// 572 / 68 = M
// M = 8.4