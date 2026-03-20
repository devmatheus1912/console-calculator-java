package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static final int OPCAO_MINIMA = 0;
    private static final int OPCAO_MAXIMA = 10;
    private static final String SEPARADOR = "================================";

    public int exibirMenu(Scanner sc) {
        while (true) {
            imprimirMenu();

            try {
                int opcao = sc.nextInt();

                if (opcaoValida(opcao)) {
                    return opcao;
                }

                System.out.println("Opção inválida. Escolha um número entre 0 e 10.");
                System.out.println("------------------------------");

            } catch (InputMismatchException e) {
                System.out.println("Erro: entrada inválida. Digite apenas números inteiros.");
                sc.nextLine();
            }
        }
    }

    private void imprimirMenu() {
        System.out.println(SEPARADOR);
        System.out.println("   CONSOLE CALCULATOR v3.0");
        System.out.println(SEPARADOR);
        System.out.println("1 - Somar");
        System.out.println("2 - Subtrair");
        System.out.println("3 - Multiplicar");
        System.out.println("4 - Dividir");
        System.out.println("5 - Potência (a^b)");
        System.out.println("6 - Raiz Quadrada");
        System.out.println("7 - Logaritmo (log a na base b)");
        System.out.println("8 - Seno (em radianos)");
        System.out.println("9 - Ver histórico");
        System.out.println("10 - Limpar histórico");
        System.out.println("0 - Sair");
        System.out.println();
        System.out.print("Escolha uma opção: ");
    }

    private boolean opcaoValida(int opcao) {
        return opcao >= OPCAO_MINIMA && opcao <= OPCAO_MAXIMA;
    }
}