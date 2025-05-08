package parcialesYTeoria.parcial2;

import tp3.ejercicio1.GeneralTree;

import java.util.*;

public class CaminoMasLejano {
    public List<Integer> caminoLejano(GeneralTree<Integer> a){
        List<Integer> l = new ArrayList<Integer>();
        List<Integer> max = new ArrayList<Integer>();
        if(!a.isEmpty()){
            caminoLejano(l,max,a);
        }
        return max;
    }

    private void caminoLejano(List<Integer> l, List<Integer> max, GeneralTree<Integer> a){
        l.add(a.getData());
        if(!a.isLeaf()){
            List<GeneralTree<Integer>> children = a.getChildren();
            for(GeneralTree<Integer> child : children){
                caminoLejano(l,max,a);
            }
        }else if( l.size()>max.size()){
            max.clear();
            max.addAll(l);
        }
        l.removeLast();
    }
}
