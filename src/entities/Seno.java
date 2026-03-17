package entities;

public class Seno implements Operacao {
    @Override
    public double calcular(double a, double b) {
        if (Math.abs(a) > 10000) {
            throw new ArithmeticException("Ângulo muito grande; use valores menores para precisão");
        }
        return Math.sin(a);
    }
    @Override
    public String getSimbolo() {
        return "sen";
    }

    @Override
    public String formatar(double a, double b, double resultado) {
        return "sin(" + a + ") = " + resultado;
    }
}


