package parcialesYTeoria.parcialGrafos2;

import tp4.ejercicio1.Edge;
import tp4.ejercicio1.Graph;
import tp4.ejercicio1.Vertex;
import tp4.ejercicio1.adjList.AdjListGraph;

import java.util.ArrayList;
import java.util.List;

public class ParcialGrafos2 {
    public List<Ciudad> resolver(Graph<Ciudad> ciudades, String orig, String dest){
        List<Ciudad> list = new ArrayList<>();
        List<Ciudad> cam = new ArrayList<>();
        if(ciudades !=null && !ciudades.isEmpty()){
            boolean[] marca = new boolean[ciudades.getSize()];
            Vertex<Ciudad> origen = buscarCiudad(ciudades,orig);
            Vertex<Ciudad> destino = buscarCiudad(ciudades,dest);
            if(origen!=null && destino !=null){
                marca[origen.getPosition()] = true;
                list.add(origen.getData());
                resolver(ciudades,origen,destino,marca,list,cam);
            }
        }
        return cam;
    }

    private void resolver(Graph<Ciudad>ciudades, Vertex<Ciudad> actual,Vertex<Ciudad>destino, boolean[] marca,List<Ciudad> l , List<Ciudad> cam){
        if(actual == destino){
            cam.removeAll(cam);
            cam.addAll(l);
        }else{
            List<Edge<Ciudad>> aristas = ciudades.getEdges(actual);
            for(Edge<Ciudad> e : aristas){
                if(!marca[e.getTarget().getPosition()] && !e.getTarget().getData().getFase().equals("Fase 1")){
                    marca[e.getTarget().getPosition()]=true;
                    l.add(e.getTarget().getData());
                    resolver(ciudades,e.getTarget(),destino,marca,l,cam);
                    l.remove(l.size()-1);
                    marca[e.getTarget().getPosition()]=false;
                }
            }
        }
    }

    private Vertex<Ciudad> buscarCiudad(Graph<Ciudad>ciudades, String ciudad){
        Vertex<Ciudad>aux=null;
        List<Vertex<Ciudad>> listado = ciudades.getVertices();
        for(Vertex<Ciudad> c : listado){
            if(c.getData().getNombre().equals(ciudad)){
                aux = c;
            }
        }
        return aux;
    }
    public static void main(String args[]) {
        Graph<Ciudad> grafo = new AdjListGraph<Ciudad>();
        //Descarte Saladillo, Lobos y Pinamar
        Vertex<Ciudad> v1 = grafo.createVertex(new Ciudad("Suipacha", "Fase 5"));
        Vertex<Ciudad> v2 = grafo.createVertex(new Ciudad("Carlos Keen", "Fase 3"));
        Vertex<Ciudad> v3 = grafo.createVertex(new Ciudad("Moreno", "Fase 1"));
        Vertex<Ciudad> v4 = grafo.createVertex(new Ciudad("Quilmes", "Fase 1"));
        Vertex<Ciudad> v5 = grafo.createVertex(new Ciudad("Navarro", "Fase 4"));
        Vertex<Ciudad> v6 = grafo.createVertex(new Ciudad("Cañuelas", "Fase 3"));
        Vertex<Ciudad> v7 = grafo.createVertex(new Ciudad("Abasto", "Fase 2"));
        Vertex<Ciudad> v8 = grafo.createVertex(new Ciudad("La Plata", "Fase 2"));

        grafo.connect(v1, v2);
        grafo.connect(v2, v1);
        grafo.connect(v2, v3);
        grafo.connect(v3, v2);
        grafo.connect(v3, v4);
        grafo.connect(v4, v3);
        grafo.connect(v1, v5);
        grafo.connect(v5, v1);
        grafo.connect(v5, v6);
        grafo.connect(v6, v5);
        grafo.connect(v6, v7);
        grafo.connect(v7, v6);
        grafo.connect(v7, v3);
        grafo.connect(v3, v7);
        grafo.connect(v7, v8);
        grafo.connect(v8, v7);
        grafo.connect(v8, v4);
        grafo.connect(v4, v8);

        ParcialGrafos2 p = new ParcialGrafos2();

        System.out.println(p.resolver(grafo, "La Plata", "Carlos Keen"));
    }
}
