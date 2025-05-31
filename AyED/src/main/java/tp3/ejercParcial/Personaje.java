package tp3.ejercParcial;

public class Personaje {
    private String tipo;
    private String nombre;

    public Personaje(String tipo, String nombre){
        this.tipo=tipo;
        this.nombre = nombre;
    }

    public boolean esPrincesa(){
        return this.tipo.equals("Princesa");
    }

    public boolean esDragon() {
        return this.tipo.equals("Dragón");
    }
}
