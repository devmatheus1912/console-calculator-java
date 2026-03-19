package entities;

public class Calculadora {

    private final Historico historico;

    public Calculadora() {
        this.historico = new Historico();
    }

    public double executarOperacao (OperacaoBinaria op, double a, double b) {
        double resultado = op.calcular(a, b);
        historico.adicionarRegistro(op.formatar(a, b, resultado));
        return resultado;
    }
    public double executarOperacao (OperacaoUnaria op, double a) {
        double resultado = op.calcular(a);
        historico.adicionarRegistro(op.formatar(a, resultado));
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
