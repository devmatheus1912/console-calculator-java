package repository;

import entities.RegistroOperacao;

import java.util.ArrayList;
import java.util.List;

public class HistoricoEmMemoriaRepository implements HistoricoRepository {

    private final List<RegistroOperacao> registros = new ArrayList<>();

    @Override
    public void salvar(RegistroOperacao registro) {
        registros.add(registro);
    }

    @Override
    public List<RegistroOperacao> listar() {
        return List.copyOf(registros);
    }

    @Override
    public void limpar() {
        registros.clear();
    }
}