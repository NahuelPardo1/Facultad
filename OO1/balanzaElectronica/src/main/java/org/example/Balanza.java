package org.example;

import java.util.ArrayList;
import java.util.List;

public class Balanza {
    private int cantidadDeProductos=0;
    private double precioTotal=0;
    private double pesoTotal=0;
    private List<Producto> productos;

    public Balanza(){
    }

    public void ponerEnCero(){
        this.cantidadDeProductos = 0;
        this.precioTotal = 0;
        this.pesoTotal = 0;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto){
        this.cantidadDeProductos++;
        this.precioTotal += producto.getPrecioPorKilo() * producto.getPeso();
        this.pesoTotal += producto.getPeso();
    }

    public Ticket emitirTicket(){
        return new Ticket(cantidadDeProductos,pesoTotal,precioTotal,productos);
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }
    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
