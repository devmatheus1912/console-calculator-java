package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraTest {

    @Test
    void deveExecutarOperacaoBinariaERegistrarNoHistorico() {
        Calculadora calculadora = new Calculadora();
        double resultado = calculadora.executarOperacao(new Somar(), 5, 3);
        assertEquals(8.0, resultado);
        assertEquals(1, calculadora.getTotalOperacoes());
    }

    @Test
    void deveExecutarOperacaoUnariaERegistrarNoHistorico() {
        Calculadora calculadora = new Calculadora();
        double resultado = calculadora.executarOperacao(new RaizQuadrada(), 16);
        assertEquals(4.0, resultado);
        assertEquals(1, calculadora.getTotalOperacoes());
    }

    @Test
    void deveRegistrarDuasOperacoesNoHistorico() {
        Calculadora calculadora = new Calculadora();
        calculadora.executarOperacao(new Somar(), 2, 2);
        calculadora.executarOperacao(new Subtrair(), 10, 3);
        assertEquals(2, calculadora.getTotalOperacoes());
    }

    @Test
    void deveLimparHistorico() {
        Calculadora calculadora = new Calculadora();
        calculadora.executarOperacao(new Somar(), 2, 2);
        calculadora.executarOperacao(new Multiplicar(), 3, 4);
        assertEquals(2, calculadora.getTotalOperacoes());
        calculadora.limparHistorico();
        assertEquals(0, calculadora.getTotalOperacoes());
    }
}