package application;

import entities.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Menu menu = new Menu();
        Calculadora calculadora = new Calculadora();

        // Mapa de operações (substitui o switch)
        Map<Integer, Operacao> operacoes = criarOperacoes();

        int opcao;

        do {
            opcao = menu.exibirMenu(sc);

            // Opção: Ver histórico
            if (opcao == 9) {
                calculadora.mostrarHistorico();
                System.out.println();
                continue;
            }

            // Opção: Limpar histórico
            if (opcao == 10) {
                calculadora.limparHistorico();
                System.out.println("Histórico limpo com sucesso");
                System.out.println("------------------------------");
                continue;
            }

            // Busca a operação no Map
            Operacao operacaoEscolhida = operacoes.get(opcao);

            // Se não existir operação
            if (operacaoEscolhida == null && opcao != 0) {
                System.out.println("Opção inválida.");
                System.out.println("------------------------------");
                continue;
            }

            // Executa operação
            if (operacaoEscolhida != null) {

                double n1 = ValidadorEntrada.pedirNumeroValido(sc, "Digite o primeiro número: ");
                double n2 = 0;

                // Algumas operações usam só 1 número
                if (precisaSegundoNumero(opcao)) {
                    n2 = ValidadorEntrada.pedirNumeroValido(sc, "Digite o segundo número: ");
                }

                try {
                    double resultado = calculadora.executar(operacaoEscolhida, n1, n2);

                    System.out.println("------------------------------");
                    System.out.println("✓ Operação realizada com sucesso!");
                    System.out.println("Resultado: " + resultado);
                    System.out.println("Total de operações: " + calculadora.getTotalOperacoes());
                    System.out.println("------------------------------");

                } catch (ArithmeticException e) {
                    System.out.println("❌ Erro: " + e.getMessage());
                    System.out.println("------------------------------");
                }
            }

        } while (opcao != 0);

        sc.close();
    }

    // Cria o mapa de operações
    private static Map<Integer, Operacao> criarOperacoes() {
        Map<Integer, Operacao> operacoes = new HashMap<>();

        operacoes.put(1, new Somar());
        operacoes.put(2, new Subtrair());
        operacoes.put(3, new Multiplicar());
        operacoes.put(4, new Divisao());
        operacoes.put(5, new Potencia());
        operacoes.put(6, new RaizQuadrada());
        operacoes.put(7, new Logaritmo());
        operacoes.put(8, new Seno());

        return operacoes;
    }

    // Define se precisa de dois números
    private static boolean precisaSegundoNumero(int opcao) {
        return opcao != 6 && opcao != 8;
    }
}