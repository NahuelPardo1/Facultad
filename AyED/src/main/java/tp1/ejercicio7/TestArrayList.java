package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.Iterator;

public class TestArrayList {
    public static boolean esCapicua(ArrayList<Integer> lista) {
        int n = lista.size();
        for (int i = 0; i < n / 2; i++) {
            if (!lista.get(i).equals(lista.get(n - 1 - i))) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        for(String arg: args){

            try{
                numeros.add(Integer.parseInt(arg));
            }
            catch (NumberFormatException e){
                System.out.println("Ignorando valor no numerico: "+ arg);

            }
        }
        Iterator<Integer> it = numeros.iterator();
        System.out.println("Contenido de la lista: ");
        while(it.hasNext()){
            System.out.println(it.next());
        }
        ArrayList<estudiante> estudiantes = new ArrayList<estudiante>();
        estudiante nahuel = new estudiante("nahuel","pardo",45433);
        estudiante juan = new estudiante("juan","schmid",45232);
        estudiante valentino= new estudiante("valentino","kvolek",42321);
        estudiantes.add(nahuel);
        estudiantes.add(juan);
        estudiantes.add(valentino);
        ArrayList<estudiante> estudiantes_copiados= new ArrayList<>(estudiantes);
        /*for(estudiante s: estudiantes){
            System.out.println(s.apellido);
            System.out.println(s.nombre);
            System.out.println(s.legajo);
        }
        for (estudiante s: estudiantes_copiados){
            System.out.println(s.apellido);
            System.out.println(s.nombre);
            System.out.println(s.legajo);
        }
        */
        estudiante yoni = new estudiante("yoni","hiriart",43543);
        if(!estudiantes_copiados.contains(yoni)){
            estudiantes_copiados.add(yoni);
        }
        for (estudiante s: estudiantes_copiados){
            System.out.println(s.apellido);
            System.out.println(s.nombre);
            System.out.println(s.legajo);
        }
        ArrayList<Integer> numbers = new ArrayList<>();

        for (String arg : args) {
            try {
                numbers.add(Integer.parseInt(arg));
            } catch (NumberFormatException e) {
                System.out.println("Ignorando valor no numérico: " + arg);
            }
        }

        System.out.println("Contenido de la lista:");
        for (int num : numbers) {
            System.out.println(num);
        }

        // Verificar si la lista es capicúa
        if (esCapicua(numbers)) {
            System.out.println("La lista es capicúa.");
        } else {
            System.out.println("La lista no es capicúa.");
        }
    }
}
