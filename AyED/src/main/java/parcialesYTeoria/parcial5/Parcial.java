package parcialesYTeoria.parcial5;

import tp3.ejercicio1.GeneralTree;

import java.util.ArrayList;
import java.util.List;

public class Parcial {
    private char letra;
    private int num;
    public List<Character> parcial(GeneralTree<Parcial> a){
        List<Character> lista = new ArrayList<>();
        List<Character> cam = new ArrayList<>();
        if(!a.isEmpty()){
            parcial(a,lista,cam);
        }
        return cam;
    }

    private void parcial(GeneralTree<Parcial> a,List<Character>l,List<Character> c){
        l.add(a.getData().letra);
        if(!a.isLeaf()&& a.getData().num<=a.getChildren().size()-1){
            List<GeneralTree<Parcial>> children = a.getChildren();
            parcial(children.get(a.getData().num-1),l,c);
        }else{
            c.clear();
            c.addAll(l);
        }
        l.remove(l.size()-1);
    }
}
