package entities;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultadoOperacaoTest {

    @Test
    void deveCriarResultadoOperacaoCorretamente() {
        LocalDateTime dataHora = LocalDateTime.of(2026, 3, 20, 18, 30);
        ResultadoOperacao resultado = new ResultadoOperacao(
                "Soma",
                "2.0 + 3.0 = 5.0",
                5.0,
                dataHora
        );

        assertEquals("Soma", resultado.nomeOperacao());
        assertEquals("2.0 + 3.0 = 5.0", resultado.expressao());
        assertEquals(5.0, resultado.resultado());
        assertEquals(dataHora, resultado.dataHora());
    }
}