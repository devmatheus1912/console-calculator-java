package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public int exibirMenu(Scanner sc) {

        boolean inputValido = false;

        int opcao;
        do {
            IO.println("================================");
            IO.println("        CONSOLE CALCULATOR       ");
            IO.println("================================");
            IO.println("1 - Somar");
            IO.println("2 - Subtrair");
            IO.println("3 - Multiplicar");
            IO.println("4 - Dividir");
            IO.println("5 - Ver historico");
            IO.println("6 - Limpar historico");
            IO.println("0 - Sair");
            IO.println();
            IO.println("Escolha uma opção: ");

            opcao = 0;

            try {
                opcao = sc.nextInt();

                //O exibirMenu será exibido repetidamente até o usuário escolher a opção 0 (Sair)
                if (opcao < 0 || opcao > 6) {
                    IO.println("Opção inválida");
                    IO.println("------------------------------");
                    continue;
                }
                inputValido = true; // Se chegou aqui, a entrada é válida
            } catch (InputMismatchException e) {
                IO.println("Erro: Entrada inválida. Por favor, digite apenas números inteiros.");
                sc.nextLine();
            }
        }
        while (!inputValido);
        return opcao;


    }
}
