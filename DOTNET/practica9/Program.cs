void Swap(ref int a, ref int b){
    int aux = a;
    a=b;
    b=aux;
}
int a = 17;
int b = 23;
Swap(ref a, ref b);
Console.WriteLine($"a={a} y b={b}");
