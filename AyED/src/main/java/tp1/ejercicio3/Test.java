package tp1.ejercicio3;

public class Test {
    public static void main(String[] args) {
        Estudiante[] estudiantes=new Estudiante[2];
        Profesor[] profesores= new Profesor[3];
        for (int i=0;i < profesores.length;i++){
            profesores[i]= new Profesor();
            profesores[i].setNombre("Juansito");
            profesores[i].setApellido("Schmid");
            profesores[i].setCatedra("FOD");
            profesores[i].setEmail("Juansito@gmail.com");
            profesores[i].setFacultad("Ingenieria");
            profesores[i].tusDatos();
        }
        for(int i=0;i<estudiantes.length;i++){
            estudiantes[i]=new Estudiante();
            estudiantes[i].setNombre("Valentino");
            estudiantes[i].setApellido("Kvolek");
            estudiantes[i].setEmail("Valen912@gmail.com");
            estudiantes[i].setComision("3B");
            estudiantes[i].setDireccion("2 entre 59 y 58");
        }
        for (int i=0;i< profesores.length;i++){
            System.out.println(profesores[i].tusDatos());
        }
        for (int i=0;i< estudiantes.length;i++){
            System.out.println(estudiantes[i].tusDatos());
        }




    }
}
