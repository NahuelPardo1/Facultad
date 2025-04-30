package tp2.ejercicio5;

import tp2.ejercicio1.BinaryTree;

public class ProfundidadDeArbolBinario {
    private BinaryTree<Integer> arbol;

    public ProfundidadDeArbolBinario(BinaryTree<Integer> a){
        this.arbol = a;
    }

    public int sumaElementosProfundidad(int p){
        return (!arbol.isEmpty()) ? sumaElementosProfundidadRec(p, arbol,0) : 0;
    }

    private int sumaElementosProfundidadRec(int p, BinaryTree<Integer> a,int nivAct){
        if(p == nivAct){
            return a.getData();
        } else {
            int suma = 0;
            if(a.hasLeftChild()) suma += sumaElementosProfundidadRec(p,a.getLeftChild(),nivAct+1);
            if(a.hasRightChild()) suma += sumaElementosProfundidadRec(p,a.getRightChild(),nivAct+1);
            return suma;
        }
    }

    public static void main(String[] args) {
        System.out.println("Test Profundidad");
        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        System.out.println(ab.toString());
        ProfundidadDeArbolBinario prof = new ProfundidadDeArbolBinario(ab);
        System.out.println(prof.sumaElementosProfundidad(2));
    }
}
