package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisaoTest {

    @Test
    void deveDividirCorretamente() {
        Divisao d = new Divisao();
        assertEquals(5.0, d.calcular(10, 2));
    }

    @Test
    void deveLancarErroDivisaoPorZero() {
        Divisao d = new Divisao();

        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> d.calcular(10, 0));
        assertEquals("Não é possível dividir por zero", exception.getMessage());
    }

    @Test
    void deveDividirNumeroNegativo() {
        Divisao d = new Divisao();
        assertEquals(-5.0, d.calcular(-10, 2));
    }
}