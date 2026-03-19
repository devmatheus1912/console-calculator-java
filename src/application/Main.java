package application;

import entities.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final int OPCAO_SAIR = 0;
    private static final int OPCAO_HISTORICO = 9;
    private static final int OPCAO_LIMPAR_HISTORICO = 10;

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Menu menu = new Menu();
        Calculadora calculadora = new Calculadora();

        Map<Integer, OperacaoBinaria> operacoesBinarias = criarOperacoesBinarias();
        Map<Integer, OperacaoUnaria> operacoesUnarias = criarOperacoesUnarias();

        int opcao;

        do {
            opcao = menu.exibirMenu(sc);

            // Opção: Ver histórico
            if (opcao == OPCAO_HISTORICO) {
                calculadora.mostrarHistorico();
                System.out.println();
                continue;
            }

            // Opção: Limpar histórico
            if (opcao == OPCAO_LIMPAR_HISTORICO) {
                calculadora.limparHistorico();
                System.out.println("Histórico limpo com sucesso");
                System.out.println("------------------------------");
                continue;
            }

            OperacaoBinaria operacaoBinaria = operacoesBinarias.get(opcao);
            OperacaoUnaria operacaoUnaria = operacoesUnarias.get(opcao);

            // Se for operação binária
            if (operacaoBinaria != null) {
                double n1 = ValidadorEntrada.pedirNumeroValido(sc, "Digite o primeiro número: ");
                double n2 = ValidadorEntrada.pedirNumeroValido(sc, "Digite o segundo número: ");

                try {
                    double resultado = calculadora.executarOperacao(operacaoBinaria, n1, n2);

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

            // Se for operação unária
            else if (operacaoUnaria != null) {
                double n1 = ValidadorEntrada.pedirNumeroValido(sc, "Digite o número: ");

                try {
                    double resultado = calculadora.executarOperacao(operacaoUnaria, n1);

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

            // Se não existir operação
            else if (opcao != OPCAO_SAIR) {
                System.out.println("Opção inválida.");
                System.out.println("------------------------------");
            }

        } while (opcao != OPCAO_SAIR);

        sc.close();
    }

    private static Map<Integer, OperacaoBinaria> criarOperacoesBinarias() {
        Map<Integer, OperacaoBinaria> operacoes = new HashMap<>();

        operacoes.put(1, new Somar());
        operacoes.put(2, new Subtrair());
        operacoes.put(3, new Multiplicar());
        operacoes.put(4, new Divisao());
        operacoes.put(5, new Potencia());
        operacoes.put(7, new Logaritmo());

        return operacoes;
    }

    private static Map<Integer, OperacaoUnaria> criarOperacoesUnarias() {
        Map<Integer, OperacaoUnaria> operacoes = new HashMap<>();

        operacoes.put(6, new RaizQuadrada());
        operacoes.put(8, new Seno());

        return operacoes;
    }
}