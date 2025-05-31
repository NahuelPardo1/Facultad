class Persona
{
   public string Nombre { get; private set; }
   public int Edad { get; private set; }
   public string Pais { get; private set; }
   public Persona(string nombre, int edad, string pais)
   {
       Nombre = nombre;
       Edad = edad;
       Pais = pais;
   }
   public override string ToString()
   {
      return $"{Nombre} ({Edad} años) {Pais.Substring(0, 3)}.";
   }

   // vamos a hardcodear una lista de personas
   // que usaremos en los siguientes ejemplos
   // para ello definimos el siguiente método estático
   public static List<Persona> GetLista()
   {
       return new List<Persona>() {
           new Persona("Pablo",15,"Argentina"),
           new Persona("Juan", 55,"Argentina"),
           new Persona("José",9,"Uruguay"),
           new Persona("María",33,"Uruguay"),
           new Persona("Lucía",16,"Perú"),
       };
   }
}