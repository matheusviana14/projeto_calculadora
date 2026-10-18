package calculadora;

/**
 * Classe de testes da {@link Calculadora}.
 *
 * <p>Cada teste mostra as entradas utilizadas, o resultado esperado e o resultado obtido.</p>
 *
 * @author Gabriel Matheus Ferreira Viana
 * @version 1.0
 */
public class TesteCalculadora {

    // Instância única da calculadora, reutilizada por todos os testes
    private static final Calculadora CALC = new Calculadora();

    /**
     * Testa uma operação que deve retornar um valor.
     *
     * @param nome nome do teste
     * @param a primeiro operando
     * @param b segundo operando
     * @param operador operador da operação
     * @param esperado resultado esperado
     */
    private static void testarResultado(String nome, int a, int b, String operador, int esperado) {
        System.out.println("Teste: " + nome);
        System.out.println("Entradas: a=" + a + ", b=" + b + ", operador=\"" + operador + "\"");
        // Executa a operação e compara o resultado obtido com o esperado
        int obtido = CALC.calcular(a, b, operador);
        System.out.println("Esperado: " + esperado + " | Obtido: " + obtido
                + " -> " + (obtido == esperado ? "PASSOU" : "FALHOU"));
        System.out.println("----------------------------------------");
    }

    /**
     * Testa uma operação que deve lançar {@link IllegalArgumentException}.
     *
     * @param nome nome do teste
     * @param a primeiro operando
     * @param b segundo operando
     * @param operador operador da operação
     */
    private static void testarExcecao(String nome, int a, int b, String operador) {
        System.out.println("Teste: " + nome);
        System.out.println("Entradas: a=" + a + ", b=" + b + ", operador=\"" + operador + "\"");
        // O teste só passa se a exceção for lançada
        try {
            int obtido = CALC.calcular(a, b, operador);
            System.out.println("Esperado: exceção | Obtido: " + obtido + " -> FALHOU");
        } catch (IllegalArgumentException e) {
            System.out.println("Esperado: exceção | Obtido: \"" + e.getMessage() + "\" -> PASSOU");
        }
        System.out.println("----------------------------------------");
    }

    /**
     * Executa todos os testes.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        // Casos válidos: devem retornar o resultado correto
        testarResultado("Soma", 2, 3, "+", 5);
        testarResultado("Subtração", 10, 4, "-", 6);
        testarResultado("Multiplicação", 3, 5, "*", 15);
        testarResultado("Divisão", 8, 2, "/", 4);
        // Casos de erro: devem lançar IllegalArgumentException
        testarExcecao("Divisão por zero", 8, 0, "/");
        testarExcecao("Operação inválida", 5, 5, "x");
    }
}
