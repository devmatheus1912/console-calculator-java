package repository;

import entities.RegistroOperacao;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HistoricoEmMemoriaRepositoryTest {

    @Test
    void deveSalvarRegistro() {
        HistoricoEmMemoriaRepository repository = new HistoricoEmMemoriaRepository();

        repository.salvar(new RegistroOperacao("Soma", "1 + 1 = 2", 2.0));

        assertEquals(1, repository.listar().size());
    }

    @Test
    void deveListarVazioInicialmente() {
        HistoricoEmMemoriaRepository repository = new HistoricoEmMemoriaRepository();

        List<RegistroOperacao> lista = repository.listar();

        assertTrue(lista.isEmpty());
    }

    @Test
    void listaDeveSerImutavel() {
        HistoricoEmMemoriaRepository repository = new HistoricoEmMemoriaRepository();
        repository.salvar(new RegistroOperacao("Soma", "1 + 1 = 2", 2.0));

        List<RegistroOperacao> lista = repository.listar();

        assertThrows(UnsupportedOperationException.class,
                () -> lista.add(new RegistroOperacao("Sub", "2 - 1 = 1", 1.0)));
    }

    @Test
    void deveLimparRegistros() {
        HistoricoEmMemoriaRepository repository = new HistoricoEmMemoriaRepository();
        repository.salvar(new RegistroOperacao("Soma", "1 + 1 = 2", 2.0));
        repository.salvar(new RegistroOperacao("Sub", "2 - 1 = 1", 1.0));

        repository.limpar();

        assertTrue(repository.listar().isEmpty());
    }
}