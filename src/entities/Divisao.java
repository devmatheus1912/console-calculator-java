package entities;

public class Divisao implements Operacao {

    @Override
    public double calcular(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Não é possível dividir por zero");
        }
        return a / b;
    }
    @Override
    public String getSimbolo() {
        return "/";
    }
    @Override
    public String formatar (double a, double b, double resultado) {
        return a + " / " + b + " - " + resultado;
    }
}
