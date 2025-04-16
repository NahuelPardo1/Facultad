public class Ecuacion2{
    private double _a;
    private double _b;
    private double _c;

    public Ecuacion2(double a,double b, double c){
        _a=a;
        _b=b;
        _c=c;
    }

    public double GetDiscriminante(){
        return (_b*_b)-(4*_a *_c);
    }

    public int GetCantidadDeRaices(){
        if(this.GetDiscriminante()<0){
            return 0;
        }
        else if(this.GetDiscriminante()==0){
            return 1;
        }
        else{
            return 2;
        }
    }

    public void ImprimirRaices(){
        double discriminante = this.GetDiscriminante();
        if(discriminante<0){
            Console.WriteLine("Esta ecuacion no tiene raices");
        }
        else if(discriminante==0){
            double raizUnica = -_b / (2 * _a);
            Console.WriteLine($"La ecuación tiene una raíz única: x = {raizUnica}");
        }
        else{
            double x1 = (-_b + Math.Sqrt(discriminante)) / (2 * _a);
            double x2 = (-_b - Math.Sqrt(discriminante)) / (2 * _a);
            Console.WriteLine($"La ecuación tiene dos raíces reales: x1 = {x1}, x2 = {x2}");
        }
    }
}