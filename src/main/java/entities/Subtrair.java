package entities;

//Classe responsável por realizar a operação de subtração
public class Subtrair implements OperacaoBinaria {

    @Override
    public double calcular(double a, double b) {
        return a - b;
    }

    @Override
    public String getNome() {
        return "Subtração";
    }
    @Override
    public String formatar (double a, double b, double resultado) {
        return a + " - " + b + " = " + resultado;
    }
}
