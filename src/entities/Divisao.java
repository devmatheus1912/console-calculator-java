package entities;

public class Divisao implements Operacao {

    @Override
    public double calcular(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Não é possível dividir por zero");
        }
        return a / b;
    }
}
