package tp1.ejercicio5;

public class Datos {
    private int max;
    private int min;
    private int prom;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getProm() {
        return prom;
    }

    public void setProm(int prom) {
        this.prom = prom;
    }
    @Override
    public String toString(){
        String aux="Maximo = "+getMax()+"\nMinimo = "+ getMin()+"\nPromedio = "+getProm();
        return aux;
    }
}
