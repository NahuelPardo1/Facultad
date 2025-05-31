package parcialesYTeoria.parcial4;

import tp3.ejercicio1.GeneralTree;
import tp1.ejercicio8.Queue;

import java.util.*;

public class ParcialArboles {
    private GeneralTree<Integer> arbol;

    public ParcialArboles(GeneralTree<Integer> a){
        this.arbol=a;
    }

    public List<Integer> nivel(int num){
        List<Integer> lista = new ArrayList<>();
        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
        GeneralTree<Integer> aux;
        boolean cumple= true;
        int nivelAct=0,nivelEnc=-1;
        cola.enqueue(arbol);
        cola.enqueue(null);
        while(!cola.isEmpty() && cumple){
            aux=cola.dequeue();
            if(aux!=null){
                if(aux.hasChildren()){
                    List<GeneralTree<Integer>> children = aux.getChildren();
                    if(children.size() >= num){
                        if(nivelEnc==-1) nivelEnc = nivelAct;
                        if (nivelEnc == nivelAct) lista.add(aux.getData());
                    }
                    for (GeneralTree<Integer> child: children){
                        cola.enqueue(child);
                    }
                }
            }else{
                if(!cola.isEmpty()){
                    if (nivelEnc == nivelAct) cumple=false;
                    nivelAct++;
                    cola.enqueue(null);
                }
            }
        }
        return lista;
    }
}
