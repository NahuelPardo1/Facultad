package tp1.ejercicio8;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Queue<T> extends Sequence  {
    protected LinkedList<T> elementos;
    public Queue(){
        this.elementos= new LinkedList<>();
    }
    public void enqueue(T dato){
        elementos.addLast(dato);
    }
    public T head(){
        if(elementos.isEmpty()){
            throw new NoSuchElementException("La cola está vacia");
        }
        return elementos.getFirst();
    }
    public T dequeue(){
        if(elementos.isEmpty()){
            throw new NoSuchElementException("La cola está vacia");
        }
        return elementos.removeFirst();
    }

    @Override
    public int size(){
        return elementos.size();
    }

    @Override
    public boolean isEmpty() {
        return (elementos.size()==0);
    }

    @Override
    public String toString(){
        String str = "[";
        for(T d: elementos)
            str = str + d +", ";
        str = str.substring(0, str.length()-2)+"]";
        return str;
    }

    public static void main(String[] args) {
        Queue<Integer> cola = new Queue<>();
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        System.out.println("Cola: "+ cola);
        System.out.println("Primer elemento: " + cola.head());
        System.out.println("Desencolando: " + cola.dequeue());
        System.out.println("Cola después de dequeue: " + cola);
        System.out.println("Tamaño de la cola: " + cola.size());
        System.out.println("¿Está vacía? " + cola.isEmpty());
    }

}
