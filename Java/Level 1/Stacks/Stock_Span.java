import java.util.Stack;

public class Stock_Span {

    // Stock Span is number of days for which the stock remain greatest
    // Look in the copy to why we are taking an entry of -1

    // 1. Pop
    // 2.Answer
    // 3. Push
    public static int[] arrayOfStockSpan(int[] arr) {

        int[] result = new int[arr.length];
        Stack<Integer> stk = new Stack<>();

        // FInd the next greatest element on left
        // Store the element's index in stack to find the span

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];

            if (stk.isEmpty()) {
                result[i] = i + 1;
                stk.push(i);
            } else if (arr[stk.peek()] <= current) {
                while (!stk.isEmpty() && arr[stk.peek()] <= current)
                    stk.pop();

                if (stk.isEmpty()) {
                    result[i] = i + 1;
                    stk.push(i);
                } else if (arr[stk.peek()] > current) {
                    result[i] = i - stk.peek();
                    stk.push(i);
                }
            } else if (arr[stk.peek()] > current) {
                result[i] = i - stk.peek();
                stk.push(i);
            }

        }

        return result;
    }

}
