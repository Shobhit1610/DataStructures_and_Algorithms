import java.util.Scanner;
import java.util.Stack;

public class Infix_Conversion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        System.out.println(postfixExpression(input));
        System.out.println(prefixExpression(input));

    }

    public static String postfixExpression(String input) {

        //Surround input string with ( and )
        input = "(" + input + ")";

        Stack<String> stk = new Stack<>();
        Stack<Character> operatorStk = new Stack<>();

        //Parse the input from left to right as operators are on right side in postfix 
        for (int i = 0; i < input.length(); i++) {

            //Select every element as current
            char current = input.charAt(i);

            /*
            //All Possibilies of elements are ( , ) , / , * , + , - and operands
            //We will check from higher precedence to lower
            //Levels of precedence to check are if curent  
                //1. (
                    //Push

                //2. )
                    //Pop till we get (

                //3. / and * 
                    //If top is (
                        //Push current
                    //Else if top is / and * [ Equal precednce of top and current ]
                        //pop till the top is of lower priority
                    //Else if top is + and - [ Top precedence < Current Precednce ]
                        // pop till the top is of lower priority

                //4. + and -
                    // If top is (
                        // Push current
                    // Else if top is / and * [ Top Precednce  >  Current Precedence ]
                        // pop till the top is of lower priority
                    // Else if top is + and - [ Top precedence = Current Precednce ]
                        // pop till the top is of lower priority
                //5. Operands 

             */   
            if (current == '(') {
                operatorStk.push(current);
            } else if (current == ')') {
                while (operatorStk.peek() != '(') {
                    char operator = operatorStk.pop();
                    String second = stk.pop();
                    String first = stk.pop();
                    stk.push(first + second + operator);
                }
                operatorStk.pop();

            } else if (current == '/' || current == '*') {
                if (operatorStk.peek() == '(') {
                    operatorStk.push(current);

                } else if (operatorStk.peek() == '/' || operatorStk.peek() == '*') {
                    while (operatorStk.peek() == '/' || operatorStk.peek() == '*') {
                        char operator = operatorStk.pop();
                        String second = stk.pop();
                        String first = stk.pop();
                        stk.push(first + second + operator);
                    }
                    operatorStk.push(current);
                } else if (operatorStk.peek() == '+' || operatorStk.peek() == '-') {
                    operatorStk.push(current);
                }
            } else if (current == '+' || current == '-') {
                if (operatorStk.peek() == '(') {
                    operatorStk.push(current);

                } else if (operatorStk.peek() == '/' || operatorStk.peek() == '*') {
                    while (operatorStk.peek() == '/' ||
                            operatorStk.peek() == '*' ||
                            operatorStk.peek() == '+' ||
                            operatorStk.peek() == '-') {
                        char operator = operatorStk.pop();
                        String second = stk.pop();
                        String first = stk.pop();
                        stk.push(first + second + operator);
                    }
                    operatorStk.push(current);
                } else if (operatorStk.peek() == '+' || operatorStk.peek() == '-') {
                    while (operatorStk.peek() == '/' ||
                            operatorStk.peek() == '*' ||
                            operatorStk.peek() == '+' ||
                            operatorStk.peek() == '-') {
                        char operator = operatorStk.pop();
                        String second = stk.pop();
                        String first = stk.pop();
                        stk.push(first + second + operator);
                    }
                    operatorStk.push(current);
                }
            } else {
                stk.push(Character.toString(current));
            }
        }
        return stk.pop();

    }

    public static String prefixExpression(String input) {
        input = "(" + input + ")";
        Stack<String> stk = new Stack<>();
        Stack<Character> operatorStk = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '(') {
                operatorStk.push(current);
            } else if (current == ')') {
                while (operatorStk.peek() != '(') {
                    char operator = operatorStk.pop();
                    String second = stk.pop();
                    String first = stk.pop();
                    stk.push(operator + first + second);
                }
                operatorStk.pop();

            } else if (current == '/' || current == '*') {
                if (operatorStk.peek() == '(') {
                    operatorStk.push(current);

                } else if (operatorStk.peek() == '/' || operatorStk.peek() == '*') {
                    while (operatorStk.peek() == '/' || operatorStk.peek() == '*') {
                        char operator = operatorStk.pop();
                        String second = stk.pop();
                        String first = stk.pop();
                        stk.push(operator + first + second);
                    }
                    operatorStk.push(current);
                } else if (operatorStk.peek() == '+' || operatorStk.peek() == '-') {
                    operatorStk.push(current);
                }
            } else if (current == '+' || current == '-') {
                if (operatorStk.peek() == '(') {
                    operatorStk.push(current);

                } else if (operatorStk.peek() == '/' || operatorStk.peek() == '*') {
                    while (operatorStk.peek() == '/' ||
                            operatorStk.peek() == '*' ||
                            operatorStk.peek() == '+' ||
                            operatorStk.peek() == '-') {
                        char operator = operatorStk.pop();
                        String second = stk.pop();
                        String first = stk.pop();
                        stk.push(operator + first + second);
                    }
                    operatorStk.push(current);
                } else if (operatorStk.peek() == '+' || operatorStk.peek() == '-') {
                    while (operatorStk.peek() == '/' ||
                            operatorStk.peek() == '*' ||
                            operatorStk.peek() == '+' ||
                            operatorStk.peek() == '-') {
                        char operator = operatorStk.pop();
                        String second = stk.pop();
                        String first = stk.pop();
                        stk.push(operator + first + second);
                    }
                    operatorStk.push(current);
                }
            } else {
                stk.push(Character.toString(current));
            }
        }
        return stk.pop();

    }

}
