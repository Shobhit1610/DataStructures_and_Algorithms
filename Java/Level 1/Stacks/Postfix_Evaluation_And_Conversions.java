import java.util.Scanner;
import java.util.Stack;

public class Postfix_Evaluation_And_Conversions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        // In prefix evaluation we will traverse the input string from right to left
        // In postfix expression we will traverse the input string from left to right
        // In general we will traverse the input opposite to where operators are present

        System.out.println(postfixEvaluation(input));
        System.out.println(infixConversion(input));
        System.out.println(prefixConversion(input));

    }

    public static int applyOperation(int first, int second, char current) {
        if (current == '/')
            return first / second;
        else if (current == '*')
            return first * second;
        else if (current == '+')
            return first + second;
        else
            return first - second;
    }

    public static int postfixEvaluation(String input) {
        int result = 0;
        Stack<Integer> operandStk = new Stack<>();

        for (int i = 0;i<input.length();i++) {
            char current = input.charAt(i);

            // No brackets will be present in prefix
            if (current == '/' || current == '*' || current == '+' || current == '-') {
                int top = operandStk.pop();
                int secondTop = operandStk.pop();
                operandStk.push(applyOperation(secondTop, top, current));
            } else {
                operandStk.push(Character.getNumericValue(current));
            }

        }
        result = operandStk.pop();
        return result;
    }

    public static String infixConversion(String input) {
        String result = "";
        Stack<String> stk = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '/' || current == '*' || current == '+' || current == '-') {
                String top = stk.pop();
                String secondTop = stk.pop();
                stk.push("(" + secondTop + current + top + ")");
            } else {
                stk.push(Character.toString(current));
            }

        }
        result = stk.pop();
        return result;
    }

    public static String prefixConversion(String input) {
        String result = "";
        Stack<String> stk = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '/' || current == '*' || current == '+' || current == '-') {
                String top = stk.pop();
                String secondTop = stk.pop();
                stk.push(current+ secondTop + top);
            } else {
                stk.push(Character.toString(current));
            }

        }
        result = stk.pop();
        return result;
    }

}
