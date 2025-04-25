public class Cuenta{
    private static int cuentas = 0;
    private static int depositos=0;
    private static int extracciones=0;
    private static double totalDepositado =0;
    private static double totalExtraido=0;
    private static int extraccionesDenegadas=0;
    private static List<Cuenta> l = new List<Cuenta>();
    public static List<Cuenta> GetCuentas{
        get{
            return new List<Cuenta>(l);
        }
    }
    private int id;
    private double saldo=0;

    

    public Cuenta(){
        l.Add(this);
        cuentas++;
        id=cuentas;
        Console.WriteLine($"Se creó la cuenta ID={id}");
    }
    public Cuenta Depositar(double monto){
        saldo+=monto;
        depositos++;
        totalDepositado+=monto;
        Console.WriteLine($"Se depositó {monto} en la cuenta {id} (Saldo = {saldo})");
        return this;
    }
    public Cuenta Extraer(double monto){
        if(monto>saldo){
            extraccionesDenegadas++;
            Console.WriteLine("Operación denegada - Saldo insuficiente");
            return this;
        }else {
            saldo-=monto;
            extracciones++;
            totalExtraido+=monto;
            Console.WriteLine($"Se extrajo {monto} de la cuenta {id} (Saldo = {saldo})");
            return this;
        }

    }
    public static void imprimirDetalle(){
        Console.WriteLine($"CUENTAS CREADAS:{cuentas}\nDEPOSITOS:\t{depositos}\t- Total depositado:\t{totalDepositado}\nEXTRACCIONES:\t{extracciones}\t- Total extraido:\t{totalExtraido}\n\t\t\t- Saldo\t\t\t{totalDepositado-totalExtraido}\n* Se denenegaron {extraccionesDenegadas} extracciones por falta de fondos");
    }
    
    
}