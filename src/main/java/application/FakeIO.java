package application;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FakeIO implements IO {

    private final Queue<String> entradas = new ArrayDeque<>();
    private final List<String> saidas = new ArrayList<>();

    public FakeIO(List<String> entradasIniciais) {
        this.entradas.addAll(entradasIniciais);
    }

    @Override
    public void println(String mensagem) {
        saidas.add(mensagem);
    }

    @Override
    public void print(String mensagem) {
        saidas.add(mensagem);
    }

    @Override
    public String readLine() {
        if (entradas.isEmpty()) {
            throw new IllegalStateException("Não há mais entradas simuladas.");
        }
        return entradas.poll();
    }

    public String getSaidaCompleta() {
        return String.join("\n", saidas);
    }

    public List<String> getSaidas() {
        return List.copyOf(saidas);
    }
}