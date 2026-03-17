package entities;

public class Calculadora {

    private Historico historico;

    public Calculadora() {
        this.historico = new Historico();
    }

    public double executar(Operacao op, double a, double b) {
        double resultado = op.calcular(a, b);
        historico.adicionarRegistro(op.formatar(a, b, resultado));
        return resultado;
    }

    public void mostrarHistorico() {
        historico.mostrarRegistros();
    }

    public void limparHistorico() {
        historico.limparRegistros();
    }

    // Método para saber total de operações
    public int getTotalOperacoes() {
        return historico.getTotalOperacoes();
    }
}
