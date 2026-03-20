package repository;

import entities.RegistroOperacao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HistoricoArquivoRepositoryTest {

    @TempDir
    Path tempDir;

    @Test
    void deveSalvarRegistroEmArquivo() throws Exception {
        Path arquivo = tempDir.resolve("historico.txt");
        HistoricoArquivoRepository repository = new HistoricoArquivoRepository(arquivo.toString());

        repository.salvar(new RegistroOperacao("Soma", "1 + 1 = 2", 2.0));

        assertTrue(Files.exists(arquivo));
        String conteudo = Files.readString(arquivo);
        assertTrue(conteudo.contains("Soma"));
    }

    @Test
    void deveListarVazioQuandoArquivoNaoExiste() {
        Path arquivo = tempDir.resolve("nao-existe.txt");
        HistoricoArquivoRepository repository = new HistoricoArquivoRepository(arquivo.toString());

        List<RegistroOperacao> lista = repository.listar();

        assertTrue(lista.isEmpty());
    }

    @Test
    void deveListarRegistrosQuandoArquivoTemLinhas() {
        Path arquivo = tempDir.resolve("historico.txt");
        HistoricoArquivoRepository repository = new HistoricoArquivoRepository(arquivo.toString());

        repository.salvar(new RegistroOperacao("Soma", "1 + 1 = 2", 2.0));
        repository.salvar(new RegistroOperacao("Subtração", "3 - 1 = 2", 2.0));

        List<RegistroOperacao> lista = repository.listar();

        assertNotNull(lista);
        assertEquals(2, lista.size());
        assertEquals("Soma", lista.get(0).nomeOperacao());
        assertEquals("Subtração", lista.get(1).nomeOperacao());
    }

    @Test
    void deveLimparArquivo() throws Exception {
        Path arquivo = tempDir.resolve("historico.txt");
        HistoricoArquivoRepository repository = new HistoricoArquivoRepository(arquivo.toString());

        repository.salvar(new RegistroOperacao("Soma", "1 + 1 = 2", 2.0));
        assertTrue(Files.exists(arquivo));

        repository.limpar();

        assertFalse(Files.exists(arquivo));
    }

    @Test
    void deveLancarErroAoSalvarQuandoCaminhoEhDiretorio() {
        HistoricoArquivoRepository repository = new HistoricoArquivoRepository(tempDir.toString());

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> repository.salvar(new RegistroOperacao("Soma", "1 + 1 = 2", 2.0)));

        assertEquals("Erro ao salvar histórico em arquivo.", ex.getMessage());
    }

    @Test
    void deveLancarErroAoListarQuandoCaminhoEhDiretorio() {
        HistoricoArquivoRepository repository = new HistoricoArquivoRepository(tempDir.toString());

        RuntimeException ex = assertThrows(RuntimeException.class, repository::listar);

        assertEquals("Erro ao ler histórico do arquivo.", ex.getMessage());
    }

    @Test
    void deveLancarErroAoLimparQuandoCaminhoEhDiretorioNaoVazio() throws Exception {
        Files.writeString(tempDir.resolve("filho.txt"), "conteudo");
        HistoricoArquivoRepository repository = new HistoricoArquivoRepository(tempDir.toString());

        RuntimeException ex = assertThrows(RuntimeException.class, repository::limpar);

        assertEquals("Erro ao limpar histórico do arquivo.", ex.getMessage());
    }
}