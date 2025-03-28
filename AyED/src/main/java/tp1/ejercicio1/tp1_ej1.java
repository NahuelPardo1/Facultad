package tp1.ejercicio1;

public class tp1_ej1 {
    public static void impFor(int a,int b){
        for(int i=a;i<=b;i++){
            System.out.println(i);
        }
    }
    public static void impWhile(int a,int b){
        int i=a;
        while(i<=b){
            System.out.println(i);
            i++;
        }
    }
    public static void impRec(int a,int b){
        if(a<=b){
            System.out.println(a);
            impRec(a+1,b);
        }
    }
    public static void main(String[] args) {
        int a=1;
        int b=10;
        impFor(a,b);
        impWhile(a,b);
        impRec(a,b);
    }
}
