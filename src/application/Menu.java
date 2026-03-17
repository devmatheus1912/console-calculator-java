package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public int exibirMenu(Scanner sc) {
        while (true) {
            System.out.println("================================");
            System.out.println("   CONSOLE CALCULATOR v2.0      ");
            System.out.println("================================");
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
            System.out.println("Escolha uma opção: ");

            try {
                int opcao = sc.nextInt();

                if (opcao >= 0 && opcao <= 10) {
                    return opcao;
                }

                System.out.println("Opção inválida");
                System.out.println("------------------------------");

            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite apenas números inteiros.");
                sc.nextLine();
            }
        }
    }
}