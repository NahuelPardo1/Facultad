package parcialesYTeoria.parcialGrafos1;

public class Usuario {
    private String nombre;
    private int dist;


    public Usuario(String nombre, int dist){
        this.nombre = nombre;
        this.dist = dist;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public String toString(){
        return nombre + " " + dist;
    }
}
