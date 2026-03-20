package service;

import entities.*;

import java.util.Map;
import java.util.Optional;

public class RegistroOperacoes {

    private final Map<TipoOperacao, OperacaoBinaria> operacoesBinarias;
    private final Map<TipoOperacao, OperacaoUnaria> operacoesUnarias;

    public RegistroOperacoes() {
        this.operacoesBinarias = Map.of(
                TipoOperacao.SOMA, new Somar(),
                TipoOperacao.SUBTRACAO, new Subtrair(),
                TipoOperacao.MULTIPLICACAO, new Multiplicar(),
                TipoOperacao.DIVISAO, new Divisao(),
                TipoOperacao.POTENCIA, new Potencia(),
                TipoOperacao.LOGARITMO, new Logaritmo()
        );

        this.operacoesUnarias = Map.of(
                TipoOperacao.RAIZ_QUADRADA, new RaizQuadrada(),
                TipoOperacao.SENO, new Seno()
        );
    }

    public Optional<OperacaoBinaria> buscarBinaria(TipoOperacao tipo) {
        return Optional.ofNullable(operacoesBinarias.get(tipo));
    }

    public Optional<OperacaoUnaria> buscarUnaria(TipoOperacao tipo) {
        return Optional.ofNullable(operacoesUnarias.get(tipo));
    }
}