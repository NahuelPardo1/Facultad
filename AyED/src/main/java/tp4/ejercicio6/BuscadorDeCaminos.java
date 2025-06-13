package tp4.ejercicio6;

import tp4.ejercicio1.Edge;
import tp4.ejercicio1.Graph;
import tp4.ejercicio1.Vertex;
import tp4.ejercicio1.adjList.AdjListGraph;

import java.util.ArrayList;
import java.util.List;

public class BuscadorDeCaminos {
    private Graph<String> bosque;

    public BuscadorDeCaminos(Graph<String> bosque){
        this.bosque=bosque;
    }

    public List<List<String>> recorridosMasSeguro(){
        List<List<String>> caminos = new ArrayList<List<String>>();
        List<String> l = new ArrayList<>();
        boolean[] marca = new boolean[bosque.getSize()];
        if(bosque!= null && !bosque.isEmpty()){
            Vertex<String> origen = bosque.search("Casa Caperucita");
            Vertex<String> destino = bosque.search("Casa Abuelita");
            if(origen!=null && destino!= null ){
                recorridosMasSeguro(origen,destino,l,caminos,marca);
            }

        }
        return caminos;
    }

    private void recorridosMasSeguro(Vertex<String>actual,Vertex<String>destino,List<String>l,List<List<String>>caminos,boolean[]marca){
        marca[actual.getPosition()]=true;
        l.add(actual.getData());
        if(actual == destino){
            caminos.add(new ArrayList<>(l));
        }else{
            List<Edge<String>> aristas= this.bosque.getEdges(actual);
            for(Edge<String>e : aristas){
                if(e.getWeight()<5 && !marca[e.getTarget().getPosition()]){
                    recorridosMasSeguro(e.getTarget(),destino,l,caminos,marca);
                }

            }
        }
        l.remove(l.size()-1);
        marca[actual.getPosition()]=false;
    }

    public static void main (String[] args) {
        Graph<String> bosque = new AdjListGraph<String>();
        Vertex<String> v1 = bosque.createVertex("Casa Caperucita");
        Vertex<String> v2 = bosque.createVertex("Claro 3");
        Vertex<String> v3 = bosque.createVertex("Claro 1");
        Vertex<String> v4 = bosque.createVertex("Claro 2");
        Vertex<String> v5 = bosque.createVertex("Claro 5");
        Vertex<String> v6 = bosque.createVertex("Claro 4");
        Vertex<String> v7 = bosque.createVertex("Casa Abuelita");
        bosque.connect(v1, v2, 4);
        bosque.connect(v2, v1, 4);
        bosque.connect(v1, v3, 3);
        bosque.connect(v3, v1, 3);
        bosque.connect(v1, v4, 4);
        bosque.connect(v4, v1, 4);
        bosque.connect(v2, v5, 15);
        bosque.connect(v5, v2, 15);
        bosque.connect(v3, v5, 3);
        bosque.connect(v5, v3, 3);
        bosque.connect(v4, v3, 4);
        bosque.connect(v3, v4, 4);
        bosque.connect(v4, v5, 11);
        bosque.connect(v5, v4, 11);
        bosque.connect(v4, v6, 10);
        bosque.connect(v6, v4, 10);
        bosque.connect(v4, v3, 4);
        bosque.connect(v3, v4, 4);
        bosque.connect(v5, v7, 4);
        bosque.connect(v7, v5, 4);
        bosque.connect(v6, v7, 9);
        bosque.connect(v7, v6, 9);
        BuscadorDeCaminos bos = new BuscadorDeCaminos(bosque);
        List<List<String>> lis = bos.recorridosMasSeguro();
        for(List<String> l: lis) {
            System.out.println(l);
        }

    }
}
