package tp2.ejercicio1;

public class ej1_tp2 {
    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(40);
        BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
        hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
        hijoIzquierdo.addRightChild(new BinaryTree<Integer>(32));
        BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(78);
        arbol.addLeftChild(hijoIzquierdo);
        arbol.addRightChild(hijoDerecho);
        System.out.println(arbol.toString());
        System.out.println(arbol.getData());
    }
}
