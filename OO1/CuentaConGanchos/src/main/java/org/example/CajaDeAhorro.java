package org.example;

public class CajaDeAhorro extends Cuenta {

    public CajaDeAhorro(){
        super();
    }

    public boolean puedeExtraer(double monto){
        return this.getSaldo() >= monto + monto*0.02;
    }

}
