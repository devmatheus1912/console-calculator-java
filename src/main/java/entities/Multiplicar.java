package entities;

public class Multiplicar implements OperacaoBinaria {

    @Override
    public double calcular(double a, double b) {
        return a * b;
    }

    @Override
    public String getNome() {
        return "Multiplicação";
    }
    @Override
    public String formatar (double a, double b, double resultado) {
        return a + " * " + b + " = " + resultado;
    }
}
