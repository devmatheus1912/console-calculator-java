package application;

import java.util.Scanner;

public class ConsoleIO implements IO {
    private final Scanner scanner;

    public ConsoleIO(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void println(String mensagem) {
        System.out.println(mensagem);
    }

    @Override
    public void print(String mensagem) {
        System.out.print(mensagem);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}