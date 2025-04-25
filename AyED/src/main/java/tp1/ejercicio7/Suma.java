package tp1.ejercicio7;

import java.util.LinkedList;

public class Suma {

    public static int sumarLinkedList(LinkedList<Integer> lista){
        if(!lista.isEmpty()){
            int ult = lista.size()-1;
            int total = sumarLinkedListRec(lista,ult);
            return total;
        }else{
            return 0;
        }

    }
    private static int sumarLinkedListRec(LinkedList<Integer> l,int ult){
        if(ult<0){
            return 0;
        }else {
            return l.get(ult) + sumarLinkedListRec(l,ult-1);
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<Integer>();
        lista.add(5);
        lista.add(10);
        lista.add(35);

        System.out.println("Resultado total de los numeros de la lista: " + sumarLinkedList(lista));
    }
}
