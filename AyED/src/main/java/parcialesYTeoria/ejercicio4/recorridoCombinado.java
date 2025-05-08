package parcialesYTeoria.ejercicio4;

import tp2.ejercicio1.BinaryTree;

public class recorridoCombinado {
    public static void traverse(BinaryTree<String> a){
        if(!a.isEmpty()){
            System.out.print(a.getData());
            if(a.hasLeftChild()){
                traverse(a.getLeftChild());
            }
            if(a.hasRightChild()){
                traverse(a.getRightChild());
            }
            System.out.print(a.getData());
        }
    }
    public static void main(String[] args) {
        BinaryTree<String> ar = new BinaryTree<>("C");
        ar.addLeftChild(new BinaryTree<>("A"));
        ar.addRightChild(new BinaryTree<>("E"));
        ar.getLeftChild().addRightChild(new BinaryTree<>("B"));
        ar.getRightChild().addRightChild(new BinaryTree<>("F"));
        ar.getRightChild().addLeftChild(new BinaryTree<>("D"));
        System.out.println(ar.toString());
        //C A B B A E D D F F E C
        traverse(ar);
    }
}
