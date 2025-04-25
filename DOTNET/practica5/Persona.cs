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
    public Object this [int i]{
        get{
            if(i==0){
                return Nombre;
            }else if(i==1){
                return Sexo;
            }else if(i==2){
                return DNI;
            }else if(i==3){
                return FechaNacimiento;
            }else if(i==4){
                DateTime hoy = DateTime.Today;
                int edad = hoy.Year - FechaNacimiento.Year;
                if(FechaNacimiento.Date > hoy.AddYears(-edad)){
                edad--;
                }
                return edad;
            }else{
                return 0;
            }
        }

        set{
            if(i==0){
                Nombre=(string)value;
            }else if(i==1){
                Sexo=(char)value;
            }else if(i==2){
                DNI=(int)value;
            }else if(i==3){
                FechaNacimiento=(DateTime)value;
            }else if(i==4){
                int edad= (int)value;
            }
        }
    }

}