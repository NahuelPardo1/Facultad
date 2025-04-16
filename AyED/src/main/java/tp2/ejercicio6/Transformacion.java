package tp2.ejercicio6;

import tp2.ejercicio1.BinaryTree;

public class Transformacion {
    private BinaryTree<Integer> arbol;

    public Transformacion(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    public BinaryTree<Integer> suma(){
        if(!arbol.isEmpty()){

            return arbol;
        } else return null;
    }



}
