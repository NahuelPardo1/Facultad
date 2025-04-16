using System;

namespace practica4;

public class Persona
{
    private string _nombre;
    private int _edad;
    private string _dni;

    public Persona(string nombre, int edad , string dni){
        _nombre=nombre;
        _edad=edad;
        _dni=dni;
    }

    public void Imprimir(int n){
        Console.WriteLine($"{n}) {_nombre} {_edad} {_dni}");
    }

    public bool EsMayorQue(Persona p){
        if(_edad > p._edad){
            return true;
        } else
            return false; 
    }

    
   
}
