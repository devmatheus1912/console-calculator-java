package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegistroOperacaoTest {
    @Test
    void deveCriarRegistroComDadosCorretos(){
        RegistroOperacao registro = new RegistroOperacao("Soma", "10 + 5", 15.0);
        assertEquals("Soma", registro.getNomeOperacao());
        assertEquals("10 + 5", registro.getExpressao());
        assertEquals(15.0, registro.getResultado());
        assertNotNull(registro.getDataHora());
    }
    @Test
    void toStringDeveConterInformacoesPrincipais() {
        RegistroOperacao registro = new RegistroOperacao("Soma", "10 + 5", 15.0);

        String texto = registro.toString();

        assertTrue(texto.contains("Soma"));
        assertTrue(texto.contains("10 + 5"));
        assertTrue(texto.contains("15.0"));
    }
}
