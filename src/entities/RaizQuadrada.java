package entities;

public class RaizQuadrada implements OperacaoUnaria{

    @Override
    public double calcular(double a) {
        if (a < 0) {
            throw new ArithmeticException("Não é possível calcular raiz de número negativo");
        }
        return Math.sqrt(a);
    }

    @Override
    public String getNome() {
        return "Raiz Quadrada";
    }

    @Override
    public String formatar(double a, double resultado) {
        return "√" + a + " = " + resultado;
    }
}