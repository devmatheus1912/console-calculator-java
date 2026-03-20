package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubtrairTest {
    @Test
    void deveSubtrairDoisNumerosCorretamente() {
        Subtrair subtrair = new Subtrair();
        double resultado = subtrair.calcular(10, 3);
        assertEquals(7.0, resultado);
    }

    @Test
    void deveFormatarExpressaoDeSubtracao() {
        Subtrair subtrair = new Subtrair();
        String expressao = subtrair.formatar(10, 3, 7);
        assertEquals("10.0 - 3.0 = 7.0", expressao);
    }
}

