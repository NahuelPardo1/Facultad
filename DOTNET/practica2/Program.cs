/* Ejercicio 1
object o1 = "A";
object o2 = o1;
o2 = "Z";
Console.WriteLine(o1 + " " + o2);

o1 queda apuntando a "A" porque jamas cambio su puntero a otro objeto, o2 apunta a "Z" porque se le asigno ese valor.
*/

/* Ejercicio 2
char c1 = 'A';
string st1 = "A";
object o1 = c1; // Boxing
object o2 = st1; // Boxing
char c2 = (char)o1; // Unboxing
string st2 = (string)o2; // Unboxing
*/

/* Ejercicio 3
    Las diferencias entre las conversiones de tipo implicitas y explicitas son es que las implicitas se realizan cuando no hay una perdida de datos, mientras que las explicitas si pueden haber perdida de datos entonces requieren el consentimiento del programador para realizar la conversion a traves de un cast.
*/

/*Ejercicio 4 
object o = "Hola Mundo!";
string? st = o as string;
int i = 12;
byte b = (byte)i;
double d = i;
float f = (float)d;
o = i;
i = (int)o + 1;
*/

/* Ejercicio 5
    char c1 = 'A';
    string st1 = "A";
    object o1 = c1; // Boxing
    object o2 = st1; // Boxing
    char c2 = (char)o1; // Unboxing
    string st2 = (string)o2; // Unboxing

*/
/* Ejercicio 6
    int i;
    Console.WriteLine(i);
    No compila porque i no tiene un valor asignado
*/

/* Ejercicio 7
    char c1 = 'A';
    char c2 = 'A';
    Console.WriteLine(c1 == c2);
    object o1 = c1;
    object o2 = c2;
    Console.WriteLine(o1 == o2);
    Producen diferentes resultados porque en el primer caso se comparan los valores de los char y en el segundo caso se comparan las referencias de los objetos.
*/

/* Ejercicio 8
    StringBuilder es preferible usarlo cuando se hacen multiples modificaciones sobre una cadena.
    String es preferible usarlo para pocas concatenaciones o cuando la inmutabilidad sea necesaria.

using System.Text;
DateTime inicio= DateTime.Now;
string st="";
for(int i=0; i<5;i++){
    st+="Hola ,";
}
DateTime fin= DateTime.Now;
Console.WriteLine("String: "+(fin-inicio).TotalMilliseconds);
inicio= DateTime.Now;
StringBuilder sb = new StringBuilder();
for(int i=0; i<5;i++){
    sb.Append("Hola ,");
}
fin= DateTime.Now;
Console.WriteLine("StringBuilder: "+(fin-inicio).TotalMilliseconds);
*/
/* Ejercicio 10
using System.Text;
object[] v = new object[10];
v[0] = new StringBuilder("Net");
for (int i = 1; i < 10; i++)
{
v[i] = v[i - 1];
}
(v[5] as StringBuilder).Insert(0, "Framework .");
foreach (StringBuilder s in v)
Console.WriteLine(s);
//dibujar el estado de la pila y la mem. heap
//en este punto de la ejecución
v[5] = new StringBuilder("CSharp");
foreach (StringBuilder s in v)
Console.WriteLine(s);
//dibujar el estado de la pila y la mem. heap
//en este punto de la ejecución
*/
/* Ejercicio 11
    El método Split de la clase String en C# se utiliza para dividir una cadena en un arreglo de subcadenas, utilizando uno o más caracteres o cadenas como delimitadores.
    ej:
        string texto = "Hola mundo en C#";
        string[] palabras = texto.Split(' ');

        foreach (string palabra in palabras)
        {
            Console.WriteLine(palabra);
        }
    salida:
        Hola    
        mundo
        en
        C#
*/
/* Ejercicio 12
enum meses
{
    enero,febrero,marzo,abril,mayo,junio,julio,agosto,septiembre,octubre,noviembre,diciembre
}
class Program{

    static void Main(){
        for(int i=11;i>=0;i--){
        Console.WriteLine((meses)i);
        }
    }
}
*/
/* Ejercicio 13
    si no se pasan argumentos por la linea de comandos, el comportamiento del array args es el siguiente:
    args nunca es null, sino que es un array vacío (string[0]).
    args.Length será 0 porque no hay elementos en el array.
    Console.WriteLine(args == null);
    Console.WriteLine(args.Length);
*/
/* Ejercicio 14
    No, no le asigna el valor null a la variable sino que el int[]? indica que puede ser null pero al hacer = new int[0] se le asigna un array vacio.
*/
/* Ejercicio 15*/


    
