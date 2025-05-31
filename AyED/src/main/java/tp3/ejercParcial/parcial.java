package tp3.ejercParcial;

import tp3.ejercicio1.GeneralTree;

import java.util.ArrayList;
import java.util.List;

public class parcial {

    public static List<Personaje> caminoAPrincesa(GeneralTree<Personaje> a){
        List<Personaje> l = new ArrayList<Personaje>();
        l.add(a.getData());
        List<Personaje> cam = new ArrayList<Personaje>();
        caminoAPrincesa(a,l,cam);
        return cam;
    }

    private static void caminoAPrincesa(GeneralTree<Personaje> ar,List<Personaje>l,List<Personaje> cam){
        Personaje p = ar.getData();
        if(p.esPrincesa()){
            cam.addAll(l);
        }
        if(cam.isEmpty()){
            List<GeneralTree<Personaje>> children = ar.getChildren();
            for(GeneralTree<Personaje> child : children){
                if(!child.getData().esDragon()){
                    l.add(child.getData());
                    caminoAPrincesa(child,l,cam);
                    l.remove(l.size()-1);
                }

            }
        }
    }
}
