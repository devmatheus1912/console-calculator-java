package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiplicarTest {

    @Test
    void deveMultiplicarDoisNumerosCorretamente() {
        Multiplicar multiplicar = new Multiplicar();
        double resultado = multiplicar.calcular(4, 5);
        assertEquals(20.0, resultado);
    }

    @Test
    void deveFormatarExpressaoDeMultiplicacao() {
        Multiplicar multiplicar = new Multiplicar();
        String expressao = multiplicar.formatar(4, 5, 20);
        assertEquals("4.0 * 5.0 = 20.0", expressao);
    }
}