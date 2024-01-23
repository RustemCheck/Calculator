import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();

        System.out.println(calc(expression));
    }

    public static String calc(String input) {

        String[] expression = input.split(" ");

        if (expression.length < 3) {
            throw new IllegalArgumentException("Строка не является математической операцией!");
        } else if (expression.length > 3) {
            throw new IllegalArgumentException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор");
        }

        try {
            int operandOne = Integer.parseInt(expression[0]);
            char operator = expression[1].charAt(0);
            int operandTwo = Integer.parseInt(expression[2]);

            int result = getResult(operandOne, operandTwo, operator);

            return String.valueOf(result);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Ошибка парсинга чисел. Проверьте введённые операнды");
        }
    }

    private static int getResult(int operandOne, int operandTwo, char operator) {

        int result;

        if ((operandOne > 0 && operandTwo > 0) && (operandOne < 11 && operandTwo < 11)) {

            switch (operator) {
                case '+':
                    result = operandOne + operandTwo;
                    break;
                case '-':
                    result = operandOne - operandTwo;
                    break;
                case '*':
                    result = operandOne * operandTwo;
                    break;
                case '/':
                    result = operandOne / operandTwo;
                    break;
                default:
                    throw new ArithmeticException("Используем только 1 из перечисленных операторов - +, -, /, *");
            }
        } else {
            throw new ArithmeticException("По условию используем операнды от 1 до 10 включитльно!");
        }
        return result;
    }
}