package tp1.ejercicio5;
public class tp1_ej5 {
    public static int[] calcularConReturn(int[] valores){
        int max=valores[0],min=valores[0],suma=0;
        for(int valor:valores){
            if(valor> max) max=valor;
            if(valor< min) min=valor;
            suma+=valor;
        }
        int promedio = suma/ valores.length;
        return new int[]{max,min,promedio};
    }
    public static void calcularConParametro(Resultado resultado, int[] valores){
        resultado.max = valores[0];
        resultado.min = valores[0];
        int suma=0;

        for(int valor: valores){
            if(valor> resultado.max) resultado.max=valor;
            if(valor<resultado.min) resultado.min=valor;
            suma+=valor;
        }
        resultado.promedio=suma/ valores.length;
    }
    private static int max,min,promedio;
    public static void calcularSinParametros(int[] valores) {
        max = valores[0];
        min = valores[0];
        int suma = 0;

        for (int valor : valores) {
            if (valor > max) max = valor;
            if (valor < min) min = valor;
            suma += valor;
        }
        promedio = suma / valores.length;
    }
    public static void mostrarResultados() {
        System.out.println("Máximo: " + max);
        System.out.println("Mínimo: " + min);
        System.out.println("Promedio: " + promedio);
    }
    public static void main(String[] args) {
        int [] arreglo ={5,10,20,3,2,1};
        int[] resultados = calcularConReturn(arreglo);
        System.out.println("Con return - Maximo= "+resultados[0]+", Minimo= "+resultados[1]+ ", Promedio: "+resultados[2]);
        Resultado resultado = new Resultado();
        calcularConParametro(resultado,arreglo);
        System.out.println("Con parametro - Maximo: "+ resultado.max +", Minimo: " + resultado.min + ", Promedio: " + resultado.promedio);
        calcularSinParametros(arreglo);
        System.out.println("sin parametros ni return");
        mostrarResultados();
    }
}
