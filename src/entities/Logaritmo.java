package entities;

public class Logaritmo implements Operacao {
    @Override
    public double calcular(double a, double b) {
        if (a <= 0) {
            throw new ArithmeticException("Logaritmos só para números positivos");
        }
        return Math.log(a) / Math.log(b); // Logaritmo de 'a' na base 'b'
    }

    @Override
    public String getSimbolo() {
        return "log";
    }

    @Override
    public String formatar(double a, double b, double resultado) {
        return "log " + a + " na base " + b + " = " + resultado;
    }
}