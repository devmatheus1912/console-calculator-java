package application;

import entities.*;
import org.junit.jupiter.api.Test;
import repository.HistoricoEmMemoriaRepository;
import service.CalculadoraService;
import validation.ValidarNumero;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AplicacaoCalculadoraCoverageTest {

    @Test
    void deveCriarCopiaDoMapaDeOperacoesBinarias() {
        Map<Integer, OperacaoBinaria> original = new HashMap<>();
        original.put(1, new Somar());
        original.put(2, new Subtrair());
        original.put(3, new Multiplicar());
        original.put(4, new Divisao());
        original.put(5, new Potencia());
        original.put(7, new Logaritmo());

        Map<Integer, OperacaoBinaria> copia = AplicacaoCalculadora.criarOperacoesBinarias(original);

        assertEquals(6, copia.size());
        assertTrue(copia.containsKey(1));
        assertTrue(copia.containsKey(2));
        assertTrue(copia.containsKey(3));
        assertTrue(copia.containsKey(4));
        assertTrue(copia.containsKey(5));
        assertTrue(copia.containsKey(7));
        assertNotSame(original, copia);
    }

    @Test
    void deveCriarCopiaDoMapaDeOperacoesUnarias() {
        Map<Integer, OperacaoUnaria> original = new HashMap<>();
        original.put(6, new RaizQuadrada());
        original.put(8, new Seno());

        Map<Integer, OperacaoUnaria> copia = AplicacaoCalculadora.criarOperacoesUnarias(original);

        assertEquals(2, copia.size());
        assertTrue(copia.containsKey(6));
        assertTrue(copia.containsKey(8));
        assertNotSame(original, copia);
    }

    @Test
    void deveLerInteiroAposEntradaInvalida() throws Exception {
        AplicacaoCalculadora app = novaAppComEntrada("abc\n5\n");
        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(saida));

        try {
            Method metodo = AplicacaoCalculadora.class.getDeclaredMethod("lerInteiro", String.class);
            metodo.setAccessible(true);

            int valor = (int) metodo.invoke(app, "Escolha uma opção: ");

            assertEquals(5, valor);
        } finally {
            System.setOut(originalOut);
        }

        assertTrue(saida.toString().contains("Digite um número inteiro válido."));
    }

    @Test
    void deveLerDoubleAposEntradaInvalidaEAceitarVirgula() throws Exception {
        AplicacaoCalculadora app = novaAppComEntrada("x\n1,5\n");
        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(saida));

        try {
            Method metodo = AplicacaoCalculadora.class.getDeclaredMethod("lerDouble", String.class);
            metodo.setAccessible(true);

            double valor = (double) metodo.invoke(app, "Digite o número: ");

            assertEquals(1.5, valor);
        } finally {
            System.setOut(originalOut);
        }

        assertTrue(saida.toString().contains("Digite um número válido."));
    }

    @Test
    void deveProcessarOpcaoSair() throws Exception {
        AplicacaoCalculadora app = novaAppComEntrada("");
        String saida = capturarSaida(() -> invocarProcessarOpcao(app, 0));

        assertTrue(saida.contains("Encerrando calculadora..."));
    }

    @Test
    void deveExibirHistoricoVazio() throws Exception {
        AplicacaoCalculadora app = novaAppComEntrada("");
        String saida = capturarSaida(() -> invocarProcessarOpcao(app, 9));

        assertTrue(saida.contains("Nenhuma operação foi realizada ainda."));
    }

    @Test
    void deveLimparHistoricoVazio() throws Exception {
        AplicacaoCalculadora app = novaAppComEntrada("");
        String saida = capturarSaida(() -> invocarProcessarOpcao(app, 10));

        assertTrue(saida.contains("O histórico já estava vazio."));
    }

    @Test
    void deveProcessarOpcaoInvalida() throws Exception {
        AplicacaoCalculadora app = novaAppComEntrada("");
        String saida = capturarSaida(() -> invocarProcessarOpcao(app, 99));

        assertTrue(saida.contains("Opção inválida."));
    }

    @Test
    void deveExecutarOperacaoBinariaViaProcessarOpcao() throws Exception {
        AplicacaoCalculadora app = novaAppComEntrada("2\n3\n");
        String saida = capturarSaida(() -> invocarProcessarOpcao(app, 1));

        assertTrue(saida.contains("Operação: Soma"));
        assertTrue(saida.contains("Expressão: 2.0 + 3.0 = 5.0"));
        assertTrue(saida.contains("Resultado: 5.0"));
    }

    @Test
    void deveExecutarOperacaoUnariaViaProcessarOpcao() throws Exception {
        AplicacaoCalculadora app = novaAppComEntrada("9\n");
        String saida = capturarSaida(() -> invocarProcessarOpcao(app, 6));

        assertTrue(saida.contains("Operação: Raiz Quadrada"));
        assertTrue(saida.contains("Expressão: √9.0 = 3.0"));
        assertTrue(saida.contains("Resultado: 3.0"));
    }

    @Test
    void deveExibirHistoricoComDados() throws Exception {
        CalculadoraService service = new CalculadoraService(
                new Calculadora(),
                new ValidarNumero(),
                new HistoricoEmMemoriaRepository()
        );
        service.executarBinaria(new Somar(), 2, 3);

        AplicacaoCalculadora app = novaAppComService("", service);
        String saida = capturarSaida(() -> invocarProcessarOpcao(app, 9));

        assertTrue(saida.contains("HISTÓRICO DE OPERAÇÕES"));
        assertTrue(saida.contains("2.0 + 3.0 = 5.0"));
        assertTrue(saida.contains("Total: 1 operação(ões)"));
    }

    @Test
    void deveLimparHistoricoComDados() throws Exception {
        CalculadoraService service = new CalculadoraService(
                new Calculadora(),
                new ValidarNumero(),
                new HistoricoEmMemoriaRepository()
        );
        service.executarBinaria(new Somar(), 2, 3);

        AplicacaoCalculadora app = novaAppComService("", service);
        String saida = capturarSaida(() -> invocarProcessarOpcao(app, 10));

        assertTrue(saida.contains("Histórico limpo com sucesso."));
        assertTrue(service.listarHistorico().isEmpty());
    }

    @Test
    void deveCapturarRegraDeNegocioNoFluxoExecutar() {
        AplicacaoCalculadora app = novaAppComService(
                "1\n1000001\n1\n0\n",
                new CalculadoraService(
                        new Calculadora(),
                        new ValidarNumero(),
                        new HistoricoEmMemoriaRepository()
                )
        );

        String saida = capturarSaida(app::executar);

        assertTrue(saida.contains("Erro: Valor deve estar entre -1000000.0 e 1000000.0."));
    }

    @Test
    void deveCapturarErroInesperadoNoFluxoExecutar() {
        AplicacaoCalculadora app = novaAppComService(
                "1\n2\n3\n0\n",
                new ThrowingService()
        );

        String saida = capturarSaida(app::executar);

        assertTrue(saida.contains("Erro inesperado: boom"));
    }

    private AplicacaoCalculadora novaAppComEntrada(String entrada) {
        return novaAppComService(
                entrada,
                new CalculadoraService(
                        new Calculadora(),
                        new ValidarNumero(),
                        new HistoricoEmMemoriaRepository()
                )
        );
    }

    private AplicacaoCalculadora novaAppComService(String entrada, CalculadoraService service) {
        IO io = new ConsoleIO(new java.util.Scanner(new ByteArrayInputStream(entrada.getBytes())));
        Menu menu = new Menu(io);

        Map<Integer, OperacaoBinaria> operacoesBinarias = new HashMap<>();
        operacoesBinarias.put(1, new Somar());
        operacoesBinarias.put(2, new Subtrair());
        operacoesBinarias.put(3, new Multiplicar());
        operacoesBinarias.put(4, new Divisao());
        operacoesBinarias.put(5, new Potencia());
        operacoesBinarias.put(7, new Logaritmo());

        Map<Integer, OperacaoUnaria> operacoesUnarias = new HashMap<>();
        operacoesUnarias.put(6, new RaizQuadrada());
        operacoesUnarias.put(8, new Seno());

        return new AplicacaoCalculadora(io, menu, service, operacoesBinarias, operacoesUnarias);
    }

    private void invocarProcessarOpcao(AplicacaoCalculadora app, int opcao) throws Exception {
        Method metodo = AplicacaoCalculadora.class.getDeclaredMethod("processarOpcao", int.class);
        metodo.setAccessible(true);
        metodo.invoke(app, opcao);
    }

    private String capturarSaida(ThrowingRunnable runnable) {
        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(saida));
        try {
            runnable.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.setOut(originalOut);
        }
        return saida.toString();
    }

    @FunctionalInterface
    interface ThrowingRunnable {
        void run() throws Exception;
    }

    static class ThrowingService extends CalculadoraService {
        ThrowingService() {
            super(new Calculadora(), new ValidarNumero(), new HistoricoEmMemoriaRepository());
        }

        @Override
        public ResultadoOperacao executarBinaria(OperacaoBinaria op, double a, double b) {
            throw new RuntimeException("boom");
        }

        @Override
        public ResultadoOperacao executarUnaria(OperacaoUnaria op, double a) {
            throw new RuntimeException("boom");
        }
    }
}