type
    archivo= file of integer;
var
    enteros: archivo;
    arc_fisico: string[20];
    n: integer;
Begin
    write('Ingrese el nombre del archivo: ');
    readln(arc_fisico);
    assign(enteros, arc_fisico);
    rewrite(enteros);
    read(n);
    while(n<> 30000)do
    begin
        write(enteros,n);
        read(n);
    end;
    writeln(sizeof(enteros));
    close(enteros);
End.