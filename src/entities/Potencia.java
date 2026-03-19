package entities;

public class Potencia implements OperacaoBinaria {

    @Override
    public double calcular(double a, double b) {
        if (b < 0) {
            throw new ArithmeticException("Expoente não pode ser negativo");
        }
        return Math.pow(a, b);
    }
    @Override
    public String getNome() {
        return "Potência";
    }
    @Override
    public String formatar (double a, double b, double resultado) {
        return a + " ^ " + b + " = " + resultado;
    }
}
