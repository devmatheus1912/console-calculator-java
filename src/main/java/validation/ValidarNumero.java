package validation;

import exceptions.RegraDeNegocioException;

public class ValidarNumero {

    private static final double MIN = -1_000_000;
    private static final double MAX = 1_000_000;

    public void validar(double valor) {
        if (Double.isNaN(valor) || Double.isInfinite(valor)) {
            throw new RegraDeNegocioException("Valor numérico inválido.");
        }

        if (valor < MIN || valor > MAX) {
            throw new RegraDeNegocioException(
                    "Valor deve estar entre " + MIN + " e " + MAX + "."
            );
        }
    }
}