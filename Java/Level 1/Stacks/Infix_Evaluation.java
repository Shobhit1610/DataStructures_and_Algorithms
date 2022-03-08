import java.util.Scanner;
import java.util.Stack;

public class Infix_Evaluation {

    public static int applyCharacterAsOperator(int firstNum, int secondNum, char operator) {
        if (operator == '/')
            return firstNum / secondNum;
        else if (operator == '*')
            return firstNum * secondNum;
        else if (operator == '-')
            return firstNum - secondNum;
        else if (operator == '+')
            return firstNum + secondNum;
        else
            return -1;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        Stack<Integer> operandStk = new Stack<>();
        Stack<Character> operatorStk = new Stack<>();

        // Enclose expression in brackets
        input = "(" + input + ")";
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (current == ' ')
                continue;

            // Precedence 1
            if (current == '(') {
                operatorStk.push(current);
            }
            // Precedence 1
            else if (current == ')') {
                while (operatorStk.peek() != '(') {
                    char operator = operatorStk.pop();
                    int secondNum = operandStk.pop();
                    int firstNum = operandStk.pop();
                    operandStk.push(applyCharacterAsOperator(firstNum, secondNum, operator));
                }
                operatorStk.pop();
            }
            // Precedence 2
            else if (current == '/' || current == '*') {
                // Check if operator stack is empty
                if (operatorStk.isEmpty()) {
                    operatorStk.push(current);
                }
                // Precedence 1
                else if (operatorStk.peek() == '(') {
                    operatorStk.push(current);
                }
                // Precedence 2
                else if (operatorStk.peek() == '/' || operatorStk.peek() == '*') {
                    while (operatorStk.peek() == '/' || operatorStk.peek() == '*') {
                        char operator = operatorStk.pop();
                        int secondNum = operandStk.pop();
                        int firstNum = operandStk.pop();
                        operandStk.push(applyCharacterAsOperator(firstNum, secondNum, operator));
                    }
                    operatorStk.push(current);
                }
                // Precedence 3
                else if (operatorStk.peek() == '+' || operatorStk.peek() == '-') {
                    operatorStk.push(current);
                }
            }
            // Precedence 3
            else if (current == '+' || current == '-') {
                // Check if operator stack is empty
                if (operatorStk.isEmpty()) {
                    operatorStk.push(current);
                }
                // Precedence 1
                else if (operatorStk.peek() == '(') {
                    operatorStk.push(current);
                }
                // Precedence 2
                else if (operatorStk.peek() == '/' || operatorStk.peek() == '*') {
                    while (operatorStk.peek() == '/' ||
                            operatorStk.peek() == '*' ||
                            operatorStk.peek() == '+' ||
                            operatorStk.peek() == '-') {
                        char operator = operatorStk.pop();
                        int secondNum = operandStk.pop();
                        int firstNum = operandStk.pop();
                        operandStk.push(applyCharacterAsOperator(firstNum, secondNum, operator));
                    }
                    operatorStk.push(current);
                }
                // Precedence 3
                else if (operatorStk.peek() == '+' || operatorStk.peek() == '-') {
                    while (operatorStk.peek() == '/' ||
                            operatorStk.peek() == '*' ||
                            operatorStk.peek() == '+' ||
                            operatorStk.peek() == '-') {
                        char operator = operatorStk.pop();
                        int secondNum = operandStk.pop();
                        int firstNum = operandStk.pop();
                        operandStk.push(applyCharacterAsOperator(firstNum, secondNum, operator));
                    }
                    operatorStk.push(current);
                }

            }
            // Else Operand
            else {
                operandStk.push(Character.getNumericValue(current));
            }
        }

        System.out.println(operandStk.pop());
    }

}
