package calculator;

<<<<<<< HEAD
public class Calculator {

    private static int DIGIT_RANGE = 2;

    public double execute(String[] input) {
        double result = Double.parseDouble(input[0]);
        for (int i = 1; i < input.length; i += 2) {
            double operand = Double.parseDouble(input[i + 1]);
            result = calculate(input[i], result, operand);
        }
        return result;
    }

    private double calculate(String operator, double result, double operand) {
        if (operator.equals("+")) {
            return add(result, operand);
        }
        if (operator.equals("-")) {
            return subtract(result, operand);
        }
        if (operator.equals("*")) {
            return multiple(result, operand);
        }
        return divide(result, operand);
    }

    private double add(double number1, double number2) {
        return number1 + number2;
    }

    private double subtract(double number1, double number2) {
        return number1 - number2;
    }

    private double multiple(double number1, double number2) {
        return number1 * number2;
    }

    private double divide(double number1, double number2) {
        if (number2 == 0) {
            throw new IllegalArgumentException("[ERROR] 0으로 나눌 수 없습니다.");
        }
        return Math.round((number1 / number2) * Math.pow(10, DIGIT_RANGE)) / Math.pow(10,
            DIGIT_RANGE);
=======
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    private final List<Double> numbers;
    private final List<String> operators;

    public Calculator(List<String> numbers, List<String> operators) {
        this.numbers = numbers.stream().map(Double::parseDouble)
            .collect(Collectors.toCollection(LinkedList::new));
        this.operators = operators;
    }

    public Double execute() {
        Double result = numbers.get(0);
        numbers.remove(0);
        for (final String operator : operators) {
            result = Operator.operatorOf(operator).apply(result, numbers.get(0));
            numbers.remove(0);
        }
        return result;
>>>>>>> a80a2bb801c40c45a660a7e8d79fc3cde75d2215
    }
}
