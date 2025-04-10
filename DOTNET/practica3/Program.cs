// Ejercicio 1
// Console.CursorVisible = false;
// ConsoleKeyInfo k = Console.ReadKey(true);
// while (k.Key != ConsoleKey.End)
// {
// Console.Clear();
// Console.Write($"{k.Modifiers}-{k.Key}-{k.KeyChar}");
// k = Console.ReadKey(true);
// }

// Ejercicio 2
// void ImprimirMatriz(double[,] matriz){
//     for (int i = 0; i < matriz.GetLength(0); i++)
//     {
//         for (int j = 0; j < matriz.GetLength(1); j++)
//         {
//             Console.Write(matriz[i, j] + "\t");
//         }
//         Console.WriteLine();
//     }
// }
// double [,] matriz = new double[,]{{1,2,3},{4,5,6}};
// ImprimirMatriz(matriz); 

// Ejercicio 3
// void ImprimirMatrizConFormato(double[,] matriz, string formatString)
// {
//     for (int i = 0; i < matriz.GetLength(0); i++)
//     {
//         for (int j = 0; j < matriz.GetLength(1); j++)
//         {
//             Console.Write(matriz[i, j].ToString(formatString) + "\t");
//         }
//         Console.WriteLine();
//     }
// }

// double[,] matriz = new double[,] { { 1.234, 2.345, 3.456 }, { 4.567, 5.678, 6.789 } };
// ImprimirMatrizConFormato(matriz, "0.0");

// Ejercicio 4
// double[] GetDiagonalPrincipal(double[,] matriz){
//     if(matriz.GetLength(0) != matriz.GetLength(1)){
//         throw new ArgumentException("La matriz no es cuadrada.");
//     }
//     double[] diagonal = new double[matriz.GetLength(0)];
//     for (int i = 0; i < matriz.GetLength(0); i++)
//     {
//         diagonal[i] = matriz[i, i];
//     }
//     return diagonal;
// }

// double[] GetDiagonalSecundaria(double[,] matriz){
//     if(matriz.GetLength(0) != matriz.GetLength(1)){
//         throw new ArgumentException("La matriz no es cuadrada.");
//     }
//     double[] diagonal = new double[matriz.GetLength(0)];
//     for (int i = 0; i < matriz.GetLength(0); i++)
//     {
//         diagonal[i] = matriz[i, matriz.GetLength(1) - 1 - i];
//     }
//     return diagonal;
// }

// double[,] matriz = new double[,] { { 1, 2 }, { 4, 5 }, { 7, 8} };

// try
// {
//     double[] diagonalPrincipal = GetDiagonalPrincipal(matriz);
//     Console.WriteLine("Diagonal Principal: " + string.Join(", ", diagonalPrincipal));

//     double[] diagonalSecundaria = GetDiagonalSecundaria(matriz);
//     Console.WriteLine("Diagonal Secundaria: " + string.Join(", ", diagonalSecundaria));
// }
// catch (ArgumentException ex)
// {
//     Console.WriteLine("Error: " + ex.Message);
// }

// Ejercicio 5
// double[][] GetArregloDeArreglo(double [,] matriz){
//     double[][] arreglo = new double[matriz.GetLength(0)][];
//     for (int i = 0; i < matriz.GetLength(0); i++)
//     {
//         arreglo[i] = new double[matriz.GetLength(1)];
//         for (int j = 0; j < matriz.GetLength(1); j++)
//         {
//             arreglo[i][j] = matriz[i, j];
//         }
//     }
//     return arreglo;
// }

// double[,] matriz = new double[,] { { 1, 2,3 }, { 4, 5,6 }, { 7, 8,9 } };
// double [][] arreglo = GetArregloDeArreglo(matriz);
// for (int i = 0; i < arreglo.Length; i++)
// {
//     for (int j = 0; j < arreglo[i].Length; j++)
//     {
//         Console.Write(arreglo[i][j] + "\t");
//     }
//     Console.WriteLine();
// }

