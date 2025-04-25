package tp1.ejercicio5;

public class ej5_tp1 {
    private static Datos d;
    public static int[] maxMinProm(int [] arr){
        int max=0;
        int min=999;
        int total=0;
        for(int i=0; i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }
            total+=arr[i];
        }
        int prom = total/arr.length;
        int[] res = {max,min,prom};
        return res;
    }
    public static void maxMinPromC(int [] arr){
        int max=0;
        int min=999;
        int total=0;
        for(int i=0; i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }
            total+=arr[i];
        }
        int prom = total/arr.length;
        d = new Datos();
        d.setMax(max);
        d.setMin(min);
        d.setProm(prom);
    }
    public static String imprimir(){
        String aux= d.toString();
        return aux;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,4,5,6,8,0,23};
        int [] res = maxMinProm(arr);
        System.out.println("Maximo = "+ res[0]);
        System.out.println("Minimo = "+ res[1]);
        System.out.println("Promedio = "+ res[2]);
        maxMinPromC(arr);
        System.out.println(imprimir());

    }

}
