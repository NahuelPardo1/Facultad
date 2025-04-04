package tp1.ejercicio8;

import java.util.NoSuchElementException;

public class CircularQueue<T> extends Queue<T> {
    public T shift() {
        if (isEmpty()) throw new NoSuchElementException("La cola está vacía");

        // Tomar el primer elemento
        T first = elementos.removeFirst();

        // Encolarlo al final
        elementos.addLast(first);

        // Retornar el nuevo frente de la cola
        return elementos.getFirst();
    }
}
