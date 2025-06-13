package parcialesYTeoria.parcialGrafos1;

import tp4.ejercicio1.Edge;
import tp4.ejercicio1.Graph;
import tp1.ejercicio8.Queue;
import tp4.ejercicio1.Vertex;
import tp4.ejercicio1.adjList.AdjListGraph;

import java.util.ArrayList;
import java.util.List;

public class ParcialGrafos1 {

    public List<Usuario> invitacionMasterClass(Graph<String> red, String usuario, int distancia, int limite){
        List<Usuario> l = new ArrayList<>();
        Queue<Vertex<String>> cola = new Queue<>();
        if(red !=null && !red.isEmpty()){
            Vertex<String> us = red.search(usuario);
            if(us !=null){
                cola.enqueue(us);
                boolean[] marca = new boolean[red.getSize()];
                marca[us.getPosition()] = true;
                int nivel = 1;
                cola.enqueue(null);
                while(!cola.isEmpty() && nivel<= distancia && l.size()<limite){
                    Vertex<String>aux = cola.dequeue();
                    if(aux != null){
                        List<Edge<String>> aristas = red.getEdges(aux);
                        for(Edge<String> e : aristas ){
                            if(!marca[e.getTarget().getPosition()]) {
                                marca[e.getTarget().getPosition()] = true;
                                cola.enqueue(e.getTarget());
                                if(l.size()<limite){
                                    l.add(new Usuario(e.getTarget().getData(),nivel));
                                }
                            }
                        }
                    } else if (!cola.isEmpty()) {
                        nivel++;
                        cola.enqueue(null);
                    }
                }
            }
        }
        return l;
    }

    public static void main(String args[]) {
        Graph<String> grafo = new AdjListGraph<String>();
        Vertex<String> v1 = grafo.createVertex("Lionel");
        Vertex<String> v2 = grafo.createVertex("Rodrigo");
        Vertex<String> v3 = grafo.createVertex("Ángel");
        Vertex<String> v4 = grafo.createVertex("Emiliano");
        Vertex<String> v5 = grafo.createVertex("Julián");
        Vertex<String> v6 = grafo.createVertex("Diego");
        Vertex<String> v7 = grafo.createVertex("Lautaro");
        Vertex<String> v8 = grafo.createVertex("Enzo");

        grafo.connect(v1, v2);
        grafo.connect(v2, v1);

        grafo.connect(v1, v3);
        grafo.connect(v3, v1);

        grafo.connect(v2, v4);
        grafo.connect(v4, v2);

        grafo.connect(v2, v5);
        grafo.connect(v5, v2);

        grafo.connect(v3, v5);
        grafo.connect(v5, v3);

        grafo.connect(v3, v6);
        grafo.connect(v6, v3);

        grafo.connect(v6, v7);
        grafo.connect(v7, v6);

        grafo.connect(v5, v7);
        grafo.connect(v7, v5);

        grafo.connect(v6, v8);
        grafo.connect(v8, v6);

        grafo.connect(v4, v8);
        grafo.connect(v8, v4);

        grafo.connect(v4, v7);
        grafo.connect(v7, v4);

        ParcialGrafos1 p = new ParcialGrafos1();

        System.out.println(p.invitacionMasterClass(grafo, "Lionel", 2, 4));
        System.out.println(p.invitacionMasterClass(grafo, "Juancito", 1, 2));
    }
}
