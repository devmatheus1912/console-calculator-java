package entities;

import java.time.LocalDateTime;

public record ResultadoOperacao(
        String nomeOperacao,
        String expressao,
        double resultado,
        LocalDateTime dataHora
) {
}