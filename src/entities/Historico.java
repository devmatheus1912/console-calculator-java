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
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("================================");
            System.out.println("   HISTÓRICO DE OPERAÇÕES");
            System.out.println("================================");

            // NOVIDADE: Mostrar com numeração
            for (int i = 0; i < registros.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + registros.get(i));
            }

            // NOVIDADE: Mostrar quantidade
            System.out.println("================================");
            System.out.println("Total: " + registros.size() + " operações");
            System.out.println("================================");
        }
    }

    public void limparRegistros() {
        registros.clear();
    }

    // Método para saber quantas operações tem.
    public int getTotalOperacoes() {
        return registros.size();
    }
}
