package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TipoOperacaoTest {

    @Test
    void deveConterTodosOsTiposEsperados() {
        TipoOperacao[] valores = TipoOperacao.values();

        assertEquals(8, valores.length);
        assertEquals(TipoOperacao.SOMA, valores[0]);
        assertEquals(TipoOperacao.SENO, valores[7]);
    }

    @Test
    void deveResolverTipoPorNome() {
        assertEquals(TipoOperacao.SOMA, TipoOperacao.valueOf("SOMA"));
        assertEquals(TipoOperacao.RAIZ_QUADRADA, TipoOperacao.valueOf("RAIZ_QUADRADA"));
    }
}