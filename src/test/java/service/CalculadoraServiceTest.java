package service;

import entities.Calculadora;
import entities.Logaritmo;
import entities.RaizQuadrada;
import entities.RegistroOperacao;
import entities.ResultadoOperacao;
import entities.Somar;
import exceptions.RegraDeNegocioException;
import org.junit.jupiter.api.Test;
import repository.HistoricoRepository;
import validation.ValidarNumero;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraServiceTest {

    @Test
    void deveExecutarOperacaoBinariaESalvarNoHistorico() {
        HistoricoRepositoryFake repository = new HistoricoRepositoryFake();
        CalculadoraService service = new CalculadoraService(new Calculadora(), new ValidarNumero(), repository);

        ResultadoOperacao resultado = service.executarBinaria(new Somar(), 10, 5);

        assertEquals("Soma", resultado.nomeOperacao());
        assertEquals("10.0 + 5.0 = 15.0", resultado.expressao());
        assertEquals(15.0, resultado.resultado());
        assertNotNull(resultado.dataHora());
        assertEquals(1, repository.listar().size());
    }

    @Test
    void deveExecutarOperacaoUnariaESalvarNoHistorico() {
        HistoricoRepositoryFake repository = new HistoricoRepositoryFake();
        CalculadoraService service = new CalculadoraService(new Calculadora(), new ValidarNumero(), repository);

        ResultadoOperacao resultado = service.executarUnaria(new RaizQuadrada(), 9);

        assertEquals("Raiz Quadrada", resultado.nomeOperacao());
        assertEquals("√9.0 = 3.0", resultado.expressao());
        assertEquals(3.0, resultado.resultado());
        assertNotNull(resultado.dataHora());
        assertEquals(1, repository.listar().size());
    }

    @Test
    void deveLancarErroQuandoOperacaoBinariaForNula() {
        HistoricoRepositoryFake repository = new HistoricoRepositoryFake();
        CalculadoraService service = new CalculadoraService(new Calculadora(), new ValidarNumero(), repository);

        RegraDeNegocioException ex = assertThrows(RegraDeNegocioException.class,
                () -> service.executarBinaria(null, 1, 2));

        assertEquals("Operação binária inválida.", ex.getMessage());
        assertTrue(repository.listar().isEmpty());
    }

    @Test
    void deveLancarErroQuandoOperacaoUnariaForNula() {
        HistoricoRepositoryFake repository = new HistoricoRepositoryFake();
        CalculadoraService service = new CalculadoraService(new Calculadora(), new ValidarNumero(), repository);

        RegraDeNegocioException ex = assertThrows(RegraDeNegocioException.class,
                () -> service.executarUnaria(null, 9));

        assertEquals("Operação unária inválida.", ex.getMessage());
        assertTrue(repository.listar().isEmpty());
    }

    @Test
    void deveLancarErroQuandoPrimeiroNumeroBinarioEstiverForaDoIntervalo() {
        HistoricoRepositoryFake repository = new HistoricoRepositoryFake();
        CalculadoraService service = new CalculadoraService(new Calculadora(), new ValidarNumero(), repository);

        RegraDeNegocioException ex = assertThrows(RegraDeNegocioException.class,
                () -> service.executarBinaria(new Somar(), 1_000_001, 1));

        assertEquals("Valor deve estar entre -1000000.0 e 1000000.0.", ex.getMessage());
        assertTrue(repository.listar().isEmpty());
    }

    @Test
    void deveLancarErroQuandoSegundoNumeroBinarioEstiverForaDoIntervalo() {
        HistoricoRepositoryFake repository = new HistoricoRepositoryFake();
        CalculadoraService service = new CalculadoraService(new Calculadora(), new ValidarNumero(), repository);

        RegraDeNegocioException ex = assertThrows(RegraDeNegocioException.class,
                () -> service.executarBinaria(new Somar(), 1, -1_000_001));

        assertEquals("Valor deve estar entre -1000000.0 e 1000000.0.", ex.getMessage());
        assertTrue(repository.listar().isEmpty());
    }

    @Test
    void deveLancarErroQuandoNumeroUnarioEstiverForaDoIntervalo() {
        HistoricoRepositoryFake repository = new HistoricoRepositoryFake();
        CalculadoraService service = new CalculadoraService(new Calculadora(), new ValidarNumero(), repository);

        RegraDeNegocioException ex = assertThrows(RegraDeNegocioException.class,
                () -> service.executarUnaria(new RaizQuadrada(), 1_000_001));

        assertEquals("Valor deve estar entre -1000000.0 e 1000000.0.", ex.getMessage());
        assertTrue(repository.listar().isEmpty());
    }

    @Test
    void devePropagarErroDaRegraDaOperacao() {
        HistoricoRepositoryFake repository = new HistoricoRepositoryFake();
        CalculadoraService service = new CalculadoraService(new Calculadora(), new ValidarNumero(), repository);

        RegraDeNegocioException ex = assertThrows(RegraDeNegocioException.class,
                () -> service.executarBinaria(new Logaritmo(), 0, 2));

        assertEquals("Logaritmo só existe para números positivos.", ex.getMessage());
        assertTrue(repository.listar().isEmpty());
    }

    static class HistoricoRepositoryFake implements HistoricoRepository {
        private final List<RegistroOperacao> registros = new ArrayList<>();

        @Override
        public void salvar(RegistroOperacao registro) {
            registros.add(registro);
        }

        @Override
        public List<RegistroOperacao> listar() {
            return registros;
        }

        @Override
        public void limpar() {
            registros.clear();
        }
    }
}