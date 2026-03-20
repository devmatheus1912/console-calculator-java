package service;

import entities.TipoOperacao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroOperacoesTest {

    @Test
    void deveEncontrarOperacaoBinariaValida() {
        RegistroOperacoes registro = new RegistroOperacoes();

        assertTrue(registro.buscarBinaria(TipoOperacao.SOMA).isPresent());
        assertTrue(registro.buscarBinaria(TipoOperacao.DIVISAO).isPresent());
        assertTrue(registro.buscarBinaria(TipoOperacao.LOGARITMO).isPresent());
    }

    @Test
    void deveRetornarVazioQuandoTipoNaoForBinario() {
        RegistroOperacoes registro = new RegistroOperacoes();

        assertTrue(registro.buscarBinaria(TipoOperacao.SENO).isEmpty());
        assertTrue(registro.buscarBinaria(TipoOperacao.RAIZ_QUADRADA).isEmpty());
    }

    @Test
    void deveEncontrarOperacaoUnariaValida() {
        RegistroOperacoes registro = new RegistroOperacoes();

        assertTrue(registro.buscarUnaria(TipoOperacao.SENO).isPresent());
        assertTrue(registro.buscarUnaria(TipoOperacao.RAIZ_QUADRADA).isPresent());
    }

    @Test
    void deveRetornarVazioQuandoTipoNaoForUnario() {
        RegistroOperacoes registro = new RegistroOperacoes();

        assertTrue(registro.buscarUnaria(TipoOperacao.SOMA).isEmpty());
        assertTrue(registro.buscarUnaria(TipoOperacao.DIVISAO).isEmpty());
    }
}