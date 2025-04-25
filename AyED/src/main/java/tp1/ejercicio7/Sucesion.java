package tp1.ejercicio7;

import java.util.LinkedList;
import java.util.List;

public class Sucesion {
    public static List<Integer> CalcularSucesion(int n){
        List<Integer> l = new LinkedList<Integer>();
        calcularSucesionRec(l,n);
        return l;
    }
    private static void calcularSucesionRec(List<Integer> l,int n){
        l.add(n);
        if(n>1){
            if(n%2==0){
                calcularSucesionRec(l,(n/2));
            }else{
                calcularSucesionRec(l,((n*3)+1));
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> lista = CalcularSucesion(6);
        for(Integer i : lista){
            System.out.println(i);
        }
    }
}
