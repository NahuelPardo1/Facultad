package parcialesYTeoria.parcial3;

import tp3.ejercicio1.GeneralTree;

import java.util.ArrayList;
import java.util.List;

public class ComparadorDeArbolesGenerales {
    public boolean esInferiorProfundo(GeneralTree<Integer> arbol1, GeneralTree<Integer> arbol2){
        if(arbol1.getData()> arbol2.getData()){
            return false;
        }else if(arbol1.isLeaf() && arbol2.isLeaf()) return true;
        else{
            if(arbol1.hasChildren() && arbol2.hasChildren()){
                int cant1=0;
                int cant2=0;
                cant1 += contarValores(arbol1);
                cant2 += contarValores(arbol2);
                if(cant1>cant2){
                    return false;
                }
                List<GeneralTree<Integer>> children1 = arbol1.getChildren();
                List<GeneralTree<Integer>> children2 = arbol2.getChildren();
                int min = Math.min(children1.size(),children2.size());
                for(int i =0; i<min; i++){
                    if(!esInferiorProfundo(children1.get(i),children2.get(i))) return false;
                }
            }else if(!arbol1.isLeaf() && arbol2.isLeaf()) return false;
            return true;
        }
    }

    private int contarValores(GeneralTree<Integer> a){
        int aux=0;
        if(a.hasChildren()){
            List<GeneralTree<Integer>> children = a.getChildren();
            for(GeneralTree<Integer> child: children){
                aux+=child.getData();
            }
        }
        return aux;
    }

    public static void main(String[] args) {
        GeneralTree<Integer> a1_h1 = new GeneralTree<>(4);
        GeneralTree<Integer> a1_h2 = new GeneralTree<>(3);
        GeneralTree<Integer> a1_h3 = new GeneralTree<>(2);
        List<GeneralTree<Integer>> hijos1 = new ArrayList<>();
        hijos1.add(a1_h1);
        hijos1.add(a1_h2);
        hijos1.add(a1_h3);
        GeneralTree<Integer> arbol1 = new GeneralTree<>(10, hijos1);

        // arbol2
        GeneralTree<Integer> a2_h1 = new GeneralTree<>(8, List.of(
                new GeneralTree<>(2),
                new GeneralTree<>(1)
        ));
        GeneralTree<Integer> a2_h2 = new GeneralTree<>(5);
        GeneralTree<Integer> a2_h3 = new GeneralTree<>(4, List.of(
                new GeneralTree<>(2),
                new GeneralTree<>(1)
        ));
        List<GeneralTree<Integer>> hijos2 = new ArrayList<>();
        hijos2.add(a2_h1);
        hijos2.add(a2_h2);
        hijos2.add(a2_h3);
        GeneralTree<Integer> arbol2 = new GeneralTree<>(15, hijos2);
        // CASO 1 – Debería devolver TRUE
        GeneralTree<Integer> a1_1 = new GeneralTree<>(4);
        GeneralTree<Integer> a1_2 = new GeneralTree<>(3);
        GeneralTree<Integer> a1_3 = new GeneralTree<>(2);
        GeneralTree<Integer> arbol1_caso1 = new GeneralTree<>(10, List.of(a1_1, a1_2, a1_3));

        GeneralTree<Integer> a2_1 = new GeneralTree<>(8, List.of(new GeneralTree<>(2), new GeneralTree<>(1)));
        GeneralTree<Integer> a2_2 = new GeneralTree<>(5);
        GeneralTree<Integer> a2_3 = new GeneralTree<>(4, List.of(new GeneralTree<>(2), new GeneralTree<>(1)));
        GeneralTree<Integer> arbol2_caso1 = new GeneralTree<>(15, List.of(a2_1, a2_2, a2_3));
        // CASO 2 – Debería devolver FALSE (regla 1)
        GeneralTree<Integer> arbol1_caso2 = new GeneralTree<>(17);
        GeneralTree<Integer> arbol2_caso2 = new GeneralTree<>(15);
        // CASO 3 – Debería devolver FALSE (regla 2)
        GeneralTree<Integer> a1_3_1 = new GeneralTree<>(4);
        GeneralTree<Integer> a1_3_2 = new GeneralTree<>(4);
        GeneralTree<Integer> arbol1_caso3 = new GeneralTree<>(10, List.of(a1_3_1, a1_3_2));

        GeneralTree<Integer> a2_3_1 = new GeneralTree<>(3);
        GeneralTree<Integer> a2_3_2 = new GeneralTree<>(3);
        GeneralTree<Integer> arbol2_caso3 = new GeneralTree<>(15, List.of(a2_3_1, a2_3_2));
        // Comparación
        ComparadorDeArbolesGenerales comparador = new ComparadorDeArbolesGenerales();
        System.out.println(arbol1.toString());
        System.out.println(arbol2.toString());

        boolean resultado = comparador.esInferiorProfundo(arbol1, arbol2);
        System.out.println("¿arbol1 es profundamente inferior a arbol2?: " + resultado);
        System.out.println("Caso 1 (esperado TRUE): " + comparador.esInferiorProfundo(arbol1_caso1, arbol2_caso1));
        System.out.println("Caso 2 (esperado FALSE): " + comparador.esInferiorProfundo(arbol1_caso2, arbol2_caso2));
        System.out.println("Caso 3 (esperado FALSE): " + comparador.esInferiorProfundo(arbol1_caso3, arbol2_caso3));
    }
}
