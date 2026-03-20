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
import repository.HistoricoEmMemoriaRepository;
import repository.HistoricoRepository;
import service.CalculadoraService;
import validation.ValidarNumero;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IO io = new ConsoleIO(scanner);

        Calculadora calculadora = new Calculadora();
        ValidarNumero validadorNumero = new ValidarNumero();
        HistoricoRepository historicoRepository = new HistoricoEmMemoriaRepository();

        CalculadoraService service = new CalculadoraService(
                calculadora,
                validadorNumero,
                historicoRepository
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
    }
}