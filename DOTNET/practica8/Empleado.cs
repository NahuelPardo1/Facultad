class Empleado(string nombre, int legajo) : IComparable
{
    public string Nombre { get; } = nombre;
    public int Legajo { get; } = legajo;
    public void Imprimir()
     => Console.WriteLine($"Soy {Nombre}, legajo {Legajo}");
    public int CompareTo(object? obj)
    {
       int result = 0;
       if (obj is Empleado e)
       {
           string nombre = e.Nombre;
           result = this.Nombre.CompareTo(nombre);
       }
       return result;
    }
}