package entities;

import java.time.LocalDateTime;

public record RegistroOperacao(
        String nomeOperacao,
        String expressao,
        double resultado,
        LocalDateTime dataHora
) {
    public RegistroOperacao(String nomeOperacao, String expressao, double resultado) {
        this(nomeOperacao, expressao, resultado, LocalDateTime.now());
    }
}