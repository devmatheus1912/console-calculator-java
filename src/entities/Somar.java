package entities;

//Classe responsável por realizar a operação de soma
public class Somar implements Operacao {

    @Override
    public double calcular(double a, double b) {
        return a + b;
    }

    @Override
    public String getSimbolo() {
        return "+";
    }
}
