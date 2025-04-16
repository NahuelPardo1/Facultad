using System.Globalization;
public class Hora{
    private int _hora;
    private int _minutos;
    private double _segundos;
    private bool _esDecimal;


    public Hora(int hora,int minutos,int segundos ){
        _hora= hora;
        _minutos= minutos;
        _segundos= segundos;
        _esDecimal=false;
    }

    public Hora(double horas){
        _hora = (int)horas;
        double minutosDecimales = (horas - _hora)*60;
        _minutos= (int)minutosDecimales;
        _segundos = (minutosDecimales-_minutos)*60;
        _esDecimal=true;
    }

    public string Imprimir(){
        if(_esDecimal){
            return ($"{_hora} horas, {_minutos} minutos, {_segundos:0.000} segundos");
        }
        else{
            return ($"{_hora} horas, {_minutos} minutos, {(int)_segundos} segundos");
        }
    }
}