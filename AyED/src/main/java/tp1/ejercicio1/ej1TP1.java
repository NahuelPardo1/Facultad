package tp1.ejercicio1;

public class ej1TP1 {
    public static void impFor(int a,int b){
        for(int i=a; i<=b; i++){
            System.out.println(i);
        }
    }

    public static void impWhile(int a, int b){
        int i =a;
        while(i<=b){
            System.out.println(i++);
        }
    }

    public static void impRecursivo(int a, int b){
        if(a<=b){
            System.out.println(a);
            impRecursivo(a+1,b);
        }
    }


    public static void main(String[] args) {
        impFor(1,5);
        System.out.println();
        impWhile(1,5);
        System.out.println();
        impRecursivo(1,5);
    }
}
