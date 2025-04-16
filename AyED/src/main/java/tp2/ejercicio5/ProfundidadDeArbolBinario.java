package tp2.ejercicio5;

import tp1.ejercicio8.Queue;
import tp2.ejercicio1.BinaryTree;

public class ProfundidadDeArbolBinario {
    private BinaryTree<Integer> arbol;

    public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol){
        this.arbol=arbol;
    }
    public int sumaElementosProfundidad(int p) {
        return (!arbol.isEmpty()) ? sumaElementosProfundidad(p, arbol, 0) : 0;
    }
    private int sumaElementosProfundidad(int p, BinaryTree<Integer> ab, int nivActual){
        if(p == nivActual) {
            return ab.getData();
        } else {
            int suma = 0;
            if(ab.hasLeftChild()) suma+= sumaElementosProfundidad(p, ab.getLeftChild(), nivActual+1);
            if(ab.hasRightChild()) suma+= sumaElementosProfundidad(p, ab.getRightChild(), nivActual+1);
            return suma;
        }
    }
}
