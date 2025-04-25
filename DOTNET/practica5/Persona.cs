public class Persona{
    public string Nombre{get; set;}
    public char Sexo{get; set;}

    public int DNI{get; set;}

    public DateTime FechaNacimiento{get; set;}

    public int Edad {
        get{
            DateTime hoy = DateTime.Today;
            int edad = hoy.Year - FechaNacimiento.Year;
            if(FechaNacimiento.Date > hoy.AddYears(-edad)){
                edad--;
            }
            return edad;
        }
    }

}