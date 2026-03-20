package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RaizQuadradaTest {

    @Test
    void deveCalcularRaizQuadradaCorretamente() {
        RaizQuadrada raizQuadrada = new RaizQuadrada();
        double resultado = raizQuadrada.calcular(25);
        assertEquals(5.0, resultado);
    }

    @Test
    void deveLancarExcecaoParaNumeroNegativo() {
        RaizQuadrada raizQuadrada = new RaizQuadrada();
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> raizQuadrada.calcular(-9)
        );
        assertEquals("Não é possível calcular raiz de número negativo", exception.getMessage());
    }

    @Test
    void deveFormatarExpressaoDeRaizQuadrada() {
        RaizQuadrada raizQuadrada = new RaizQuadrada();
        String expressao = raizQuadrada.formatar(25, 5);
        assertEquals("√25.0 = 5.0", expressao);
    }
}