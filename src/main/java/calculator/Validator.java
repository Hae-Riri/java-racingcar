package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Validator {

    private final ArrayList<String> OPERATOR_CHAR = new ArrayList<>(
        Arrays.asList("+", "-", "*", "/"));

    public String[] stringCheck(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] Null이나 빈 공백 문자는 입력할 수 없습니다.");
        }

        String[] splitInput = input.split(" ");
        for (int i = 0; i < splitInput.length; i++) {
            if (i % 2 == 1) {
                this.operatorCheck(splitInput[i]);
            }
        }
        return splitInput;
    }

    private void operatorCheck(String operatorChar) {
        if (!OPERATOR_CHAR.contains(operatorChar)) {
            throw new IllegalArgumentException("[ERROR] 사칙연산 기호만 입력하세요.");
        }
    }

}
