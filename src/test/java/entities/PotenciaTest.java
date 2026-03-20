package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PotenciaTest {

    @Test
    void deveCalcularPotenciaCorretamente() {
        Potencia potencia = new Potencia();
        double resultado = potencia.calcular(2, 3);
        assertEquals(8.0, resultado);
    }

    @Test
    void deveFormatarExpressaoDePotencia() {
        Potencia potencia = new Potencia();
        String expressao = potencia.formatar(2, 3, 8);
        assertEquals("2.0 ^ 3.0 = 8.0", expressao);
    }
}