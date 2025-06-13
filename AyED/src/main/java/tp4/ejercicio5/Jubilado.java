package tp4.ejercicio5;

public class Jubilado {
    private String nombre;
    private String domicilio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Jubilado(String nombre, String domicilio) {
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Jubilado{" +
                "nombre='" + nombre + '\'' +
                ", domicilio='" + domicilio + '\'' +
                '}';
    }
}
