package tp3.ejercParcial2;

import tp3.ejercicio1.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class Gematria {
    public static int contadorGematria(GeneralTree<Integer> ag, int valor) {
        int resta = valor - ag.getData();
        if (ag.isLeaf() && resta == 0)
            return 1;
        else {
            int cont = 0;
            if (resta > 0) {
                List<GeneralTree<Integer>> children = ag.getChildren();
                for (GeneralTree<Integer> child: children) {
                    cont = cont + contadorGematria(child, resta);
                }
            }
            return cont;
        }
    }


    public static void main(String[] args) {
        //SUBARBOL IZQUIERDO
        List<GeneralTree<Integer>> padre50 = new LinkedList<>();
        padre50.add(new GeneralTree<Integer>(50));
        GeneralTree<Integer> nodo5 = new GeneralTree<>(5,padre50);
        List<GeneralTree<Integer>> padre5 = new LinkedList<>();
        padre5.add(nodo5);
        GeneralTree<Integer> nodo30 = new GeneralTree<>(30,padre5);
        List<GeneralTree<Integer>> padre30 = new LinkedList<>();
        padre30.add(nodo30);
        GeneralTree<Integer> nodo50_A = new GeneralTree<>(50,padre30);
        List<GeneralTree<Integer>> padre50_A = new LinkedList<>();
        padre50_A.add(new GeneralTree<Integer>(50));
        padre50_A.add(nodo50_A);
        GeneralTree<Integer> nodo10 = new GeneralTree<>(10,padre50_A);
        List<GeneralTree<Integer>> padre10 = new LinkedList<>();
        padre10.add(nodo10);
        GeneralTree<Integer> nodo50_B = new GeneralTree<>(50,padre10);
        //SUBARBOL MEDIO
        List<GeneralTree<Integer>> padre22 = new LinkedList<>();
        padre22.add(new GeneralTree<Integer>(22));
        GeneralTree<Integer> nodo50_C = new GeneralTree<>(50,padre22);
        List<GeneralTree<Integer>> padre50_C = new LinkedList<>();
        padre50_C.add(nodo50_C);
        GeneralTree<Integer> nodo35 = new GeneralTree<>(35,padre50_C);
        List<GeneralTree<Integer>> padre35 = new LinkedList<>();
        padre35.add(new GeneralTree<Integer>(10));
        padre35.add(nodo35);
        GeneralTree<Integer> nodo5_A = new GeneralTree<>(5,padre35);
        List<GeneralTree<Integer>> padre5_A = new LinkedList<>();
        padre5_A.add(nodo5_A);
        GeneralTree<Integer> nodo50_D = new GeneralTree<>(50,padre5_A);
        List<GeneralTree<Integer>> padre50_D = new LinkedList<>();
        padre50_D.add(nodo50_D);
        GeneralTree<Integer> nodo12 = new GeneralTree<>(12,padre50_D);
        //SUBARBOL DERECHO
        List<GeneralTree<Integer>> padre20 = new LinkedList<>();
        padre20.add(new GeneralTree<Integer>(20));
        GeneralTree<Integer> nodo80 = new GeneralTree<>(80,padre20);
        List<GeneralTree<Integer>> padre80 = new LinkedList<>();
        padre80.add(nodo80);
        GeneralTree<Integer> nodo10_A = new GeneralTree<>(10,padre80);
        List<GeneralTree<Integer>> child = new LinkedList<>();
        child.add(nodo50_B);
        child.add(nodo12);
        child.add(nodo10_A);
        child.add(new GeneralTree<Integer>(40));
        GeneralTree<Integer> arbol = new GeneralTree<>(0,child);
        System.out.println(arbol.toString());
        System.out.println(Gematria.contadorGematria(arbol,110));
    }
}
