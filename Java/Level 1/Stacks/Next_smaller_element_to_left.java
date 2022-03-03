import java.util.Stack;

public class Next_smaller_element_to_left {

    public static int[] solve(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stk = new Stack<Integer>();

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];

            if (stk.isEmpty()) {
                result[i] = -1;
                stk.push(current);
            } else if (stk.peek() < current) {
                result[i] = stk.peek();
                stk.push(current);
            } else if (stk.peek() >= current) {
                while (stk.isEmpty() && stk.peek() >= current)
                    stk.pop();

                if (stk.isEmpty()) {
                    result[i] = -1;
                    stk.push(current);
                } else if (stk.peek() < current) {
                    result[i] = stk.peek();
                    stk.push(current);
                }
            }
        }
        return result;
    }

}
