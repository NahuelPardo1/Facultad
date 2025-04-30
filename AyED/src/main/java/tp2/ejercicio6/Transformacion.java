package tp2.ejercicio6;

import tp2.ejercicio1.BinaryTree;

public class Transformacion {
    private BinaryTree<Integer> a;

    public Transformacion(BinaryTree<Integer> a){
        this.a = a;
    }

    public BinaryTree<Integer> suma(){
        suma(a);
        return a;
    }
    public BinaryTree<Integer> getAb(){
        return a;
    }

    public int suma(BinaryTree<Integer> a){
        int sum = 0;
        if(a.isLeaf()){
            sum = a.getData();
            a.setData(0);
            return sum;
        }
        if(a.hasLeftChild()){
            sum+= suma(a.getLeftChild());
        }
        if(a.hasRightChild()){
            sum+= suma(a.getRightChild());
        }
        int actual = a.getData();
        a.setData(sum);
        return actual + sum;
    }

    public static void main(String[] args) {
        System.out.println("Test Transformacion");
        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));

        System.out.println(ab.toString());
        Transformacion tras = new Transformacion(ab);
        tras.suma();
        System.out.println();
        System.out.println("Arbol transformado");
        System.out.println(tras.getAb().toString());
    }
}
