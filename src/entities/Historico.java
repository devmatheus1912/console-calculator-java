package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por armazenar e gerenciar
 * o histórico das operações realizadas na calculadora.
 */

public class Historico {
    private List<String> registros = new ArrayList<>();

    public void adicionarRegistro(String registro) {
        registros.add(registro);
    }

    public void mostrarRegistros() {
        if (registros.isEmpty()) {
            IO.println("Nenhum registro encontrado");
        } else {
            for (String registro : registros) {
                IO.println(registro);
            }
        }
    }

    public void limparRegistros() {
        registros.clear();
    }

}

