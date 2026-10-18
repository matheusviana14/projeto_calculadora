package calculadora;

public class TesteCalculadora {

    private static void testar(String nome, int a, int b, String op, int esperado) {
        Calculadora calc = new Calculadora();
        System.out.println("Teste: " + nome);
        System.out.println("Entradas: a=" + a + ", b=" + b + ", op=\"" + op + "\"");
        int obtido = calc.calc(a, b, op);
        System.out.println("Esperado: " + esperado + " | Obtido: " + obtido
                + " -> " + (obtido == esperado ? "PASSOU" : "FALHOU"));
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        testar("Soma", 2, 3, "+", 5);
        testar("Subtracao", 10, 4, "-", 6);
        testar("Multiplicacao", 3, 5, "*", 15);
        testar("Divisao", 8, 2, "/", 4);
        testar("Divisao por zero", 8, 0, "/", 0);
        testar("Operacao invalida", 5, 5, "x", 0);
    }
}
