package entities;

//Classe responsável por realizar a operação de soma
public class Somar implements OperacaoBinaria {

    @Override
    public double calcular(double a, double b) {
        return a + b;
    }

    @Override
    public String getNome() {
        return "Soma";
    }
    @Override
    public String formatar (double a, double b, double resultado) {
        return a + " + " + b + " = " + resultado;
    }
}
