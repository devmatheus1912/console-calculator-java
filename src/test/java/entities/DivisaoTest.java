package entities;

import exceptions.RegraDeNegocioException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DivisaoTest {

    @Test
    void deveDividirCorretamente() {
        Divisao d = new Divisao();
        assertEquals(5.0, d.calcular(10, 2));
    }

    @Test
    void deveLancarErroDivisaoPorZero() {
        Divisao d = new Divisao();

        RegraDeNegocioException exception = assertThrows(
                RegraDeNegocioException.class,
                () -> d.calcular(10, 0)
        );

        assertEquals("Não é possível dividir por zero.", exception.getMessage());
    }

    @Test
    void deveDividirNumeroNegativo() {
        Divisao d = new Divisao();
        assertEquals(-5.0, d.calcular(-10, 2));
    }
}