package application;

import entities.OperacaoBinaria;
import entities.OperacaoUnaria;
import entities.ResultadoOperacao;
import exceptions.RegraDeNegocioException;
import service.CalculadoraService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AplicacaoCalculadora {

    private static final int OPCAO_SAIR = 0;
    private static final int OPCAO_HISTORICO = 9;
    private static final int OPCAO_LIMPAR_HISTORICO = 10;
    private static final String SEPARADOR = "------------------------------";

    private final IO io;
    private final Menu menu;
    private final CalculadoraService service;
    private final Map<Integer, OperacaoBinaria> operacoesBinarias;
    private final Map<Integer, OperacaoUnaria> operacoesUnarias;

    public AplicacaoCalculadora(
            IO io,
            Menu menu,
            CalculadoraService service,
            Map<Integer, OperacaoBinaria> operacoesBinarias,
            Map<Integer, OperacaoUnaria> operacoesUnarias
    ) {
        this.io = io;
        this.menu = menu;
        this.service = service;
        this.operacoesBinarias = operacoesBinarias;
        this.operacoesUnarias = operacoesUnarias;
    }

    public void executar() {
        int opcao;

        do {
            opcao = menu.exibirMenu();

            try {
                processarOpcao(opcao);
            } catch (RegraDeNegocioException e) {
                io.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                io.println("Erro inesperado: " + e.getMessage());
            }

            io.println(SEPARADOR);

        } while (opcao != OPCAO_SAIR);
    }

    private void processarOpcao(int opcao) {
        if (opcao == OPCAO_SAIR) {
            io.println("Encerrando calculadora...");
            return;
        }

        if (opcao == OPCAO_HISTORICO) {
            exibirHistorico();
            return;
        }

        if (opcao == OPCAO_LIMPAR_HISTORICO) {
            limparHistorico();
            return;
        }

        if (operacoesBinarias.containsKey(opcao)) {
            executarOperacaoBinaria(operacoesBinarias.get(opcao));
            return;
        }

        if (operacoesUnarias.containsKey(opcao)) {
            executarOperacaoUnaria(operacoesUnarias.get(opcao));
            return;
        }

        io.println("Opção inválida.");
    }

    private void executarOperacaoBinaria(OperacaoBinaria operacao) {
        double a = lerDouble("Digite o primeiro número: ");
        double b = lerDouble("Digite o segundo número: ");

        ResultadoOperacao resultado = service.executarBinaria(operacao, a, b);
        io.println("Operação: " + resultado.nomeOperacao());
        io.println("Expressão: " + resultado.expressao());
        io.println("Resultado: " + resultado.resultado());
    }

    private void executarOperacaoUnaria(OperacaoUnaria operacao) {
        double a = lerDouble("Digite o número: ");

        ResultadoOperacao resultado = service.executarUnaria(operacao, a);
        io.println("Operação: " + resultado.nomeOperacao());
        io.println("Expressão: " + resultado.expressao());
        io.println("Resultado: " + resultado.resultado());
    }

    private void exibirHistorico() {
        var historico = service.listarHistorico();

        if (historico.isEmpty()) {
            io.println("Nenhuma operação foi realizada ainda.");
            return;
        }

        io.println("================================");
        io.println(" HISTÓRICO DE OPERAÇÕES");
        io.println("================================");

        for (int i = 0; i < historico.size(); i++) {
            var registro = historico.get(i);
            io.println("[" + (i + 1) + "] " + registro.expressao());
        }

        io.println("================================");
        io.println("Total: " + historico.size() + " operação(ões)");
        io.println("================================");
    }

    private void limparHistorico() {
        List<?> historico = service.listarHistorico();

        if (historico.isEmpty()) {
            io.println("O histórico já estava vazio.");
            return;
        }

        service.limparHistorico();
        io.println("Histórico limpo com sucesso.");
    }

    private int lerInteiro(String mensagem) {
        while (true) {
            try {
                io.print(mensagem);
                return Integer.parseInt(io.readLine());
            } catch (NumberFormatException e) {
                io.println("Digite um número inteiro válido.");
            }
        }
    }

    private double lerDouble(String mensagem) {
        while (true) {
            try {
                io.print(mensagem);
                return Double.parseDouble(io.readLine().replace(",", "."));
            } catch (NumberFormatException e) {
                io.println("Digite um número válido.");
            }
        }
    }

    public static Map<Integer, OperacaoBinaria> criarOperacoesBinarias(Map<Integer, OperacaoBinaria> operacoes) {
        return new HashMap<>(operacoes);
    }

    public static Map<Integer, OperacaoUnaria> criarOperacoesUnarias(Map<Integer, OperacaoUnaria> operacoes) {
        return new HashMap<>(operacoes);
    }
}