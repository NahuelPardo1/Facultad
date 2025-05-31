package parcialesYTeoria.parcial8;

import tp1.ejercicio8.Queue;
import tp3.ejercicio1.GeneralTree;

import java.util.ArrayList;
import java.util.List;

public class ParcialArboles {
    private GeneralTree<Integer> arbol;

    public ParcialArboles(GeneralTree<Integer> a){
        this.arbol=a;
    }
    public List<Integer> nivel(int num){
        List<Integer> lista = new ArrayList<>();
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        GeneralTree<Integer> aux;
        boolean cumple=true;
        int nivActual=0,nivelCumple=-1;
        cola.enqueue(arbol);
        cola.enqueue(null);
        while(!cola.isEmpty() && cumple){
            aux=cola.dequeue();
            if(aux!= null){
                List<GeneralTree<Integer>> children = aux.getChildren();
                if(children.size()==num){
                    nivelCumple=nivActual;
                    lista.add(aux.getData());
                }
            }else{
                if(nivelCumple==nivActual){
                    cumple=false;
                }
                if(!cola.isEmpty()){
                    nivActual++;
                    cola.enqueue(null);
                }
            }
        }
        return lista;
    }

}
