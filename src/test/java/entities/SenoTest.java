package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SenoTest {

    @Test
    void deveCalcularSenoCorretamente() {
        Seno seno = new Seno();
        double resultado = seno.calcular(0);
        assertEquals(0.0, resultado, 0.0001);
    }

    @Test
    void deveLancarExcecaoParaAnguloMuitoGrande() {
        Seno seno = new Seno();
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> seno.calcular(10001)
        );
        assertEquals("Ângulo muito grande; use valores menores para precisão", exception.getMessage());
    }

    @Test
    void deveFormatarExpressaoDeSeno() {
        Seno seno = new Seno();
        String expressao = seno.formatar(0, 0);
        assertEquals("sen(0.0) = 0.0", expressao);
    }
}