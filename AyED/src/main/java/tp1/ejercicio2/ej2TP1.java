package tp1.ejercicio2;

public class ej2TP1 {
    public static int[] multiplos(int n){
        int [] mult = new int[n];
        for (int i=0; i<n; i++){
            mult[i]= n*(i+1);
        }
        return mult;
    }
    public static void main(String[] args) {
        int [] mult = multiplos(5);
        for (int i=0; i<5;i++){
            System.out.println(mult[i]);
        }
    }
}
