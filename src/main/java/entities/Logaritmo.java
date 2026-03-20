package entities;

public class Logaritmo implements OperacaoBinaria {
    @Override
    public double calcular(double a, double b) {
        if (a <= 0) {
            throw new ArithmeticException("Logaritmos só existem para números positivos");
        }
        if (b <= 0 || b == 1) {
            throw new ArithmeticException("A base do logaritmo deve ser positiva e diferente de 1");
        }
        return Math.log(a) / Math.log(b);
    }

    @Override
    public String getNome() {
        return "logaritmo";
    }

    @Override
    public String formatar(double a, double b, double resultado) {
        return "log " + a + " na base " + b + " = " + resultado;
    }
}