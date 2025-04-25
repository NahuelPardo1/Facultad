package tp1.ejercicio7;

import tp1.ejercicio3.Estudiante;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestArrayList {
    public static void main(String[] args) {
        List<Integer> lista = new LinkedList<>();
        for(int i=0; i<args.length; i++){
            lista.add(Integer.parseInt(args[i]));
        }
        System.out.println("La lista tiene "+lista.size()+" elementos");
        for(Integer i : lista){
            System.out.println(i);
        }

        Estudiante Nahuel = new Estudiante("Nahuel", "Pardo","Turno 2 B","Nahuel@gmail.com","2 entre 58 y 59");
        Estudiante JuanPablo = new Estudiante("Juan", "Schmid","Turno 1 A","Juan@gmail.com","212 entre 1 y 2");
        Estudiante Yonathan = new Estudiante("Yoni", "Hiriart","Turno 5 A","Yoni@gmail.com","10 entre 58 y 57");
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(Nahuel);
        estudiantes.add(JuanPablo);
        estudiantes.add(Yonathan);

        List<Estudiante> copia = estudiantes;
        System.out.println("Lista original");
        for(Estudiante e: estudiantes){
            System.out.println(e.tusDatos());
            System.out.println();
        }
        System.out.println();
        System.out.println("Copia");
        for(Estudiante e: copia){
            System.out.println(e.tusDatos());
            System.out.println();
        }

        estudiantes.getFirst().setNombre("Carlitos");
        System.out.println("Lista original");
        for(Estudiante e: estudiantes){
            System.out.println(e.tusDatos());
            System.out.println();
        }
        System.out.println();
        System.out.println("Copia");
        for(Estudiante e: copia){
            System.out.println(e.tusDatos());
            System.out.println();
        }

        if(!estudiantes.contains(Nahuel)){
            estudiantes.add(Nahuel);
        }else{
            System.out.println("Este estudiante ya está en la lista");
        }


    }
}
