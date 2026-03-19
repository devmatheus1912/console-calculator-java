package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidadorEntrada {

    private static final double VALOR_MINIMO_PADRAO = -1_000_000;
    private static final double VALOR_MAXIMO_PADRAO = 1_000_000;

    public static double pedirNumeroValido(Scanner sc, String mensagem) {
        return pedirNumeroValido(sc, mensagem, VALOR_MINIMO_PADRAO, VALOR_MAXIMO_PADRAO);
    }

    public static double pedirNumeroValido(Scanner sc, String mensagem, double minimo, double maximo) {
        while (true) {
            try {
                System.out.print(mensagem);
                double numero = sc.nextDouble();

                if (numero < minimo || numero > maximo) {
                    System.out.println("Erro: o número deve estar entre " + minimo + " e " + maximo + ".");
                    continue;
                }

                return numero;

            } catch (InputMismatchException e) {
                System.out.println("Erro: digite um número válido.");
                sc.nextLine();
            }
        }
    }

    private ValidadorEntrada() {
    }
}