// Ejercicio 6
// double[,]? Suma(double[,] A, double[,] B){
//     if((A.GetLength(0)==B.GetLength(0))&&(A.GetLength(1)==B.GetLength(1))){
//         double[,] resultado = new double[A.GetLength(0),A.GetLength(1)];
//         for(int i=0; i<A.GetLength(0); i++){
//             for(int j=0; j<A.GetLength(1); j++){
//                 resultado[i,j]= A[i,j] + B[i,j];
//             }
//         }
//         return resultado;
            
//     } else
//         return null;
    
// }
// double[,]? Resta(double[,] A, double[,] B){
//     if((A.GetLength(0)==B.GetLength(0))&&(A.GetLength(1)==B.GetLength(1))){
//         double[,] resultado = new double[A.GetLength(0),A.GetLength(1)];
//         for(int i=0; i<A.GetLength(0); i++){
//             for(int j=0; j<A.GetLength(1); j++){
//                 resultado[i,j]= A[i,j] - B[i,j];
//             }
//         }
//         return resultado;
            
//     } else
//         return null;
// }
// double[,] Multiplicacion(double[,] A, double[,] B){
//     if(A.GetLength(1)==B.GetLength(0)){
//         double[,] resultado = new double [A.GetLength(0),B.GetLength(1)]
//         for(int i=0;i<A.GetLength(0);i++){
//             for(int j=0; i<B.GetLength(1); j++){
//                 resultado[i,j]=0;
//                 for(int k=0; k<A.GetLength(1);k++){
//                     resultado[i,j]+= A[i,k]* B[k,j];
//                 }
//             }
//         }
//         return resultado;
//     }
//     else
//     {
//         throw new ArgumentException("No pibe");
//     }
// }

// Ejercicio 7
// int i = 10; // Int
// var x = i * 1.0; //Double
// var y = 1f; // Float
// var z = i * y; // Float

// Ejercicio 8
// bool VerificarParentesisBalanceados(string expresion)
// {
//     Stack<char> pila = new Stack<char>();

//     foreach (char c in expresion)
//     {
//         if (c == '(')
//         {
//             // Si es un paréntesis de apertura, lo agregamos a la pila
//             pila.Push(c);
//         }
//         else if (c == ')')
//         {
//             // Si es un paréntesis de cierre, verificamos si la pila está vacía
//             if (pila.Count == 0)
//             {
//                 // Si la pila está vacía, significa que hay un paréntesis de cierre sin apertura
//                 return false;
//             }
//             // Extraemos el último paréntesis de apertura de la pila
//             pila.Pop();
//         }
//     }

//     // Al finalizar, la pila debe estar vacía para que la expresión sea válida
//     return pila.Count == 0;
// }
// Ejercicio 13
string ConvertirBase(int numero, int baseDestino)
{
    if (baseDestino < 2 || baseDestino > 36)
    {
        throw new ArgumentException("La base debe estar entre 2 y 36.");
    }

    Stack<int> pila = new Stack<int>();
    int cociente = numero;

    // Realizar divisiones sucesivas y almacenar los restos en la pila
    while (cociente > 0)
    {
        int resto = cociente % baseDestino;
        pila.Push(resto);
        cociente /= baseDestino;
    }

    // Construir el resultado leyendo los restos de la pila
    string resultado = "";
    while (pila.Count > 0)
    {
        int digito = pila.Pop();
        // Convertir el dígito a carácter (para bases mayores a 10)
        if (digito < 10)
        {
            resultado += digito.ToString();
        }
        else
        {
            resultado += (char)('A' + digito - 10); // Para bases mayores a 10 (A-Z)
        }
    }

    return resultado;
}

// Ejemplo de uso
int numero = 35;
int baseDestino = 2;

try
{
    string resultado = ConvertirBase(numero, baseDestino);
    Console.WriteLine($"El número {numero} en base {baseDestino} es: {resultado}");
}
catch (ArgumentException ex)
{
    Console.WriteLine("Error: " + ex.Message);
}