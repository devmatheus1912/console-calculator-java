package entities;

public class Calculadora {

    private final Historico historico;

    public Calculadora() {
        this.historico = new Historico();
    }

    public double executarOperacao (OperacaoBinaria op, double a, double b) {
        double resultado = op.calcular(a, b);
        String expressao = op.formatar(a, b, resultado);

        RegistroOperacao registro = new RegistroOperacao(
                op.getNome(),
                expressao,
                resultado
        );
        historico.adicionarRegistro(registro);
        return resultado;
    }

    public double executarOperacao (OperacaoUnaria op, double a) {
        double resultado = op.calcular(a);
        String expressao = op.formatar(a, resultado);

        RegistroOperacao registro = new RegistroOperacao(
                op.getNome(),
                expressao,
                resultado
        );
        historico.adicionarRegistro(registro);
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
