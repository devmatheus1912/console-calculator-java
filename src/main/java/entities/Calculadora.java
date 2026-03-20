package entities;

public class Calculadora {

    public double executarOperacao(OperacaoBinaria op, double a, double b) {
        return op.calcular(a, b);
    }

    public double executarOperacao(OperacaoUnaria op, double a) {
        return op.calcular(a);
    }
}