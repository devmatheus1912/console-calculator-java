package entities;

import java.util.ArrayList;
import java.util.List;

public class Historico {

    private static final String CABECALHO = "================================";
    private final List<RegistroOperacao> registros = new ArrayList<>();

    public void adicionarRegistro(RegistroOperacao registro) {
        registros.add(registro);
    }

    public void mostrarRegistros() {
        if (registros.isEmpty()) {
            System.out.println("Nenhuma operação foi realizada ainda.");
            return;
        }

        System.out.println(CABECALHO);
        System.out.println("   HISTÓRICO DE OPERAÇÕES");
        System.out.println(CABECALHO);

        for (int i = 0; i < registros.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + registros.get(i));
        }

        System.out.println(CABECALHO);
        System.out.println("Total: " + registros.size() + " operação(ões)");
        System.out.println(CABECALHO);
    }

    public void limparRegistros() {
        registros.clear();
    }

    public int getTotalOperacoes() {
        return registros.size();
    }
}