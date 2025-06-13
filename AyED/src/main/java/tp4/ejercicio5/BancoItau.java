package tp4.ejercicio5;

import tp4.ejercicio1.*;

import java.util.*;
import tp1.ejercicio8.Queue;

public class BancoItau {
    public BancoItau(){}

    public List<Jubilado> carteraJubilados(Graph<Persona> grafo,String nomEmpleado,int grado,int maxList){
        List<Jubilado> jubilados = new LinkedList<>();
        if(!grafo.isEmpty()){
            Vertex<Persona> emp = this.buscarEmpleado(grafo,nomEmpleado);
            if(emp!=null){
                Queue<Vertex<Persona>> cola = new Queue<Vertex<Persona>>();
                boolean[] marca = new boolean[grafo.getSize()];
                marca[emp.getPosition()]= true;
                cola.enqueue(emp);
                cola.enqueue(null);
                while(!cola.isEmpty() && grado > 0 && jubilados.size()<maxList){
                    Vertex<Persona> p = cola.dequeue();
                    if(p!= null){
                        List<Edge<Persona>> aristas = grafo.getEdges(p);
                        for(Edge<Persona> e : aristas){
                            if(marca[e.getTarget().getPosition()]){
                                marca[e.getTarget().getPosition()]=true;
                                cola.enqueue(e.getTarget());
                                if(e.getTarget().getData().cumple()){
                                    jubilados.add(new Jubilado(e.getTarget().getData().getNombre(), e.getTarget().getData().getDomicilio()));
                                }
                            }
                        }
                    }else if(!cola.isEmpty()){
                        grado--;
                        cola.enqueue(null);
                    }
                }
            }
        }
        return jubilados;
    }

    private Vertex<Persona> buscarEmpleado(Graph<Persona> grafo, String nomEmpleado){
        List<Vertex<Persona>> vertices = grafo.getVertices();
        Vertex<Persona> per= null;
        for(Vertex<Persona> p : vertices){
            if(p.getData().getNombre().equals(nomEmpleado)){
                per = p;
                break;
            }
        }
        return per;
    }


}
