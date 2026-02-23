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
            if (opcao == 5) {
                calculadora.mostraRegistro();
                IO.println();
                continue;
            } else if (opcao == 6) {
                calculadora.limparRegistro();
                IO.println("Historico limpo com sucesso");
                continue;
            }


            if (opcao != 0) {

                IO.print("Digite o primeiro número: ");
                double n1 = sc.nextDouble();

                IO.print("Digite o segundo número: ");
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
                        IO.println("Opção inválida.");
                        continue;
                }

                try {
                    double resultado = calculadora.executar(operacaoEscolhida, n1, n2);
                    IO.println("Resultado: " + resultado);
                } catch (ArithmeticException e) {
                    IO.println("Erro: " + e.getMessage());
                }

                IO.println("------------------------------");
            } else {
                IO.println("Encerrando o programa...");
            }

        } while (opcao != 0);

        sc.close();
    }
}
