package org.example;

public class Producto {
    private double peso;
    private double precio;
    private String descripcion;

    public Producto(String descripcion,double peso, double precioPorKilo ) {
        this.peso = peso;
        this.precio = precioPorKilo;
        this.descripcion = descripcion;
    }

    public double getPeso() {
        return this.peso;
    }


    public void setPeso(double peso) {
        this.peso = peso;
    }
    public double getPrecio() {
        return this.precio * peso;
    }

    public double getPrecioPorKilo() {
        return precio;
    }

    public void setPrecioPorKilo(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
