package parcialesYTeoria.parcial1;

import tp2.ejercicio1.BinaryTree;

public class ParcialArboles{
    BinaryTree<Integer> a;

    public ParcialArboles(BinaryTree<Integer> a){
        this.a = a;
    }

    public Boolean isTwoTree(int num){
        a = buscar(num, a);
        return (!a.isEmpty()) ? isTwoTree(a) : false;

    }

    private boolean isTwoTree( BinaryTree<Integer> ar){
        int cantIzq=-1,cantDer=1;
        if(ar.hasLeftChild()) cantIzq += contarDosHijos(ar.getLeftChild());
        if(ar.hasRightChild()) cantDer += contarDosHijos(ar.getRightChild());
        if(cantIzq == cantDer) return true;
        else return false;
    }

    private BinaryTree<Integer> buscar(int num,BinaryTree<Integer> arbol){
        if(arbol.getData()==num){
            return arbol;
        }
        BinaryTree<Integer> res = new BinaryTree<Integer>();
        if(arbol.hasLeftChild()){
            res = buscar(num,arbol.getLeftChild());
        }
        if(arbol.hasRightChild()){
            res = buscar(num,arbol.getRightChild());
        }
        return res;
    }

    private int contarDosHijos(BinaryTree<Integer> arbol){
        int cant=0;
        if(arbol.hasLeftChild()) cant+= contarDosHijos(arbol.getLeftChild());
        if(arbol.hasRightChild()) cant+= contarDosHijos(arbol.getRightChild());
        if(arbol.hasLeftChild() && arbol.hasRightChild()) cant++;
        return cant;
    }
}
