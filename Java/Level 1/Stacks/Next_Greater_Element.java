import java.util.Stack;

public class Next_Greater_Element {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);

    }

    // Intution is plot all the points of elements as bar graph and then note the
    // next greater element
    public static int[] arrayOfNextGreaterElements(int[] input) {
        int[] result = new int[input.length];
        Stack<Integer> stk = new Stack<>();

        // Store answer for last element
        result[result.length - 1] = -1;
        stk.push(input[input.length - 1]);

        for (int i = input.length - 2; i >= 0; i--) {
            int current = input[i];

            if (stk.isEmpty()) {
                result[i] = -1;
                stk.push(current);
            }

            else if (stk.peek() <= current) {

                while (!stk.isEmpty() && stk.peek() <= current)
                    stk.pop();

                // Code to run if while conditions fail
                if (stk.isEmpty())
                    result[i] = -1;
                else if (stk.peek() > current)
                    result[i] = stk.peek();

                stk.push(current);
            }

            else if (stk.peek() > current) {
                result[i] = stk.peek();
                stk.push(current);
            }

        }
        return result;
    }

}
