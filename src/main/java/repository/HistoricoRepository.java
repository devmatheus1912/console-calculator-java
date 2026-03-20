package repository;

import entities.RegistroOperacao;
import java.util.List;

public interface HistoricoRepository {
    void salvar(RegistroOperacao registro);
    List<RegistroOperacao> listar();
    void limpar();
}