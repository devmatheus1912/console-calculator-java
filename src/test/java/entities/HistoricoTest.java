package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HistoricoTest {

    @Test
    void deveIniciarComHistoricoVazio() {
        Historico historico = new Historico();
        assertEquals(0, historico.getTotalOperacoes());
    }

    @Test
    void deveAdicionarRegistroAoHistorico() {
        Historico historico = new Historico();
        RegistroOperacao registro = new RegistroOperacao(
                "Soma",
                "2.0 + 3.0 = 5.0",
                5.0
        );
        historico.adicionarRegistro(registro);
        assertEquals(1, historico.getTotalOperacoes());
    }

    @Test
    void deveLimparHistoricoCorretamente() {
        Historico historico = new Historico();
        historico.adicionarRegistro(new RegistroOperacao("Soma", "1.0 + 1.0 = 2.0", 2.0));
        historico.adicionarRegistro(new RegistroOperacao("Subtração", "5.0 - 3.0 = 2.0", 2.0));
        assertEquals(2, historico.getTotalOperacoes());
        historico.limparRegistros();
        assertEquals(0, historico.getTotalOperacoes());
    }
}