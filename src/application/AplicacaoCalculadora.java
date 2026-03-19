package application;

import entities.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AplicacaoCalculadora {

    private static final int OPCAO_SAIR = 0;
    private static final int OPCAO_HISTORICO = 9;
    private static final int OPCAO_LIMPAR_HISTORICO = 10;
    private static final String SEPARADOR = "------------------------------";

    private final Scanner sc;
    private final Menu menu;
    private final Calculadora calculadora;
    private final Map<Integer, OperacaoBinaria> operacoesBinarias;
    private final Map<Integer, OperacaoUnaria> operacoesUnarias;

    public AplicacaoCalculadora() {
        this.sc = new Scanner(System.in);
        this.menu = new Menu();
        this.calculadora = new Calculadora();
        this.operacoesBinarias = criarOperacoesBinarias();
        this.operacoesUnarias = criarOperacoesUnarias();
    }

    public void iniciar() {
        int opcao;

        do {
            opcao = menu.exibirMenu(sc);

            if (opcao == OPCAO_HISTORICO) {
                calculadora.mostrarHistorico();
                System.out.println();
                continue;
            }

            if (opcao == OPCAO_LIMPAR_HISTORICO) {
                calculadora.limparHistorico();
                System.out.println("Histórico limpo com sucesso");
                mostrarSeparador();
                continue;
            }

            processarOpcao(opcao);

        } while (opcao != OPCAO_SAIR);

        encerrar();
    }

    private void processarOpcao(int opcao) {
        OperacaoBinaria operacaoBinaria = operacoesBinarias.get(opcao);
        OperacaoUnaria operacaoUnaria = operacoesUnarias.get(opcao);

        if (operacaoBinaria != null) {
            executarOperacaoBinaria(operacaoBinaria);
        } else if (operacaoUnaria != null) {
            executarOperacaoUnaria(operacaoUnaria);
        } else if (opcao != OPCAO_SAIR) {
            System.out.println("Opção inválida.");
            mostrarSeparador();
        }
    }

    private void executarOperacaoBinaria(OperacaoBinaria operacao) {
        double n1 = ValidadorEntrada.pedirNumeroValido(sc, "Digite o primeiro número: ");
        double n2 = ValidadorEntrada.pedirNumeroValido(sc, "Digite o segundo número: ");

        try {
            double resultado = calculadora.executarOperacao(operacao, n1, n2);
            mostrarSucesso(resultado);
        } catch (ArithmeticException e) {
            mostrarErro(e.getMessage());
        }
    }

    private void executarOperacaoUnaria(OperacaoUnaria operacao) {
        double n1 = ValidadorEntrada.pedirNumeroValido(sc, "Digite o número: ");

        try {
            double resultado = calculadora.executarOperacao(operacao, n1);
            mostrarSucesso(resultado);
        } catch (ArithmeticException e) {
            mostrarErro(e.getMessage());
        }
    }

    private void mostrarSucesso(double resultado) {
        mostrarSeparador();
        System.out.println("✓ Operação realizada com sucesso!");
        System.out.println("Resultado: " + resultado);
        System.out.println("Total de operações: " + calculadora.getTotalOperacoes());
        mostrarSeparador();
    }

    private void mostrarErro(String mensagem) {
        System.out.println("❌ Erro: " + mensagem);
        mostrarSeparador();
    }

    private void mostrarSeparador() {
        System.out.println(SEPARADOR);
    }

    private void encerrar() {
        sc.close();
        System.out.println("Calculadora encerrada.");
    }

    private Map<Integer, OperacaoBinaria> criarOperacoesBinarias() {
        Map<Integer, OperacaoBinaria> operacoes = new HashMap<>();
        operacoes.put(1, new Somar());
        operacoes.put(2, new Subtrair());
        operacoes.put(3, new Multiplicar());
        operacoes.put(4, new Divisao());
        operacoes.put(5, new Potencia());
        operacoes.put(7, new Logaritmo());
        return operacoes;
    }

    private Map<Integer, OperacaoUnaria> criarOperacoesUnarias() {
        Map<Integer, OperacaoUnaria> operacoes = new HashMap<>();
        operacoes.put(6, new RaizQuadrada());
        operacoes.put(8, new Seno());
        return operacoes;
    }
}