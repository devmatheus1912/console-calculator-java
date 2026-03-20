package entities;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class RegistroOperacaoTest {

    @Test
    void deveCriarRegistroComConstrutorReduzido() {
        RegistroOperacao registro = new RegistroOperacao("Soma", "10 + 5", 15.0);

        assertEquals("Soma", registro.nomeOperacao());
        assertEquals("10 + 5", registro.expressao());
        assertEquals(15.0, registro.resultado());
        assertNotNull(registro.dataHora());
    }

    @Test
    void deveCriarRegistroComConstrutorCompleto() {
        LocalDateTime dataHora = LocalDateTime.of(2026, 3, 20, 18, 0);
        RegistroOperacao registro = new RegistroOperacao("Soma", "10 + 5", 15.0, dataHora);

        assertEquals("Soma", registro.nomeOperacao());
        assertEquals("10 + 5", registro.expressao());
        assertEquals(15.0, registro.resultado());
        assertEquals(dataHora, registro.dataHora());
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