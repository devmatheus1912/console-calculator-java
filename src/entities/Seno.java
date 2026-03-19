package entities;

public class Seno implements OperacaoUnaria {
    @Override
    public double calcular(double a) {
        if (Math.abs(a) > 10000) {
            throw new ArithmeticException("Ângulo muito grande; use valores menores para precisão");
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


