package application;

import entities.Multiplicar;
import entities.Somar;
import entities.Subtrair;

import java.util.Locale;
import java.util.Scanner;

//Console Calc
//Calculadora simples de console criada para praticar
//estruturas de repetição, decisão e operações básicas em Java.

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int opcao;

        //Loop principal do programa
        //O menu será exibido repetidamente até o usuário escolher a opção 0 (Sair)
        do {
            System.out.println("-------- CONSOLE CALC --------");
            System.out.println("1 - Somar");
            System.out.println("2 - Subtrair");
            System.out.println("3 - Multiplicar");
            System.out.println("4 - Dividir");
            System.out.println("0 - Sair");
            System.out.println();
            System.out.println("Escolha uma opção: ");
            opcao = sc.nextInt();
            if (opcao < 0 || opcao > 4) {
                System.out.println("Opção inválida");
                System.out.println("------------------------------");
                continue;
            }

            if (opcao != 0) {
                System.out.println("Digite o primeiro número: ");
                double n1 = sc.nextDouble();
                System.out.println("Digite o segundo número: ");
                double n2 = sc.nextDouble();

                Multiplicar multiplicar = new Multiplicar();
                Subtrair subtrair = new Subtrair();
                Somar somar = new Somar();
//Executa a operação matemática conforme a opção escolhida no menu
                switch (opcao) {
                    case 1:
                        double soma = somar.calcular(n1, n2);
                        System.out.println("Soma: " + soma);
                        break;
                    case 2:
                        double subtracao = subtrair.calcular(n1, n2);
                        System.out.println("Subtração: " + subtracao);
                        break;
                    case 3:
                        double multiplicacao = multiplicar.calcular(n1, n2);
                        System.out.println("Multiplicação: " + multiplicacao);
                        break;
                    case 4:
                        if (n2 == 0) {
                            System.out.println("Divisão por zero impossível");
                        } else {
                            double dividir = n1 / n2;
                            System.out.println("Divisão: " + dividir);
                        }
                        break;
                    default:
                        System.out.println("Opção invalida");
                        break;
                }
                System.out.println();
                System.out.println("------------------------------");
                System.out.println();
            } else {
                System.out.println("Encerrando o programa...");
            }
        } while (opcao != 0);

        //Finaliza o uso do Scanner e encerra o programa
        sc.close();
    }
}