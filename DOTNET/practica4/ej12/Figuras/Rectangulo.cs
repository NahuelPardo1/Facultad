namespace Figuras;
public class Rectangulo{
    private double _altura;
    public double Altura{
        get{ return _altura;}
        set{_altura = value;}
    }
    private double _base{get; set;}
    public double Base{
        get{return _base;}
        set{_base=value;}
    }
    public double Area{
        get{return _base*_altura;}
    }
        
    public Rectangulo(double Base, double altura){
        _base=Base;
        _altura = altura;
    }
}
    
