package entities;

import exceptions.RegraDeNegocioException;

public class Divisao implements OperacaoBinaria {

    @Override
    public double calcular(double a, double b) {
        if (b == 0) {
            throw new RegraDeNegocioException("Não é possível dividir por zero.");
        }
        return a / b;
    }

    @Override
    public String getNome() {
        return "Divisão";
    }

    @Override
    public String formatar(double a, double b, double resultado) {
        return a + " / " + b + " = " + resultado;
    }
}