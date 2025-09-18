package handler;

import java.util.Scanner;

public class PedirDatos {
    // Públicos //
    public final static int MAX_NUMEROS=6;
    public static int[] numeros=new int[MAX_NUMEROS];
    public static int numeroFinal=0;
    // Privados //
    private final static Scanner sc=new Scanner(System.in);
    private final static String PEDIR_NUMERO="Introduce un número (%d restantes):\n";
    private final static String PEDIR_RESULTADO="Introduce el número que debe averiguar:";
    // //

    public static int[] pedimosNumeros() {

        // Pedimos los 6 números operandos
        for (int c=0; c < MAX_NUMEROS; c++) {
            System.out.printf(PEDIR_NUMERO, MAX_NUMEROS-c);

            while (!sc.hasNextInt()) sc.nextLine();
            numeros[c] = sc.nextInt();
            sc.nextLine();
        }

        // Pedimos el resultado
        System.out.println(PEDIR_RESULTADO);

        while (!sc.hasNextInt()) sc.nextLine();
        numeroFinal = sc.nextInt();
        sc.nextLine();

        return numeros;
    }
}
