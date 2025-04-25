namespace Figuras;
public class Circulo{
    private double _radio;
    public double GetArea{
        get{return (Math.PI*_radio*_radio);}
    }
    public Circulo(double radio){
        _radio = radio;
    }


}