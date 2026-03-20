package application;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorEntradaTest {

    @Test
    void deveLerNumeroValidoDentroDoIntervaloPadrao() {
        String entrada = "10\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(entrada.getBytes()));

        double valor = ValidadorEntrada.pedirNumeroValido(scanner, "Digite um número: ");

        assertEquals(10.0, valor);
    }

    @Test
    void deveIgnorarEntradaInvalidaEAceitarNumeroValidoDepois() {
        String entrada = "abc\n5\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        ByteArrayOutputStream saidaCapturada = new ByteArrayOutputStream();
        PrintStream saidaOriginal = System.out;
        System.setOut(new PrintStream(saidaCapturada));

        double valor;
        try {
            valor = ValidadorEntrada.pedirNumeroValido(scanner, "Digite um número: ");
        } finally {
            System.setOut(saidaOriginal);
        }

        String textoSaida = saidaCapturada.toString();
        assertEquals(5.0, valor);
        assertTrue(textoSaida.contains("Erro: digite um número válido."));
    }

    @Test
    void deveRejeitarNumeroAbaixoDoMinimoEAceitarOutroValido() {
        String entrada = "-20\n7\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        ByteArrayOutputStream saidaCapturada = new ByteArrayOutputStream();
        PrintStream saidaOriginal = System.out;
        System.setOut(new PrintStream(saidaCapturada));

        double valor;
        try {
            valor = ValidadorEntrada.pedirNumeroValido(scanner, "Digite um número: ", 0, 10);
        } finally {
            System.setOut(saidaOriginal);
        }

        String textoSaida = saidaCapturada.toString();
        assertEquals(7.0, valor);
        assertTrue(textoSaida.contains("Erro: o número deve estar entre 0.0 e 10.0."));
    }

    @Test
    void deveRejeitarNumeroAcimaDoMaximoEAceitarOutroValido() {
        String entrada = "50\n8\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        ByteArrayOutputStream saidaCapturada = new ByteArrayOutputStream();
        PrintStream saidaOriginal = System.out;
        System.setOut(new PrintStream(saidaCapturada));

        double valor;
        try {
            valor = ValidadorEntrada.pedirNumeroValido(scanner, "Digite um número: ", 0, 10);
        } finally {
            System.setOut(saidaOriginal);
        }

        String textoSaida = saidaCapturada.toString();
        assertEquals(8.0, valor);
        assertTrue(textoSaida.contains("Erro: o número deve estar entre 0.0 e 10.0."));
    }

    @Test
    void deveAceitarNumeroNosLimitesMinimoEMaximo() {
        String entradaMinimo = "0\n";
        Scanner scannerMinimo = new Scanner(new ByteArrayInputStream(entradaMinimo.getBytes()));
        double valorMinimo = ValidadorEntrada.pedirNumeroValido(scannerMinimo, "Digite um número: ", 0, 10);
        assertEquals(0.0, valorMinimo);

        String entradaMaximo = "10\n";
        Scanner scannerMaximo = new Scanner(new ByteArrayInputStream(entradaMaximo.getBytes()));
        double valorMaximo = ValidadorEntrada.pedirNumeroValido(scannerMaximo, "Digite um número: ", 0, 10);
        assertEquals(10.0, valorMaximo);
    }

    @Test
    void deveCobrirConstrutorPrivado() throws Exception {
        Constructor<ValidadorEntrada> constructor = ValidadorEntrada.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        ValidadorEntrada instancia = constructor.newInstance();

        assertNotNull(instancia);
    }
}