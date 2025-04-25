package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class Combinar {
    public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> l, ArrayList<Integer> l2 ){
        ArrayList<Integer> res = new ArrayList<Integer>();
        int indice1=0;
        int indice2=0;
        while((indice1<l.size())&& indice2<l2.size()){
            if(l.get(indice1)<l2.get(indice2)){
                res.add(l.get(indice1));
                indice1++;
            }else{
                res.add(l2.get(indice2));
                indice2++;
            }
        }
        while(indice2<l2.size()){
            res.add(l2.get(indice2));
            indice2++;
        }
        while(indice1<l.size()){
            res.add(l.get(indice1));
            indice1++;
        }
        return res;
    }
}
