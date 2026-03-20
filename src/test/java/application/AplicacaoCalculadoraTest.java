package application;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AplicacaoCalculadoraTest {

    @Test
    void deveEncerrarQuandoUsuarioEscolherSair() {
        String entrada = "0\n";

        ByteArrayInputStream entradaSimulada = new ByteArrayInputStream(entrada.getBytes());
        ByteArrayOutputStream saidaCapturada = new ByteArrayOutputStream();

        PrintStream saidaOriginal = System.out;
        java.io.InputStream entradaOriginal = System.in;

        System.setIn(entradaSimulada);
        System.setOut(new PrintStream(saidaCapturada));

        try {
            AplicacaoCalculadora aplicacao = new AplicacaoCalculadora();

            assertDoesNotThrow(aplicacao::iniciar);
        } finally {
            System.setIn(entradaOriginal);
            System.setOut(saidaOriginal);
        }

        String textoSaida = saidaCapturada.toString();

        assertTrue(textoSaida.contains("Calculadora encerrada."));
    }

    @Test
    void deveExecutarSomaComSucesso() {
        String entrada = "1\n10\n5\n0\n";

        ByteArrayInputStream entradaSimulada = new ByteArrayInputStream(entrada.getBytes());
        ByteArrayOutputStream saidaCapturada = new ByteArrayOutputStream();

        PrintStream saidaOriginal = System.out;
        java.io.InputStream entradaOriginal = System.in;

        System.setIn(entradaSimulada);
        System.setOut(new PrintStream(saidaCapturada));

        try {
            AplicacaoCalculadora aplicacao = new AplicacaoCalculadora();
            aplicacao.iniciar();
        } finally {
            System.setIn(entradaOriginal);
            System.setOut(saidaOriginal);
        }

        String textoSaida = saidaCapturada.toString();

        assertTrue(textoSaida.contains("✓ Operação realizada com sucesso!"));
        assertTrue(textoSaida.contains("Operação: Soma"));
        assertTrue(textoSaida.contains("Resultado: 15.0"));
        assertTrue(textoSaida.contains("Total de operações: 1"));
    }

    @Test
    void deveExecutarRaizQuadradaComSucesso() {
        String entrada = "6\n9\n0\n";

        ByteArrayInputStream entradaSimulada = new ByteArrayInputStream(entrada.getBytes());
        ByteArrayOutputStream saidaCapturada = new ByteArrayOutputStream();

        PrintStream saidaOriginal = System.out;
        java.io.InputStream entradaOriginal = System.in;

        System.setIn(entradaSimulada);
        System.setOut(new PrintStream(saidaCapturada));

        try {
            AplicacaoCalculadora aplicacao = new AplicacaoCalculadora();
            aplicacao.iniciar();
        } finally {
            System.setIn(entradaOriginal);
            System.setOut(saidaOriginal);
        }

        String textoSaida = saidaCapturada.toString();

        assertTrue(textoSaida.contains("✓ Operação realizada com sucesso!"));
        assertTrue(textoSaida.contains("Operação: Raiz Quadrada"));
        assertTrue(textoSaida.contains("Resultado: 3.0"));
        assertTrue(textoSaida.contains("Total de operações: 1"));
    }

    @Test
    void deveMostrarErroAoDividirPorZero() {
        String entrada = "4\n10\n0\n0\n";

        ByteArrayInputStream entradaSimulada = new ByteArrayInputStream(entrada.getBytes());
        ByteArrayOutputStream saidaCapturada = new ByteArrayOutputStream();

        PrintStream saidaOriginal = System.out;
        java.io.InputStream entradaOriginal = System.in;

        System.setIn(entradaSimulada);
        System.setOut(new PrintStream(saidaCapturada));

        try {
            AplicacaoCalculadora aplicacao = new AplicacaoCalculadora();
            aplicacao.iniciar();
        } finally {
            System.setIn(entradaOriginal);
            System.setOut(saidaOriginal);
        }

        String textoSaida = saidaCapturada.toString();

        assertTrue(textoSaida.contains("❌ Erro:"));
    }

    @Test
    void deveMostrarHistoricoQuandoSolicitado() {
        String entrada = "1\n2\n3\n9\n0\n";

        ByteArrayInputStream entradaSimulada = new ByteArrayInputStream(entrada.getBytes());
        ByteArrayOutputStream saidaCapturada = new ByteArrayOutputStream();

        PrintStream saidaOriginal = System.out;
        java.io.InputStream entradaOriginal = System.in;

        System.setIn(entradaSimulada);
        System.setOut(new PrintStream(saidaCapturada));

        try {
            AplicacaoCalculadora aplicacao = new AplicacaoCalculadora();
            aplicacao.iniciar();
        } finally {
            System.setIn(entradaOriginal);
            System.setOut(saidaOriginal);
        }

        String textoSaida = saidaCapturada.toString();

        assertTrue(textoSaida.contains("Operação: Soma"));
        assertTrue(textoSaida.contains("Resultado: 5.0"));
    }

    @Test
    void deveLimparHistoricoComSucessoQuandoHouverRegistros() {
        String entrada = "1\n2\n3\n10\n0\n";

        ByteArrayInputStream entradaSimulada = new ByteArrayInputStream(entrada.getBytes());
        ByteArrayOutputStream saidaCapturada = new ByteArrayOutputStream();

        PrintStream saidaOriginal = System.out;
        java.io.InputStream entradaOriginal = System.in;

        System.setIn(entradaSimulada);
        System.setOut(new PrintStream(saidaCapturada));

        try {
            AplicacaoCalculadora aplicacao = new AplicacaoCalculadora();
            aplicacao.iniciar();
        } finally {
            System.setIn(entradaOriginal);
            System.setOut(saidaOriginal);
        }

        String textoSaida = saidaCapturada.toString();

        assertTrue(textoSaida.contains("Histórico limpo com sucesso."));
    }

    @Test
    void deveInformarQuandoHistoricoJaEstiverVazio() {
        String entrada = "10\n0\n";

        ByteArrayInputStream entradaSimulada = new ByteArrayInputStream(entrada.getBytes());
        ByteArrayOutputStream saidaCapturada = new ByteArrayOutputStream();

        PrintStream saidaOriginal = System.out;
        java.io.InputStream entradaOriginal = System.in;

        System.setIn(entradaSimulada);
        System.setOut(new PrintStream(saidaCapturada));

        try {
            AplicacaoCalculadora aplicacao = new AplicacaoCalculadora();
            aplicacao.iniciar();
        } finally {
            System.setIn(entradaOriginal);
            System.setOut(saidaOriginal);
        }

        String textoSaida = saidaCapturada.toString();

        assertTrue(textoSaida.contains("O histórico já estava vazio."));
    }

    @Test
    void deveContinuarFluxoAposEntradaInvalidaNoMenu() {
        String entrada = "abc\n1\n4\n6\n0\n";

        ByteArrayInputStream entradaSimulada = new ByteArrayInputStream(entrada.getBytes());
        ByteArrayOutputStream saidaCapturada = new ByteArrayOutputStream();

        PrintStream saidaOriginal = System.out;
        java.io.InputStream entradaOriginal = System.in;

        System.setIn(entradaSimulada);
        System.setOut(new PrintStream(saidaCapturada));

        try {
            AplicacaoCalculadora aplicacao = new AplicacaoCalculadora();
            aplicacao.iniciar();
        } finally {
            System.setIn(entradaOriginal);
            System.setOut(saidaOriginal);
        }

        String textoSaida = saidaCapturada.toString();

        assertTrue(textoSaida.contains("Erro: entrada inválida. Digite apenas números inteiros."));
        assertTrue(textoSaida.contains("✓ Operação realizada com sucesso!"));
        assertTrue(textoSaida.contains("Resultado: 10.0"));
    }
}