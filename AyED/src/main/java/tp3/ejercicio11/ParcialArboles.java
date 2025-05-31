package tp3.ejercicio11;

import tp1.ejercicio8.Queue;
import tp3.ejercicio1.GeneralTree;

import java.util.*;

public class ParcialArboles {
    public static boolean resolver(GeneralTree<Integer> arbol){
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        GeneralTree<Integer> aux;
        int cantNodos=0,cantAnterior=0;
        cola.enqueue(arbol);
        cola.enqueue(null);
        while(!cola.isEmpty()){
            aux = cola.dequeue();
            if(aux!= null){
                cantNodos++;
                List<GeneralTree<Integer>> children = aux.getChildren();
                for(GeneralTree<Integer> child: children){
                    cola.enqueue(child);
                }
            }else {
                if (cantAnterior != cantNodos - 1) return false;
                if (!cola.isEmpty()) {
                    cantAnterior = cantNodos;
                    cantNodos = 0;
                    cola.enqueue(null);
                }
            }
        }
        return true;
    }
}
