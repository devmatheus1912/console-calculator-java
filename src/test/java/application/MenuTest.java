package application;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MenuTest {

    @Test
    void deveRetornarOpcaoValidaQuandoUsuarioDigitarNumeroPermitido() {
        String entrada = "1\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        Menu menu = new Menu();
        int opcao = menu.exibirMenu(scanner);
        assertEquals(1, opcao);
    }

    @Test
    void deveAceitarOpcaoZeroParaSair() {
        String entrada = "0\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        Menu menu = new Menu();
        int opcao = menu.exibirMenu(scanner);
        assertEquals(0, opcao);
    }

    @Test
    void deveRejeitarOpcaoForaDoIntervaloEAceitarOpcaoValidaDepois() {
        String entrada = "99\n2\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        ByteArrayOutputStream saidaCapturada = new ByteArrayOutputStream();
        PrintStream saidaOriginal = System.out;
        System.setOut(new PrintStream(saidaCapturada));

        int opcao;
        try {
            Menu menu = new Menu();
            opcao = menu.exibirMenu(scanner);
        } finally {
            System.setOut(saidaOriginal);
        }

        String textoSaida = saidaCapturada.toString();

        assertEquals(2, opcao);
        assertTrue(textoSaida.contains("Opção inválida. Escolha um número entre 0 e 10."));
    }

    @Test
    void deveRejeitarEntradaNaoNumericaEAceitarOpcaoValidaDepois() {
        String entrada = "abc\n3\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        ByteArrayOutputStream saidaCapturada = new ByteArrayOutputStream();
        PrintStream saidaOriginal = System.out;
        System.setOut(new PrintStream(saidaCapturada));

        int opcao;
        try {
            Menu menu = new Menu();
            opcao = menu.exibirMenu(scanner);
        } finally {
            System.setOut(saidaOriginal);
        }

        String textoSaida = saidaCapturada.toString();

        assertEquals(3, opcao);
        assertTrue(textoSaida.contains("Erro: entrada inválida. Digite apenas números inteiros."));
    }

    @Test
    void deveExibirTituloDoMenu() {
        String entrada = "0\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(entrada.getBytes()));
        ByteArrayOutputStream saidaCapturada = new ByteArrayOutputStream();
        PrintStream saidaOriginal = System.out;
        System.setOut(new PrintStream(saidaCapturada));

        try {
            Menu menu = new Menu();
            menu.exibirMenu(scanner);
        } finally {
            System.setOut(saidaOriginal);
        }

        String textoSaida = saidaCapturada.toString();

        assertTrue(textoSaida.contains("CONSOLE CALCULATOR v3.0"));
        assertTrue(textoSaida.contains("1 - Somar"));
        assertTrue(textoSaida.contains("0 - Sair"));
        assertTrue(textoSaida.contains("Escolha uma opção: "));
    }
}