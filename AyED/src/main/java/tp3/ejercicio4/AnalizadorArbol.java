package tp3.ejercicio4;

import tp1.ejercicio8.Queue;
import tp3.ejercicio1.GeneralTree;

import java.util.List;

public class AnalizadorArbol {
    GeneralTree<AreaEmpresa> a;

    public AnalizadorArbol(GeneralTree<AreaEmpresa> a){
        this.a=a;
    }

    public double devolverMaximoPromedio(GeneralTree<AreaEmpresa>ar){
        Queue<GeneralTree<AreaEmpresa>> cola = new Queue<>();
        int cantNodos=0,total=0,promMax=0,prom;
        GeneralTree<AreaEmpresa> aux;
        cola.enqueue(ar);
        cola.enqueue(null);
        while(!cola.isEmpty()){
            aux = cola.dequeue();
            if(aux!= null) {
                cantNodos++;
                total+= aux.getData().getTardanza();
                if (aux.hasChildren()) {
                    List<GeneralTree<AreaEmpresa>> l = aux.getChildren();
                    for (GeneralTree<AreaEmpresa> child : l) {
                        cola.enqueue(child);
                    }
                }
            }else{
                if (cantNodos > 0) {
                    prom = total / cantNodos    ;
                    if (prom > promMax) promMax = prom;

                    total = 0;
                    cantNodos = 0;
                }
                if(!cola.isEmpty()){
                    cola.enqueue(null);
                }
            }
        }
        return promMax;
    }
}
