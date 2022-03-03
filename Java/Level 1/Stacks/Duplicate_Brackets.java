import java.util.Scanner;
import java.util.Stack;

public class Duplicate_Brackets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        Stack<Character> stk = new Stack<>();

        for(int i=0;i<input.length();i++)
        {
            char current = input.charAt(i);
            
            if(current==')')
            {
                if(stk.peek()=='(')
                {
                    System.out.println("true");
                    return;
                }
                else
                {
                    while (stk.peek() != '(') {
                        stk.pop();
                    }
                    stk.pop();
                }
                
            }
            else
            {
                stk.push(current);
            }
        }

        System.out.println("false");
    }
}
