package tp2.ejercicio3;
import tp2.ejercicio1.BinaryTree;
import java.util.LinkedList;
import java.util.List;

public class ContadorArbol {
    private BinaryTree<Integer> arbol;

    public ContadorArbol(BinaryTree<Integer> arbol){
        this.arbol=arbol;
    }

    public List<Integer> numerosParesPre(){
        List<Integer> l = new LinkedList<Integer>();
        if(!arbol.isEmpty()) this.nParesPRE(l,arbol);
        return l;

    }
    private void nParesPRE(List<Integer>l, BinaryTree<Integer> a){
        if(a.getData()%2==0) l.add(a.getData());
        if(a.hasLeftChild()) nParesPRE(l,a.getLeftChild());
        if(a.hasRightChild()) nParesPRE(l,a.getRightChild());
    }

    public List<Integer> numerosParesIn() {
        List<Integer> l = new LinkedList<Integer>();
        if(!arbol.isEmpty()) this.nParesIN(l, arbol);
        return l;
    }

    private void nParesIN(List<Integer> l, BinaryTree<Integer> a) {
        if(a.hasLeftChild()) nParesIN(l, a.getLeftChild());
        if(a.getData()%2==0) l.add(a.getData());
        if(a.hasRightChild()) nParesIN(l, a.getRightChild());
    }

    public List<Integer> numerosParesPost() {
        List<Integer> l = new LinkedList<Integer>();
        if(!arbol.isEmpty()) this.nParesPOST(l, arbol);
        return l;
    }

    private void nParesPOST(List<Integer> l, BinaryTree<Integer> a) {
        if(a.hasLeftChild()) nParesPOST(l, a.getLeftChild());
        if(a.hasRightChild()) nParesPOST(l, a.getRightChild());
        if(a.getData()%2==0) l.add(a.getData());
    }

}
