package parcialesYTeoria.parcial7;

import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {
    private BinaryTree<Integer> arbol;

    public ParcialArboles(BinaryTree<Integer> a){
        this.arbol=a;
    }

    public BinaryTree<Integer> nuevoTree(){
        BinaryTree<Integer> copia = new BinaryTree<>();
        if(!this.arbol.isEmpty()){
            copia.setData(arbol.getData());
            nuevoTree(arbol,copia);
        }
        return copia;
    }

    private void nuevoTree(BinaryTree<Integer> a, BinaryTree<Integer> c){
        if(a.hasLeftChild()){
            int suma = a.getLeftChild().getData() + a.getData();
            BinaryTree<Integer> child = new BinaryTree<Integer>(suma);
            c.addLeftChild(child);
            nuevoTree(a.getLeftChild(),c.getLeftChild());
        }
        if(a.hasRightChild()){
            BinaryTree<Integer> child = new BinaryTree<Integer>(a.getRightChild().getData());
            c.addRightChild(child);
            nuevoTree(a.getRightChild(),c.getRightChild());
        }
    }
}
