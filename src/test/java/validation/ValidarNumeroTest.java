package validation;

import exceptions.RegraDeNegocioException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidarNumeroTest {

    @Test
    void deveAceitarValorDentroDoIntervalo() {
        ValidarNumero validarNumero = new ValidarNumero();

        assertDoesNotThrow(() -> validarNumero.validar(0));
        assertDoesNotThrow(() -> validarNumero.validar(999999.99));
        assertDoesNotThrow(() -> validarNumero.validar(-999999.99));
    }

    @Test
    void deveAceitarValoresNosLimites() {
        ValidarNumero validarNumero = new ValidarNumero();

        assertDoesNotThrow(() -> validarNumero.validar(-1_000_000));
        assertDoesNotThrow(() -> validarNumero.validar(1_000_000));
    }

    @Test
    void deveLancarErroQuandoValorForMenorQueOMinimo() {
        ValidarNumero validarNumero = new ValidarNumero();

        RegraDeNegocioException ex = assertThrows(RegraDeNegocioException.class,
                () -> validarNumero.validar(-1_000_001));

        assertEquals("Valor deve estar entre -1000000.0 e 1000000.0.", ex.getMessage());
    }

    @Test
    void deveLancarErroQuandoValorForMaiorQueOMaximo() {
        ValidarNumero validarNumero = new ValidarNumero();

        RegraDeNegocioException ex = assertThrows(RegraDeNegocioException.class,
                () -> validarNumero.validar(1_000_001));

        assertEquals("Valor deve estar entre -1000000.0 e 1000000.0.", ex.getMessage());
    }
}