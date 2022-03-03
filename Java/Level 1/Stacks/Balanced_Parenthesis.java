import java.util.Scanner;
import java.util.Stack;

//Only take brackets as input not operators and operands 

public class Balanced_Parenthesis {
    public static char getOpeningBracket(char c) {
        if (c == ')')
            return '(';
        else if (c == '}')
            return '{';
        else
            return '[';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // Check stack for every closing bracket
            if (c == ']' || c == '}' || c == ')') {

                // If stack is empty then closing extra
                if (stk.isEmpty()) {
                    System.out.println("false");
                    return;
                }

                // If top element doesnt match means opening extra
                else if (stk.peek() != getOpeningBracket(c)) {
                    System.out.println("false");
                    return;
                }

                // Opeing andclosing paired so pop the existing opening bracket in stack
                else
                    stk.pop();
            }

            // Only push opening brackets
            else if (c == '[' || c == '{' || c == '(') {
                stk.push(c);
            }

        }

        if (stk.isEmpty())
            System.out.println("true");
        else
            System.out.println("false");
    }
}