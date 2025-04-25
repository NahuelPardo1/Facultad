package tp1.ejercicio7;

import java.util.ArrayList;

public class Capicua {
    public boolean esCapicua(ArrayList<Integer> lista){
        boolean es=true;
        if(!lista.isEmpty()){
            int pri = 0;
            int last = lista.size()-1;
            while((pri<last)&&(es)){
                if(lista.get(pri).equals(lista.get(last))){
                    pri++;
                    last--;
                }else {
                    es=false;
                }
            }
        }
        return es;
    }
}
