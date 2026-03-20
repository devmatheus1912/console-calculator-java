package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroOperacao {
    private final String nomeOperacao;
    private final String expressao;
    private final double resultado;
    private final LocalDateTime dataHora;

    public RegistroOperacao(String nomeOperacao, String expressao, double resultado) {
        this.nomeOperacao = nomeOperacao;
        this.expressao = expressao;
        this.resultado = resultado;
        this.dataHora = LocalDateTime.now();
    }

    public String getNomeOperacao() {
        return nomeOperacao;
    }

    public String getExpressao() {
        return expressao;
    }

    public double getResultado() {
        return resultado;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    private static final DateTimeFormatter FORMATADOR =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Override
    public String toString() {
        return "[" + FORMATADOR.format(dataHora) + "] "
                + nomeOperacao + " -> "
                + expressao + " | Resultado: " + resultado;
    }
}

