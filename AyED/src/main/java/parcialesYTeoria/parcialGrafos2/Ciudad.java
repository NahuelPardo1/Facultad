package parcialesYTeoria.parcialGrafos2;

public class Ciudad {
    private String fase;
    private String nombre;

    public Ciudad(String nombre, String fase){
        this.fase = fase;
        this.nombre = nombre;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return this.nombre+ " "+ "("+this.fase+")";
    }
}
