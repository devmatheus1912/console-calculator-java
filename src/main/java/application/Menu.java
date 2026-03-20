package application;

public class Menu {

    private static final int OPCAO_MINIMA = 0;
    private static final int OPCAO_MAXIMA = 10;
    private static final String SEPARADOR = "================================";

    private final IO io;

    public Menu(IO io) {
        this.io = io;
    }

    public int exibirMenu() {
        while (true) {
            imprimirMenu();

            try {
                int opcao = Integer.parseInt(io.readLine());

                if (opcaoValida(opcao)) {
                    return opcao;
                }

                io.println("Opção inválida. Escolha um número entre 0 e 10.");
                io.println("------------------------------");

            } catch (NumberFormatException e) {
                io.println("Erro: entrada inválida. Digite apenas números inteiros.");
            }
        }
    }

    private void imprimirMenu() {
        io.println(SEPARADOR);
        io.println("   CONSOLE CALCULATOR v3.0");
        io.println(SEPARADOR);
        io.println("1 - Somar");
        io.println("2 - Subtrair");
        io.println("3 - Multiplicar");
        io.println("4 - Dividir");
        io.println("5 - Potência (a^b)");
        io.println("6 - Raiz Quadrada");
        io.println("7 - Logaritmo (log a na base b)");
        io.println("8 - Seno (em radianos)");
        io.println("9 - Ver histórico");
        io.println("10 - Limpar histórico");
        io.println("0 - Sair");
        io.println("");
        io.print("Escolha uma opção: ");
    }

    private boolean opcaoValida(int opcao) {
        return opcao >= OPCAO_MINIMA && opcao <= OPCAO_MAXIMA;
    }
}