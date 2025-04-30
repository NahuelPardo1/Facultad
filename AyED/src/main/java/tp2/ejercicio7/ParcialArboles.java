package tp2.ejercicio7;

import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {
    BinaryTree<Integer> a;

    public ParcialArboles(BinaryTree<Integer>a){
        this.a = a;
    }

    private boolean isLeftTree(BinaryTree<Integer>a){
        int ramaIzq = -1;
        int ramaDer = -1;
        if(a.hasLeftChild()) ramaIzq = contarUnicoHijo(a.getLeftChild());
        if(a.hasRightChild()) ramaDer = contarUnicoHijo(a.getRightChild());
        return ramaIzq > ramaDer;
    }

    private BinaryTree<Integer> buscar(BinaryTree<Integer> a,int num){
        if(a.getData()==num) return a;
        BinaryTree<Integer> res = new BinaryTree<Integer>();
        if(a.hasLeftChild()){
            res= buscar(a.getLeftChild(),num);
        }
        if(a.hasRightChild()){
            res = buscar(a.getRightChild(),num);
        }
        return res;
    }
    private int contarUnicoHijo(BinaryTree<Integer> arb) {
        int cant = 0;
        if(arb.hasLeftChild()) cant += contarUnicoHijo(arb.getLeftChild());
        if(arb.hasRightChild()) cant += contarUnicoHijo(arb.getRightChild());
        if( (arb.hasLeftChild() && !arb.hasRightChild()) || (!arb.hasLeftChild() && arb.hasRightChild())) cant++;
        return cant;
    }

    public boolean isLeftTree(int num) {
        BinaryTree<Integer> arb = buscar(a, num);
        return (!arb.isEmpty()) ? isLeftTree(arb) : false;
    }

}
