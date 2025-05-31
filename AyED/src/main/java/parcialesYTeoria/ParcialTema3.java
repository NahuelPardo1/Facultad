package parcialesYTeoria;

import tp3.ejercicio1.GeneralTree;

import java.util.ArrayList;
import java.util.List;

public class ParcialTema3 {

    public static List<List<Integer>> caminosAlternados(GeneralTree<Integer> arbol){
        List<List<Integer>> cam = new ArrayList<List<Integer>>();
        List<Integer> l = new ArrayList<Integer>();
        if(arbol!= null && !arbol.isEmpty()){
            l.add(arbol.getData());
            caminosAlternados(arbol,cam,l,arbol.getData()%3==0);
        }
        return cam;
    }

    public static void caminosAlternados(GeneralTree<Integer> a,List<List<Integer>> cam, List<Integer> l,boolean multiplo){
        if(a.isLeaf()){
            cam.add(l);
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

