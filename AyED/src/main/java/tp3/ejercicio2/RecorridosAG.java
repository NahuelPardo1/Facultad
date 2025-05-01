package tp3.ejercicio2;

import tp3.ejercicio1.GeneralTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RecorridosAG {
    private GeneralTree<Integer> ar;

    public RecorridosAG(){

    }
    public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n){
        List<Integer> l = new ArrayList<>();
        if(!a.isEmpty()){
            numerosImparesMayoresQuePreOrden_private(l,a,n);
        }
        return l;
    }

    private void numerosImparesMayoresQuePreOrden_private(List<Integer> l, GeneralTree<Integer>a , Integer n){
        if((a.getData()% 2 != 0)&& (a.getData()>n)){
            l.add(a.getData());
        }
        if(a.hasChildren()){
            List<GeneralTree<Integer>> children = a.getChildren();
            for(GeneralTree<Integer> child: children){
                numerosImparesMayoresQuePreOrden_private(l,child,n);
            }
        }
    }

    public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n){
        List<Integer> l = new LinkedList<>();
        if(!a.isEmpty()){
            numerosImparesMayoresQueInOrden(a,n,l);
        }
        return l;
    }

    private void numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n, List<Integer> l){
        List<GeneralTree<Integer>> children = a.getChildren();
        if(a.hasChildren()){
            numerosImparesMayoresQueInOrden(children.get(0),n,l);
        }
        int dato = a.getData();
        if(dato % 2 != 0 && dato>n){
            l.add(dato);
        }
        for(int i = 1; i<children.size(); i++){
            numerosImparesMayoresQueInOrden(children.get(i),n,l);
        }
    }

    public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n){
        List<Integer> l = new LinkedList<Integer>();
        if(!a.isEmpty()){
            numerosImparesMayoresQuePostOrden(a,n,l);
        }
        return l;
    }

    private void numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a,Integer n, List<Integer> l){
        List<GeneralTree<Integer>> children = a.getChildren();
        if(a.hasChildren()){
            for(GeneralTree<Integer>child : children){
                numerosImparesMayoresQuePostOrden(child,n,l);
            }
        }
        int dato = a.getData();
        if(dato%2!=0 && dato>n){
            l.add(dato);
        }
    }

    public static void main(String[] args) {
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
        List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
        children2.add(new GeneralTree<Integer>(21));
        children2.add(new GeneralTree<Integer>(22));
        children2.add(new GeneralTree<Integer>(23));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(2, children2);
        List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
        children3.add(new GeneralTree<Integer>(31));
        children3.add(new GeneralTree<Integer>(32));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(3, children3);
        List<GeneralTree<Integer>> childen = new LinkedList<GeneralTree<Integer>>();
        childen.add(a1);childen.add(a2);childen.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(11, childen);

        RecorridosAG rec = new RecorridosAG();
        System.out.println(a.toString());
        System.out.println("PREORDEN:" + rec.numerosImparesMayoresQuePreOrden(a, 0));
        System.out.println("INORDEN:" + rec.numerosImparesMayoresQueInOrden(a, 0));
        System.out.println("POSTORDEN:" + rec.numerosImparesMayoresQuePostOrden(a, 0));
    }
}
