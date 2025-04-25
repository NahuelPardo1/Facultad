public class Matriz{
    private double[,] _matriz;

    public Matriz(int filas, int columnas){
        _matriz=new double[filas,columnas];
    }
    public Matriz(double[,] matriz){
        _matriz = matriz;
    }
    public double this[int i, int j]{
        get{
            return _matriz[i,j];
        }
        set{
            _matriz[i,j]=value;
        }
    }
    public void imprimir(){
        for(int i=0;i< _matriz.GetLength(0);i++){
            for(int j=0; j<_matriz.GetLength(1); i++){
                Console.WriteLine(_matriz[i,j]);
            }
            Console.WriteLine();
        }
    }
    public void imprimir(string formatString){
        for (int i = 0; i < _matriz.GetLength(0); i++)
        {
            for (int j = 0; j < _matriz.GetLength(1); j++)
            {
                Console.Write($"{_matriz[i, j].ToString(formatString)}\t");
            }
            Console.WriteLine();
        }
    }
    public double[] GetFila(int fila){
        double[] aux = new double[_matriz.GetLength(1)];
        for(int i=0;i<_matriz.GetLength(1); i++){
            aux[i]= _matriz[fila,i];
        }
        return aux;
    }
    public double[] GetColumna(int columna){
        double[] aux = new double[_matriz.GetLength(0)];
        for(int i=0;i<_matriz.GetLength(0); i++){
            aux[i]= _matriz[i,columna];
        }
        return aux;
    }
    public double[] DiagonalPrincipal{

        get{
            if(_matriz.GetLength(0) != _matriz.GetLength(1)){
                throw new ArgumentException("La matriz no es cuadrada.");
            }
            double[] diagonal = new double[_matriz.GetLength(0)];
            for (int i = 0; i < _matriz.GetLength(0); i++)
            {
                diagonal[i] = _matriz[i, i];
            }
            return diagonal;
        }
    }
    public double[] DiagonalSecundaria{
        get{
            if(_matriz.GetLength(0) != _matriz.GetLength(1)){
            throw new ArgumentException("La matriz no es cuadrada.");
            }
            double[] diagonal = new double[_matriz.GetLength(0)];
            for (int i = 0; i < _matriz.GetLength(0); i++)
            {
                diagonal[i] = _matriz[i, _matriz.GetLength(1) - 1 - i];
            }
            return diagonal;
        }
    }
    public double[][] getArregloDeArreglo(){
        double[][] arreglo = new double[_matriz.GetLength(0)][];
        for (int i = 0; i < _matriz.GetLength(0); i++)
        {
            arreglo[i] = new double[_matriz.GetLength(1)];
            for (int j = 0; j < _matriz.GetLength(1); j++)
            {
                arreglo[i][j] = _matriz[i, j];
            }
        }
        return arreglo;
    }
    public void sumarle(Matriz m){
        
    }
    public void restarle(Matriz m){

    }
    public void multiplicarPor(Matriz m){
        
    }


}