package entities;

import exceptions.RegraDeNegocioException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LogaritmoTest {

    @Test
    void deveCalcularLogaritmoCorretamente() {
        Logaritmo logaritmo = new Logaritmo();
        double resultado = logaritmo.calcular(8, 2);
        assertEquals(3.0, resultado, 0.0001);
    }

    @Test
    void deveLancarExcecaoQuandoNumeroForMenorOuIgualAZero() {
        Logaritmo logaritmo = new Logaritmo();

        RegraDeNegocioException exception = assertThrows(
                RegraDeNegocioException.class,
                () -> logaritmo.calcular(0, 2)
        );

        assertEquals("Logaritmo só existe para números positivos.", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoBaseForInvalida() {
        Logaritmo logaritmo = new Logaritmo();

        RegraDeNegocioException exception = assertThrows(
                RegraDeNegocioException.class,
                () -> logaritmo.calcular(8, 1)
        );

        assertEquals("A base do logaritmo deve ser positiva e diferente de 1.", exception.getMessage());
    }

    @Test
    void deveFormatarExpressaoDeLogaritmo() {
        Logaritmo logaritmo = new Logaritmo();
        String expressao = logaritmo.formatar(8, 2, 3);
        assertEquals("log 8.0 na base 2.0 = 3.0", expressao);
    }
}