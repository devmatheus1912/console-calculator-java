package application;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConsoleIOTest {

    @Test
    void deveLerLinhaCorretamente() {
        ConsoleIO io = new ConsoleIO(new Scanner(new ByteArrayInputStream("teste\n".getBytes())));

        String linha = io.readLine();

        assertEquals("teste", linha);
    }

    @Test
    void deveImprimirComPrintEPrintln() {
        ConsoleIO io = new ConsoleIO(new Scanner(new ByteArrayInputStream(new byte[0])));
        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(saida));

        try {
            io.print("abc");
            io.println("def");
        } finally {
            System.setOut(originalOut);
        }

        String texto = saida.toString();
        assertTrue(texto.contains("abcdef"));
    }
}