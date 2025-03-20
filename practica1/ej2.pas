type
    archivo= file of integer;
var
    enteros: archivo;
    arc_fisico: string[20];
    n:integer;
    menores:integer;
    cant,total:integer;
Begin
    total:=0;
    cant:=0;
    menores:=0;
    writeln('Ingrese el nombre del archivo: ');
    readln(arc_fisico);
    assign(enteros, arc_fisico);
    reset(enteros);
    while not eof(enteros) do
    begin
        read(enteros, n);
        if(n<1500)then
        begin
            menores:=menores+1;
        end;
        writeln(n);
        total+=n;
        cant:=cant+1;
    end;
    writeln('La cantidad de numeros menores a 1500 es: ',menores);
    writeln('El promedio de los numeros es: ',total/cant:0:2);
    close(enteros);
End.