package application;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @Test
    void deveExecutarMainSemErro() {
        String entrada = "0\n"; // sair imediatamente

        ByteArrayInputStream input = new ByteArrayInputStream(entrada.getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        java.io.InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        System.setIn(input);
        System.setOut(new PrintStream(output));

        try {
            assertDoesNotThrow(() -> Main.main(new String[]{}));
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        String textoSaida = output.toString();

        assertTrue(textoSaida.contains("Calculadora encerrada."));
    }
}