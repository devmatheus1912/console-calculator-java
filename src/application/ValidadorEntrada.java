package application;

public class ValidadorEntrada {

    private static final double VALOR_MAXIMO = 1000000;
    private static final double VALOR_MINIMO = -1000000;

    public static boolean validarIntervalo(double numero) {
        if (numero > VALOR_MAXIMO || numero < VALOR_MINIMO) {
            System.out.println("Erro: O número deve estar entre " + VALOR_MINIMO + " e " + VALOR_MAXIMO);
            return false;
        }
        return true;
    }
    // Pede número ao usuário com validação completa

    public static double pedirNumeroValido(java.util.Scanner sc, String mensagem) {
        while (true) {
            try {
                System.out.println(mensagem);
                double numero = sc.nextDouble();
                if (validarIntervalo(numero)) {     // Se válido, retorna.
                    return numero;
                }
                // Se inválido, continua o loop.
            } catch (java.util.InputMismatchException e) {
                System.out.println("Erro: Digite um número válido!");
                sc.nextLine(); // Limpa o buffer
            }
        }
    }
}
