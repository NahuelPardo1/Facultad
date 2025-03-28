package tp1.ejercicio2;

import java.util.Arrays;
import java.util.Scanner;

public class tp1_ej2 {
    public static int[] multiplos(){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] vector= new int[n];
        for(int i=0;i<n;i++){
            vector[i]=(i+1)*n;
        }
        return vector;
    }
    public static void main(String[] args) {
        int[] resultado = multiplos();
        System.out.println(Arrays.toString(resultado));
    }
}
