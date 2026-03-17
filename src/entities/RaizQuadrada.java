package entities;

public class RaizQuadrada implements Operacao {

    @Override
    public double calcular(double a, double b) {
        if (a < 0) {
            throw new ArithmeticException("Não é possível calcular raiz de número negativo");
        }
        return Math.sqrt(a);
    }

    @Override
    public String getSimbolo() {
        return "√";
    }

    @Override
    public String formatar(double a, double b, double resultado) {
        return "√" + a + " = " + resultado;
    }
}