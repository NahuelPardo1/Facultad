package tp4.ejercicio3;

import tp4.ejercicio1.Edge;
import tp4.ejercicio1.Graph;
import tp4.ejercicio1.Vertex;

import java.util.*;

public class Mapa {
    private Graph<String> mapaCiudades;

    public Mapa(Graph<String> mapaCiudades){
        this.mapaCiudades= mapaCiudades;
    }

    public List<String> devolverCamino(String ciudad1, String ciudad2){
        List<String> list = new ArrayList<>();
        List<String> cam = new ArrayList<>();
        boolean[] marca = new boolean[mapaCiudades.getSize()];
        if(mapaCiudades!=null && !mapaCiudades.isEmpty()){
            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);
            if(origen != null && destino!=null){
                list.add(origen.getData());
                devolverCamino(origen, destino, list,cam, marca);
            }
        }
        return cam;
    }

    private void devolverCamino(Vertex<String>actual, Vertex<String> destino, List<String>l,List<String> cam,boolean[] marca){
        marca[actual.getPosition()]=true;
        if(actual == destino){
            cam.addAll(l);
        }else {
            List<Edge<String>> aristas = mapaCiudades.getEdges(actual);
            for(Edge<String> e: aristas){
                l.add(e.getTarget().getData());
                if(!marca[e.getTarget().getPosition()]){
                    devolverCamino(e.getTarget(),destino,l,cam,marca);
                }
                l.remove(l.size()-1);
            }
        }
    }

    public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades){
        List<String> l = new LinkedList<>();
        List<String> cam = new LinkedList<>();
        boolean[] marca = new boolean[mapaCiudades.getSize()];
        if(mapaCiudades != null && !mapaCiudades.isEmpty()){
            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);
            if(origen!= null && destino != null){
                if(!ciudades.contains(origen.getData())) {
                    l.add(origen.getData());
                    devolverCaminoExceptuando(origen, destino, ciudades, l, cam, marca);
                }
            }
        }
        return cam;
    }

    private void devolverCaminoExceptuando(Vertex<String>actual, Vertex<String>destino,List<String>ciudades,List<String>l,List<String>cam,boolean[] marca){
        marca[actual.getPosition()]= true;
        if(actual==destino){
            cam.addAll(l);
        }else {
            List<Edge<String>> aristas = mapaCiudades.getEdges(actual);
            for(Edge<String> e : aristas){
                l.add(e.getTarget().getData());
                if(!ciudades.contains(e.getTarget().getData())&& !marca[e.getTarget().getPosition()]){
                    devolverCaminoExceptuando(e.getTarget(),destino,ciudades,l,cam,marca);
                }
                l.remove(l.size()-1);
            }
        }
    }

    public List<String> caminoMasCorto(String ciudad1, String ciudad2){
        List<String>l = new ArrayList<>();
        List<String>cam = new ArrayList<>();
        boolean[] marca = new boolean[mapaCiudades.getSize()];
        if(mapaCiudades!=null && !mapaCiudades.isEmpty()){
            Vertex<String> origen = mapaCiudades.search(ciudad1);
            Vertex<String> destino = mapaCiudades.search(ciudad2);
            if(origen!= null && destino !=null){
                caminoMasCorto(origen,destino,cam,l,marca,0,Integer.MAX_VALUE);
            }
        }
        return cam;
    }

    private int caminoMasCorto(Vertex<String> actual,Vertex<String> destino,List<String>l,List<String> cam,boolean[] marca,int total,int min){
        marca[actual.getPosition()]=true;
        l.add(actual.getData());
        if(actual == destino && total < min){
            cam.removeAll(cam);
            cam.addAll(l);
            min=total;
        }else{
            List<Edge<String>> aristas = mapaCiudades.getEdges(actual);
            for(Edge<String> e : aristas){
                int j = e.getTarget().getPosition();
                int aux = total + e.getWeight();
                if(!marca[j] && aux<min){
                    min = caminoMasCorto(e.getTarget(),destino,l,cam,marca,aux,min);
                }
            }
        }
        marca[actual.getPosition()]= false;
        l.remove(l.size()-1);
        return min;
    }

    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2,int tanqueAuto){
        List<String> l = new ArrayList<>();
        boolean[] marca = new boolean[mapaCiudades.getSize()];
        if(mapaCiudades!=null && !mapaCiudades.isEmpty()){
            Vertex<String> origen = mapaCiudades.search(ciudad1);
            Vertex<String> destino = mapaCiudades.search(ciudad2);
            if(origen != null && destino != null ){
                caminoSinCargarCombustible(origen,destino,l,marca,tanqueAuto);
            }
        }
        return l;
    }

    private boolean caminoSinCargarCombustible(Vertex<String> actual, Vertex<String>destino,List<String>l,boolean[] marca,int tanqueAuto){
        boolean encontre = false;
        marca[actual.getPosition()]=true;
        l.add(actual.getData());
        if(actual==destino && tanqueAuto>=0){
            encontre =true;
        }else{
            List<Edge<String>> aristas = mapaCiudades.getEdges(actual);
            for(Edge<String> e : aristas){
                int aux = tanqueAuto-e.getWeight();
                if(!marca[e.getTarget().getPosition()] && aux>=0) {
                    encontre = caminoSinCargarCombustible(e.getTarget(), destino, l, marca, aux);
                }
            }
        }
        if(!encontre){
            l.remove(l.size()-1);
        }
        marca[actual.getPosition()]=false;
        return encontre;

    }

}
