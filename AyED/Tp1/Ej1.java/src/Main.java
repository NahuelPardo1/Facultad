public class Main {
    public static void impFor (int a,int b){
        for(int i=a; i<=b;i++){
            System.out.println(i);
        }
    }
    public static void impWhile (int a,int b){
        int i=a;
        while(i<=b){
            System.out.println(i);
            i++;
        }
    }
    public static void impRecursivo (int a,int b){
        if(a<=b){
            System.out.println(a);
            impRecursivo((a+1),b);
        }

    }
    public static void main(String[] args) {
        int a= 1;
        int b= 10;
        impFor(a,b);
        impWhile(a,b);
        impRecursivo(a,b);
    }
}