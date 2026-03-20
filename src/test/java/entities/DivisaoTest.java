package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DivisaoTest {

    @Test
    void deveDividirDoisNumerosCorretamente() {
        Divisao divisao = new Divisao();
        double resultado = divisao.calcular(10, 2);
        assertEquals(5.0, resultado);
    }

    @Test
    void deveLancarExcecaoAoDividirPorZero() {
        Divisao divisao = new Divisao();
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> divisao.calcular(10, 0)
        );

        assertEquals("Não é possível dividir por zero", exception.getMessage());
    }

    @Test
    void deveFormatarExpressaoDeDivisao() {
        Divisao divisao = new Divisao();
        String expressao = divisao.formatar(10, 2, 5);
        assertEquals("10.0 / 2.0 = 5.0", expressao);
    }
}