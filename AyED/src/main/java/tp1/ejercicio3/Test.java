package tp1.ejercicio3;

public class Test {
    public static void main(String[] args) {
        Profesor carlos = new Profesor("Uriarte","Carlos", "Carlitos@gmail.com","AyED","Facultad de informatica");
        Profesor Juan = new Profesor("Fernandez","Juan", "Juan@gmail.com","Fod","Facultad de informatica");
        Profesor Mario = new Profesor("Rodriguez","Mario", "Mario@gmail.com",".NET","Facultad de informatica");
        Estudiante Nahuel = new Estudiante("Nahuel", "Pardo","Turno 2 B","Nahuel@gmail.com","2 entre 58 y 59");
        Estudiante JuanPablo = new Estudiante("Juan", "Schmid","Turno 1 A","Juan@gmail.com","212 entre 1 y 2");
        Estudiante Yonathan = new Estudiante("Yoni", "Hiriart","Turno 5 A","Yoni@gmail.com","10 entre 58 y 57");
        Estudiante [] estudiantes = new Estudiante[]{Nahuel,JuanPablo,Yonathan};
        Profesor[] profesores = new Profesor[]{carlos,Juan,Mario};
        for(Estudiante es: estudiantes){
            System.out.println(es.tusDatos());
            System.out.println();
        }
        System.out.println();
        for(Profesor pr: profesores){
            System.out.println(pr.tusDatos());
            System.out.println();
        }
    }
}
