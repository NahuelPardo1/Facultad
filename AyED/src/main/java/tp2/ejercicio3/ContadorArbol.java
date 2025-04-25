package tp2.ejercicio3;

import tp2.ejercicio1.BinaryTree;

import java.util.ArrayList;

public class ContadorArbol {
    private BinaryTree<Integer> a;

    public ContadorArbol(BinaryTree<Integer> unArbol) {
        a = unArbol;
    }
    public ArrayList<Integer> numerosParesIn(){
        ArrayList<Integer> l = new ArrayList<Integer>();
        if(!a.isEmpty()){
            this.paresInOrden(l,a);
        }
        return l;
    }

    private void paresInOrden(ArrayList<Integer>l,BinaryTree<Integer>a){
        if(a.hasLeftChild()) paresInOrden(l,a.getLeftChild());
        if(a.getData()%2==0) l.add(a.getData());
        if(a.hasRightChild()) paresInOrden(l,a.getRightChild());

    }
    public ArrayList<Integer> numerosParesPost(){
        ArrayList<Integer> l = new ArrayList<Integer>();
        if(!a.isEmpty()){
            this.paresPostOrden(l,a);
        }
        return l;
    }

    private void paresPostOrden(ArrayList<Integer>l,BinaryTree<Integer>a){
        if(a.hasLeftChild()) paresInOrden(l,a.getLeftChild());
        if(a.hasRightChild()) paresInOrden(l,a.getRightChild());
        if(a.getData()%2==0) l.add(a.getData());
    }



}
