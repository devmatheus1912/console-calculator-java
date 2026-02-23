package entities;


public class Calculadora{

    private Historico historico;

    public Calculadora() {
        this.historico = new Historico();
    }

    public double executar (Operacao op, double a, double b){
        double resultado = op.calcular(a,b);
        String simbolo = op.getSimbolo();
        String registro = a + " " + simbolo + " " + b + " = " + resultado;
        historico.adicionarRegistro(registro);
        return resultado;
    }
    public void mostraRegistro (){
        historico.mostrarRegistros();
    }
    public void limparRegistro(){
       historico.limparRegistros();
    }
}



