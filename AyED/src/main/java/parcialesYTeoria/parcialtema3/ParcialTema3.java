package parcialesYTeoria.parcialtema3;

import tp3.ejercicio1.GeneralTree;
import java.util.*;

public class ParcialTema3 {

    public static List<List<Integer>> caminosAlternados(GeneralTree<Integer> arbol){
        List<List<Integer>> cam = new ArrayList<List<Integer>>();
        List<Integer> lista = new ArrayList<Integer>();
        if(arbol!= null && !arbol.isEmpty()){
            lista.add(arbol.getData());
            caminosAlternados(arbol,cam,lista,arbol.getData()%3==0);
        }
        return cam;
    }

    private static void caminosAlternados(GeneralTree<Integer> a,List<List<Integer>> cam, List<Integer> l,boolean multiplo){
        if(a.isLeaf()){
            cam.add(new ArrayList<>(l));
        }else{
            List<GeneralTree<Integer>> children = a.getChildren();
            for(GeneralTree<Integer>child : children){
                l.add(child.getData());
                if(child.getData()%3==0 != multiplo){
                    caminosAlternados(child,cam,l,child.getData()%3==0);
                }
                l.remove(l.size()-1);
            }
        }
    }
}
