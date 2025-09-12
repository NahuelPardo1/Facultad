package org.example;

import java.time.LocalDate;
import java.util.List;

public class Ticket {
    private LocalDate fecha;
    private int cantidadDeProductos;
    private double pesoTotal;
    private double precioTotal;
    private List<Producto> productos;

    public Ticket(int cant, double pesoTotal, double precioTotal, List<Producto> productos) {
        this.cantidadDeProductos = cant;
        this.pesoTotal = pesoTotal;
        this.precioTotal = precioTotal;
        this.fecha = LocalDate.now();
        this.productos = productos;
    }

    public double impuesto(){
        return this.precioTotal * 0.21;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
