package repository;

import entities.RegistroOperacao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistoricoArquivoRepository implements HistoricoRepository {

    private final Path arquivo;

    public HistoricoArquivoRepository(String caminhoArquivo) {
        this.arquivo = Path.of(caminhoArquivo);
    }

    @Override
    public void salvar(RegistroOperacao registro) {
        try {
            String linha = toCsv(registro) + System.lineSeparator();
            Files.writeString(
                    arquivo,
                    linha,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar histórico em arquivo.", e);
        }
    }

    @Override
    public List<RegistroOperacao> listar() {
        try {
            if (!Files.exists(arquivo)) {
                return List.of();
            }

            List<String> linhas = Files.readAllLines(arquivo);
            List<RegistroOperacao> registros = new ArrayList<>();

            for (String linha : linhas) {
                if (linha == null || linha.isBlank()) {
                    continue;
                }
                registros.add(fromCsv(linha));
            }

            return registros;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler histórico do arquivo.", e);
        }
    }

    @Override
    public void limpar() {
        try {
            Files.deleteIfExists(arquivo);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao limpar histórico do arquivo.", e);
        }
    }

    private String toCsv(RegistroOperacao registro) {
        return escape(registro.nomeOperacao()) + ";" +
                escape(registro.expressao()) + ";" +
                registro.resultado() + ";" +
                registro.dataHora();
    }

    private RegistroOperacao fromCsv(String linha) {
        String[] partes = linha.split(";", 4);

        return new RegistroOperacao(
                unescape(partes[0]),
                unescape(partes[1]),
                Double.parseDouble(partes[2]),
                LocalDateTime.parse(partes[3])
        );
    }

    private String escape(String valor) {
        return valor.replace("\\", "\\\\").replace(";", "\\;");
    }

    private String unescape(String valor) {
        return valor.replace("\\;", ";").replace("\\\\", "\\");
    }
}