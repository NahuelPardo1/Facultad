package tp1.ejercicio7;

import java.util.ArrayList;

public class Invertir {

    public static void invertirArrayList(ArrayList<Integer> lista){
        if(!lista.isEmpty()){
            int pri=0;
            int ult=lista.size()-1;
            invertirArrayListRec(lista,pri,ult);
        }

    }
    private static void invertirArrayListRec(ArrayList<Integer> lista, int pri,int ult){
        int aux1=lista.get(pri);
        int aux2=lista.get(ult);
        if(pri<ult){
            lista.set(pri,aux2);
            lista.set(ult,aux1);
            invertirArrayListRec(lista,pri+1,ult-1);
        }
    }
}
