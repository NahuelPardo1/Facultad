package tp1.ejercicio9;
import java.util.*;
public class TestBalanceo {
    private static boolean esBalanceado(String expr) {
        List<Character> cierre = new LinkedList<Character>();
        cierre.add(')');
        cierre.add(']');
        cierre.add('}');
        boolean ok = true;

        if((expr.length() %2 !=0) || (expr.length() > 0 && cierre.contains(expr.charAt(0)))) ok = false; //(1)
        else {
            List<Character> apertura = new LinkedList<Character>();
            apertura.add('(');
            apertura.add('[');
            apertura.add('{');

            Stack<Character> pila = new Stack<Character>();
            Character actual, elem;
            int i = 0;
            while(i < expr.length() && ok) {
                actual = expr.charAt(i);
                if(apertura.contains(actual))
                    pila.push(actual);
                else {
                    if(!pila.isEmpty()) {
                        elem = pila.pop();
                        if(apertura.indexOf(elem) != cierre.indexOf(actual)) ok = false; //(2)
                    }
                }
                i++;
            }
            if(!pila.isEmpty()) ok = false; //(3)
        }
        return ok;
    }

    public static void main(String[] args) {
        String str= "([)]";
        System.out.println(esBalanceado(str));
    }
}
