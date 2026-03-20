package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoricoTest {

    @Test
    void deveIniciarComHistoricoVazio() {
        Historico historico = new Historico();
        assertEquals(0, historico.getTotalOperacoes());
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
}