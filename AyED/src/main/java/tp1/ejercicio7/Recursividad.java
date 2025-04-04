package tp1.ejercicio7;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Recursividad {
    public List<Integer> calcularSucesion (int n) {
        List<Integer> sucesion = new ArrayList<>();
        calcularSucesionRecursivo(n,sucesion);
        return sucesion;
    }

    private void calcularSucesionRecursivo(int n,List<Integer> sucesion){
        sucesion.add(n);
        if(n==1){
            return;
        }
        if(n%2==0){
            calcularSucesionRecursivo(n/2,sucesion);
        } else {
            calcularSucesionRecursivo((n*3)+1,sucesion);
        }
    }
    public static void invertirArrayList(ArrayList<Integer> lista){
        invertirRecursivo(lista,0,lista.size()-1);
    }
    private static void invertirRecursivo(ArrayList<Integer> lista, int inicio, int fin) {
        if (inicio >= fin) {
            return; // Caso base: cuando los índices se cruzan, se detiene la recursión
        }
        // Intercambiar elementos
        int temp = lista.get(inicio);
        lista.set(inicio, lista.get(fin));
        lista.set(fin, temp);

        // Llamada recursiva con los siguientes índices internos
        invertirRecursivo(lista, inicio + 1, fin - 1);
    }
    public int sumarLinkedList(LinkedList<Integer> lista){
        return sumarRecursivo(lista,0);
    }

    private int sumarRecursivo(LinkedList<Integer> lista, int index){
        if(index>= lista.size()){
            return 0;
        }
        return lista.get(index)+sumarRecursivo(lista,index+1);
    }
    public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
        ArrayList<Integer> aux = new ArrayList<>();
        int i=0, j = 0;
        while(i<lista1.size() && j< lista2.size()){
            if (lista1.get(i)< lista2.get(j)){
                aux.add(lista1.get(i));
                i++;
            } else {
                aux.add(lista2.get(j));
                j++;
            }
        }
        while (i < lista1.size()) {
            aux.add(lista1.get(i));
            i++;
        }
        while (j <lista2.size()) {
            aux.add(lista2.get(j));
            j++;
        }
        return aux;
    }
    public static void main(String[] args) {
        Recursividad es = new Recursividad();
        List<Integer> resultado = es.calcularSucesion(6);
        System.out.println(resultado);
        ArrayList<Integer> num = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        System.out.println("Lista original: "+num);
        invertirArrayList(num);
        System.out.println("Lista invertida: "+ num);
        LinkedList<Integer> numeros = new LinkedList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        int suma = es.sumarLinkedList(numeros);
        System.out.println("Suma de la lista: "+ suma);
        ArrayList<Integer> lista1 = new ArrayList<>(List.of(1, 3, 5, 7));
        ArrayList<Integer> lista2 = new ArrayList<>(List.of(2, 4, 6, 8, 10));

        ArrayList<Integer> listaCombinada = es.combinarOrdenado(lista1, lista2);
        System.out.println("Lista combinada ordenada: " + listaCombinada);
    }
}
