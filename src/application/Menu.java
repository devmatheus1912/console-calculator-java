package application;

import java.util.Scanner;

public class Menu {
    public int menu(Scanner sc) {

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

        int opcao = sc.nextInt();
        return opcao;

    }
}
