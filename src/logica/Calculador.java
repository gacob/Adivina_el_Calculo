package logica;

import java.util.ArrayList;
import java.util.Random;

import static handler.PedirDatos.MAX_NUMEROS;
import static handler.PedirDatos.numeroFinal;
import static handler.PedirDatos.numeros;

public class Calculador {
    private final static int NUMERO_OPERANDOS=4;
    public static ArrayList<String> operacion=new ArrayList<>();

    public static void calcularResultado() {

        Random random=new Random();
        int resultadoProvisional=0;

        // Se puede sumar, restar, multiplicar y restar
        while (resultadoProvisional != numeroFinal) {
            ArrayList<Integer> numerosYaUsados=new ArrayList<>();
            //for (String s: operacion) System.out.println(s);
            operacion.clear();

            for (int c=0; c < 4; c++) {

                // Sacamos dos números aleatoriamente
                int numero1 = random.nextInt(MAX_NUMEROS); // 0-6
                int numero2=-1;

                if (c==0) numero2 = random.nextInt(MAX_NUMEROS); // 0-6

                int operador = random.nextInt(NUMERO_OPERANDOS); // 0 = Suma, 1 = Resta, 2 = Multiplicar, 3 = Dividir

                if (numero1 == numero2 || numerosYaUsados.contains(numero1) || (numero2 != -1 && numerosYaUsados.contains(numero2))) {
                    c--;
                    continue;
                } else {
                    numerosYaUsados.add(numero1);
                    if (numero2 != -1) numerosYaUsados.add(numero2);
                }

                if (c==0) resultadoProvisional = calcularOperandos(numeros[numero1], numeros[numero2], operador);
                else resultadoProvisional = calcularOperandos(resultadoProvisional, numeros[numero1], operador);

                // operación inválida, descartamos esta iteración y repetimos
                if (resultadoProvisional <= 0) resultadoProvisional=0;

                if (resultadoProvisional == numeroFinal) break;
            }

        }
    }

    private static int calcularOperandos(int numero1, int numero2, int operador) {
        int resultado=0;

        if (operador == 0) {
            resultado=numero1+numero2;
            operacion.add(String.format("%d+%d = %d", numero1, numero2, resultado));
        } else if (operador == 1) {
            resultado=numero1-numero2;
            operacion.add(String.format("%d-%d = %d", numero1, numero2, resultado));
        } else if (operador == 2) {
            resultado=numero1*numero2;
            operacion.add(String.format("%d*%d = %d", numero1, numero2, resultado));
        } else if (operador == 3) {
            if (numero2 != 0 && numero1 % numero2 == 0) {
                resultado = numero1 / numero2;
                operacion.add(String.format("%d/%d = %d", numero1, numero2, resultado));
            }
        }

        return resultado;
    }
}
