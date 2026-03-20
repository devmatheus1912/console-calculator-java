package entities;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HistoricoTest {

    @Test
    void deveIniciarComHistoricoVazio() {
        Historico historico = new Historico();

        assertEquals(0, historico.getTotalOperacoes());
        assertTrue(historico.listar().isEmpty());
    }

    @Test
    void deveAdicionarRegistroAoHistorico() {
        Historico historico = new Historico();

        historico.adicionarRegistro(new RegistroOperacao("Soma", "2+3", 5));

        assertEquals(1, historico.getTotalOperacoes());
    }

    @Test
    void deveContarMultiplosRegistros() {
        Historico historico = new Historico();
        historico.adicionarRegistro(new RegistroOperacao("Soma", "1+1", 2));
        historico.adicionarRegistro(new RegistroOperacao("Sub", "5-2", 3));

        assertEquals(2, historico.getTotalOperacoes());
    }

    @Test
    void listarDeveRetornarCopiaImutavel() {
        Historico historico = new Historico();
        historico.adicionarRegistro(new RegistroOperacao("Soma", "1+1", 2));

        List<RegistroOperacao> lista = historico.listar();

        assertThrows(UnsupportedOperationException.class,
                () -> lista.add(new RegistroOperacao("Sub", "5-2", 3)));
    }

    @Test
    void deveLimparHistorico() {
        Historico historico = new Historico();
        historico.adicionarRegistro(new RegistroOperacao("Soma", "1+1", 2));

        historico.limparRegistros();

        assertEquals(0, historico.getTotalOperacoes());
    }

    @Test
    void limparHistoricoVazioNaoQuebra() {
        Historico historico = new Historico();

        historico.limparRegistros();

        assertEquals(0, historico.getTotalOperacoes());
    }

    @Test
    void deveMostrarMensagemQuandoHistoricoEstiverVazio() {
        Historico historico = new Historico();

        String saida = capturarSaida(historico::mostrarRegistros);

        assertTrue(saida.contains("Nenhuma operação foi realizada ainda."));
    }

    @Test
    void deveMostrarRegistrosQuandoHistoricoTiverDados() {
        Historico historico = new Historico();
        historico.adicionarRegistro(new RegistroOperacao("Soma", "1 + 1 = 2", 2.0));

        String saida = capturarSaida(historico::mostrarRegistros);

        assertTrue(saida.contains("HISTÓRICO DE OPERAÇÕES"));
        assertTrue(saida.contains("Total: 1 operação(ões)"));
    }

    private String capturarSaida(Runnable runnable) {
        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(saida));
        try {
            runnable.run();
        } finally {
            System.setOut(original);
        }
        return saida.toString();
    }
}