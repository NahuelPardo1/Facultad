
/* Ejercicio 6
    string cadena ="";
    Console.WriteLine("Ingrese una cadena de texto: ");
    cadena = Console.ReadLine();
    while(cadena != ""){
        Console.WriteLine("La cadena ingresada tiene: " + cadena?.Length + " caracteres");
        Console.WriteLine("Ingrese una cadena de texto: ");
        cadena = Console.ReadLine();
    };
*/

/* ejercicio 10
for (int i = 1; i <= 1000; i++)
        {
            if (i % 17 == 0 || i % 29 == 0)
            {
                Console.WriteLine(i);
            }
        }
*/

/* ejercicio 12
Console.WriteLine("Ingrese un numero: ");
string st = Console.ReadLine();
int num = int.Parse(st);
Console.WriteLine("Los divisores de " + num + " son: ");
for(int i=1;i<=num;i++){
    if(num % i == 0){
        Console.WriteLine(i);
    }
}
*/
int a =12;
int b = 2;
if ((b != 0) && (a/b > 5)) {
    Console.WriteLine(a/b);
}