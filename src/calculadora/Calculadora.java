package calculadora;

/**
 * <p><strong>Projeto Calculadora</strong></p>
 *
 * <p>Esta classe fornece operações matemáticas básicas como soma, subtração,
 * multiplicação e divisão, além de um método principal que seleciona a operação
 * desejada com base em um operador informado pelo usuário.</p>
 *
 * <p>Esse projeto é utilizado para demonstrar:</p>
 * <ul>
 *     <li>Testes funcionais e unitários</li>
 *     <li>Tratamento de erros com exceções</li>
 *     <li>Aplicação de refatoração em código Java</li>
 *     <li>Documentação com Javadoc</li>
 * </ul>
 *
 * <p>Após a refatoração, os métodos desta classe são <strong>métodos puros</strong>,
 * sem efeitos colaterais, permitindo maior legibilidade e facilitando testes unitários.</p>
 *
 * @author Gabriel Matheus Ferreira Viana
 * @version 1.0
 */
public class Calculadora {

    /**
     * Soma dois números inteiros.
     *
     * @param a primeiro operando
     * @param b segundo operando
     * @return o resultado da soma de {@code a} e {@code b}
     */
    public int somar(int a, int b) {
        // Soma direta dos dois operandos
        return a + b;
    }

    /**
     * Subtrai dois números inteiros.
     *
     * @param a primeiro operando (minuendo)
     * @param b segundo operando (subtraendo)
     * @return o resultado de {@code a} menos {@code b}
     */
    public int subtrair(int a, int b) {
        // Subtrai o segundo operando do primeiro
        return a - b;
    }

    /**
     * Multiplica dois números inteiros.
     *
     * @param a primeiro operando
     * @param b segundo operando
     * @return o produto de {@code a} por {@code b}
     */
    public int multiplicar(int a, int b) {
        // Multiplica os dois operandos
        return a * b;
    }

    /**
     * Divide dois números inteiros (divisão inteira).
     *
     * @param a dividendo
     * @param b divisor
     * @return o quociente de {@code a} por {@code b}
     * @throws IllegalArgumentException se {@code b} for zero
     */
    public int dividir(int a, int b) {
        // Valida o divisor antes de dividir, evitando ArithmeticException
        if (b == 0) {
            throw new IllegalArgumentException("Divisão por zero não é permitida.");
        }
        // Divisão inteira: a parte decimal do resultado é descartada
        return a / b;
    }

    /**
     * <p>Executa a operação matemática solicitada com base no operador informado.</p>
     *
     * <p>Operadores aceitos:</p>
     * <ul>
     *     <li>"+": Soma</li>
     *     <li>"-": Subtração</li>
     *     <li>"*": Multiplicação</li>
     *     <li>"/": Divisão</li>
     * </ul>
     *
     * <p>Qualquer operador inválido resulta em exceção.</p>
     *
     * @param a primeiro operando
     * @param b segundo operando
     * @param operador símbolo da operação desejada
     * @return o resultado da operação correspondente ao operador informado
     * @throws IllegalArgumentException se o operador não for um símbolo válido
     *         ou se houver divisão por zero
     */
    public int calcular(int a, int b, String operador) {
        // Operador nulo também é inválido (evita NullPointerException no switch)
        if (operador == null) {
            throw new IllegalArgumentException("Operador inválido: null");
        }
        // Delega para o método correspondente ao operador informado
        return switch (operador) {
            case "+" -> somar(a, b);
            case "-" -> subtrair(a, b);
            case "*" -> multiplicar(a, b);
            case "/" -> dividir(a, b);
            // Qualquer outro símbolo não é suportado
            default -> throw new IllegalArgumentException("Operador inválido: " + operador);
        };
    }
}
