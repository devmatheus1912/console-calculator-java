package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomarTest {
    @Test
    void deveSomarDoisNumerosCorretamente() {
        Somar somar = new Somar();
        double resultado = somar.calcular(10, 5);
        assertEquals(15.0, resultado);
    }

    @Test
    void deveFormatarExpressaoDeSomar() {
        Somar somar = new Somar();
        String expressao = somar.formatar(10, 5, 15);
        assertEquals("10.0 + 5.0 = 15.0", expressao);
    }
}