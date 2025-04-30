package tp2.ejercicio4;

import tp2.ejercicio1.BinaryTree;

public class RedBinariaLlena {
    private BinaryTree<Integer> a;

    public RedBinariaLlena(BinaryTree<Integer> ar){
        this.a = ar;
    }
    public int retardoReenvio(){
        int aux = 0;
        if(!a.isEmpty()){
            aux = retardoReenvioRed(this.a);
        }
        return aux;
    }

    private int retardoReenvioRed(BinaryTree<Integer> a){
        int total = a.getData();
        int izq=0,der=0;
        if(a.hasLeftChild()){
            izq = retardoReenvioRed(a.getLeftChild());
        }
        if(a.hasRightChild()){
            der = retardoReenvioRed(a.getRightChild());
        }
        if(izq > der){
            total+= izq;
        }else total+=der;
        return total;
    }

    public static void main(String[] args) {
        System.out.println("Test mayor retardo");
        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(20));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        System.out.println(ab.toString());

        RedBinariaLlena red = new RedBinariaLlena(ab);
        System.out.println("El mayor retardo posible es de: " + red.retardoReenvio() + " segundos");
    }
}
