package entities;

import exceptions.RegraDeNegocioException;

public class Seno implements OperacaoUnaria {

    @Override
    public double calcular(double a) {
        if (Math.abs(a) > 10000) {
            throw new RegraDeNegocioException("Ângulo muito grande; use valores menores para melhor precisão.");
        }
        return Math.sin(a);
    }

    @Override
    public String getNome() {
        return "Seno";
    }

    @Override
    public String formatar(double a, double resultado) {
        return "sen(" + a + ") = " + resultado;
    }
}