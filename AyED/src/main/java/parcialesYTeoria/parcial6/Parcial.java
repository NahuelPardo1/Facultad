package parcialesYTeoria.parcial6;

import tp2.ejercicio1.BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class Parcial {
    public static List<Integer> resolver(BinaryTree<Integer> a, int min){
        List<Integer> lista = new LinkedList<Integer>();
        List<Integer> camino = new LinkedList<Integer>();
        if(!a.isEmpty()){
            resolver(a,min,0,lista,camino);
        }
        return camino;
    }

    private static void resolver(BinaryTree<Integer> a, int min,int cant, List<Integer>l,List<Integer>cam){
        l.add(a.getData());
        if(a.getData()%2==0){
           cant++;
        }
        if(a.isLeaf()){
            if(cant>= min){
                cam.clear();
                cam.addAll(l);
            }
        }else{
            if (a.hasLeftChild()) {
                resolver(a.getLeftChild(), min, cant, l, cam);
            }
            if (a.hasRightChild()) {
                resolver(a.getRightChild(), min, cant, l, cam);
            }
        }
        l.remove(l.size()-1);
    }

    public static void main(String[] args) {
            BinaryTree<Integer> raiz = new BinaryTree<>(7);

            BinaryTree<Integer> nodo56 = new BinaryTree<>(56);
            BinaryTree<Integer> nodo25 = new BinaryTree<>(25);
            raiz.addLeftChild(nodo56);
            raiz.addRightChild(nodo25);

            BinaryTree<Integer> nodo38 = new BinaryTree<>(38);
            BinaryTree<Integer> nodo31 = new BinaryTree<>(31);
            nodo56.addLeftChild(nodo38);
            nodo56.addRightChild(nodo31);

            BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
            BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
            nodo25.addLeftChild(nodo5);
            nodo25.addRightChild(nodo6);

            BinaryTree<Integer> nodo87 = new BinaryTree<>(87);
            nodo38.addLeftChild(nodo87);

            BinaryTree<Integer> nodo77 = new BinaryTree<>(77);
            BinaryTree<Integer> nodo94 = new BinaryTree<>(94);
            nodo31.addLeftChild(nodo77);
            nodo31.addRightChild(nodo94);

            BinaryTree<Integer> nodo16 = new BinaryTree<>(16);
            BinaryTree<Integer> nodo43 = new BinaryTree<>(43);
            nodo77.addLeftChild(nodo16);
            nodo77.addRightChild(nodo43);

            BinaryTree<Integer> nodo1 = new BinaryTree<>(1);
            nodo94.addLeftChild(nodo1);

            BinaryTree<Integer> nodo9 = new BinaryTree<>(9);
            BinaryTree<Integer> nodo10 = new BinaryTree<>(10);
            nodo43.addLeftChild(nodo9);
            nodo43.addRightChild(nodo10);
            List<Integer> camino = resolver(raiz,3);
        System.out.println(camino);
    }
}
