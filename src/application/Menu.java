package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public int exibirMenu(Scanner sc) {

        boolean inputValido = false;

        int opcao;
        do {
            System.out.println("================================");
            System.out.println("        CONSOLE CALCULATOR       ");
            System.out.println("================================");
            System.out.println("1 - Somar");
            System.out.println("2 - Subtrair");
            System.out.println("3 - Multiplicar");
            System.out.println("4 - Dividir");
            System.out.println("0 - Sair");
            System.out.println();
            System.out.println("Escolha uma opção: ");

            opcao = 0;

            try {
                opcao = sc.nextInt();

                //O exibirMenu será exibido repetidamente até o usuário escolher a opção 0 (Sair)
                if (opcao < 0 || opcao > 4) {
                    System.out.println("Opção inválida");
                    System.out.println("------------------------------");
                    continue;
                }
                inputValido = true; // Se chegou aqui, a entrada é válida
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite apenas números inteiros.");
                sc.nextLine();
            }
        }
        while (!inputValido);
        return opcao;


    }
}
