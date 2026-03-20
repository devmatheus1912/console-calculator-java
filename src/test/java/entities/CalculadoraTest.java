package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraTest {

    @Test
    void deveExecutarOperacaoBinaria() {
        Calculadora calculadora = new Calculadora();

        double resultado = calculadora.executarOperacao(new Somar(), 5, 3);

        assertEquals(8.0, resultado);
    }

    @Test
    void deveExecutarOperacaoUnaria() {
        Calculadora calculadora = new Calculadora();

        double resultado = calculadora.executarOperacao(new RaizQuadrada(), 16);

        assertEquals(4.0, resultado);
    }

    @Test
    void deveExecutarMultiplasOperacoesIndependentemente() {
        Calculadora calculadora = new Calculadora();

        double soma = calculadora.executarOperacao(new Somar(), 2, 2);
        double subtracao = calculadora.executarOperacao(new Subtrair(), 10, 3);
        double multiplicacao = calculadora.executarOperacao(new Multiplicar(), 3, 4);

        assertEquals(4.0, soma);
        assertEquals(7.0, subtracao);
        assertEquals(12.0, multiplicacao);
    }
}