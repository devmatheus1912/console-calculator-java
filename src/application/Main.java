package application;

import entities.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Menu menu = new Menu();
        Calculadora calculadora = new Calculadora();

        int opcao;

        do {
            opcao = menu.exibirMenu(sc);

            if (opcao != 0) {

                System.out.print("Digite o primeiro número: ");
                double n1 = sc.nextDouble();

                System.out.print("Digite o segundo número: ");
                double n2 = sc.nextDouble();

                Operacao operacaoEscolhida = null;

                // Apenas decide qual operação criar
                switch (opcao) {
                    case 1:
                        operacaoEscolhida = new Somar();
                        break;
                    case 2:
                        operacaoEscolhida = new Subtrair();
                        break;
                    case 3:
                        operacaoEscolhida = new Multiplicar();
                        break;
                    case 4:
                        operacaoEscolhida = new Divisao();
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        continue;
                }

                try {
                    double resultado = calculadora.executar(operacaoEscolhida, n1, n2);
                    System.out.println("Resultado: " + resultado);
                } catch (ArithmeticException e) {
                    System.out.println("Erro: " + e.getMessage());
                }

                System.out.println("------------------------------");
            } else {
                System.out.println("Encerrando o programa...");
            }

        } while (opcao != 0);

        sc.close();
    }
}
