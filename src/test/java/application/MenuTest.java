package application;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MenuTest {

    @Test
    void deveRetornarOpcaoValidaQuandoUsuarioDigitarNumeroPermitido() {
        FakeIO io = new FakeIO(List.of("1"));
        Menu menu = new Menu(io);

        int opcao = menu.exibirMenu();

        assertEquals(1, opcao);
    }

    @Test
    void deveAceitarOpcaoZeroParaSair() {
        FakeIO io = new FakeIO(List.of("0"));
        Menu menu = new Menu(io);

        int opcao = menu.exibirMenu();

        assertEquals(0, opcao);
    }

    @Test
    void deveRejeitarOpcaoForaDoIntervaloEAceitarOpcaoValidaDepois() {
        FakeIO io = new FakeIO(List.of("99", "2"));
        Menu menu = new Menu(io);

        int opcao = menu.exibirMenu();
        String textoSaida = io.getSaidaCompleta();

        assertEquals(2, opcao);
        assertTrue(textoSaida.contains("Opção inválida. Escolha um número entre 0 e 10."));
    }

    @Test
    void deveRejeitarEntradaNaoNumericaEAceitarOpcaoValidaDepois() {
        FakeIO io = new FakeIO(List.of("abc", "3"));
        Menu menu = new Menu(io);

        int opcao = menu.exibirMenu();
        String textoSaida = io.getSaidaCompleta();

        assertEquals(3, opcao);
        assertTrue(textoSaida.contains("Erro: entrada inválida. Digite apenas números inteiros."));
    }

    @Test
    void deveExibirTituloDoMenu() {
        FakeIO io = new FakeIO(List.of("0"));
        Menu menu = new Menu(io);

        menu.exibirMenu();

        String textoSaida = io.getSaidaCompleta();

        assertTrue(textoSaida.contains("CONSOLE CALCULATOR v3.0"));
        assertTrue(textoSaida.contains("1 - Somar"));
        assertTrue(textoSaida.contains("0 - Sair"));
        assertTrue(textoSaida.contains("Escolha uma opção: "));
    }
}