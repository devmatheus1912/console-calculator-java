package application;

import entities.Calculadora;
import entities.Divisao;
import entities.Logaritmo;
import entities.Multiplicar;
import entities.OperacaoBinaria;
import entities.OperacaoUnaria;
import entities.Potencia;
import entities.RaizQuadrada;
import entities.Seno;
import entities.Somar;
import entities.Subtrair;
import org.junit.jupiter.api.Test;
import repository.HistoricoEmMemoriaRepository;
import service.CalculadoraService;
import validation.ValidarNumero;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AplicacaoCalculadoraTest {

    @Test
    void deveExecutarSomaComFakeIO() {
        FakeIO io = new FakeIO(List.of("1", "10", "5", "0"));

        CalculadoraService service = new CalculadoraService(
                new Calculadora(),
                new ValidarNumero(),
                new HistoricoEmMemoriaRepository()
        );

        Menu menu = new Menu(io);

        Map<Integer, OperacaoBinaria> operacoesBinarias = new HashMap<>();
        operacoesBinarias.put(1, new Somar());
        operacoesBinarias.put(2, new Subtrair());
        operacoesBinarias.put(3, new Multiplicar());
        operacoesBinarias.put(4, new Divisao());
        operacoesBinarias.put(5, new Potencia());
        operacoesBinarias.put(7, new Logaritmo());

        Map<Integer, OperacaoUnaria> operacoesUnarias = new HashMap<>();
        operacoesUnarias.put(6, new RaizQuadrada());
        operacoesUnarias.put(8, new Seno());

        AplicacaoCalculadora app = new AplicacaoCalculadora(
                io,
                menu,
                service,
                operacoesBinarias,
                operacoesUnarias
        );

        app.executar();

        String saida = io.getSaidaCompleta();

        assertTrue(saida.contains("Operação: Soma"));
        assertTrue(saida.contains("Resultado: 15.0"));
        assertTrue(saida.contains("Encerrando calculadora..."));
    }
}