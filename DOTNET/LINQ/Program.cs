int[] vector = [1, 2, 3, 4, 5];
IEnumerable<int> secuencia = vector.Select(n => n * 3);
Mostrar(secuencia);



void Mostrar<T>(IEnumerable<T> secuencia)
{
   foreach (T elemento in secuencia)
   {
       Console.Write(elemento + " ");
   }
   Console.WriteLine();
}