import static handler.PedirDatos.numeros;
import static logica.Calculador.operacion;
import static handler.PedirDatos.pedimosNumeros;
import static logica.Calculador.calcularResultado;

public class Main {

    public static void main(String[] args) {
        // Extraemos los 6 números + 1 resultado
        numeros = pedimosNumeros();

        // Mostramos los números elegidos
        for (int i: numeros) System.out.printf("%d ", i);
        System.out.println();

        // Hacemos el cálculo
        calcularResultado();

        // Mostramos el resultado
        for (String s: operacion) System.out.println(s);
    }
}