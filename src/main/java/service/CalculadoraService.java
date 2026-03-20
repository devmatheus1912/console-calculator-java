package service;

import entities.Calculadora;
import entities.OperacaoBinaria;
import entities.OperacaoUnaria;
import entities.RegistroOperacao;
import entities.ResultadoOperacao;
import exceptions.RegraDeNegocioException;
import repository.HistoricoRepository;
import validation.ValidarNumero;

import java.time.LocalDateTime;
import java.util.List;

public class CalculadoraService {

    private final Calculadora calculadora;
    private final ValidarNumero validadorNumero;
    private final HistoricoRepository historicoRepository;

    public CalculadoraService(
            Calculadora calculadora,
            ValidarNumero validadorNumero,
            HistoricoRepository historicoRepository
    ) {
        this.calculadora = calculadora;
        this.validadorNumero = validadorNumero;
        this.historicoRepository = historicoRepository;
    }

    public ResultadoOperacao executarBinaria(OperacaoBinaria op, double a, double b) {
        if (op == null) {
            throw new RegraDeNegocioException("Operação binária inválida.");
        }

        validadorNumero.validar(a);
        validadorNumero.validar(b);

        double resultado = calculadora.executarOperacao(op, a, b);
        ResultadoOperacao resposta = new ResultadoOperacao(
                op.getNome(),
                op.formatar(a, b, resultado),
                resultado,
                LocalDateTime.now()
        );

        historicoRepository.salvar(toRegistro(resposta));
        return resposta;
    }

    public ResultadoOperacao executarUnaria(OperacaoUnaria op, double a) {
        if (op == null) {
            throw new RegraDeNegocioException("Operação unária inválida.");
        }

        validadorNumero.validar(a);

        double resultado = calculadora.executarOperacao(op, a);
        ResultadoOperacao resposta = new ResultadoOperacao(
                op.getNome(),
                op.formatar(a, resultado),
                resultado,
                LocalDateTime.now()
        );

        historicoRepository.salvar(toRegistro(resposta));
        return resposta;
    }

    public List<RegistroOperacao> listarHistorico() {
        return historicoRepository.listar();
    }

    public void limparHistorico() {
        historicoRepository.limpar();
    }

    public int totalOperacoes() {
        return historicoRepository.listar().size();
    }

    private RegistroOperacao toRegistro(ResultadoOperacao resultado) {
        return new RegistroOperacao(
                resultado.nomeOperacao(),
                resultado.expressao(),
                resultado.resultado(),
                resultado.dataHora()
        );
    }
}