package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presupuesto {
    private LocalDate fecha;
    private String cliente;
    private List<Item> items;


    public Presupuesto(String cliente){
        fecha = LocalDate.now();
        this.cliente = cliente;
        this.items = new ArrayList<>();
    }
    public void agregarItem(Item item){
        items.add(item);
    }

    public double calcularTotal(){
        double total = 0.0;
        for(Item item : items){
            total+=item.costo();
        }
        return total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
