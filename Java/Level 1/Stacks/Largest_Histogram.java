import java.util.Scanner;
import java.util.Stack;

public class Largest_Histogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sc.close();

        // Index to the most left is -1
        int[] index_nextSmallerToLeft = nextSmallerToLeft(arr);
        // Index to the thr most right is arr.length
        int[] index_nextSmallerToRight = nextSmallerToRight(arr);

        int maxArea = Integer.MIN_VALUE;
        int currentArea = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            currentArea = arr[i] * (index_nextSmallerToRight[i] - index_nextSmallerToLeft[i] - 1);
            maxArea = Math.max(maxArea, currentArea);
        }

        System.out.println(maxArea);

    }

    public static int[] nextSmallerToLeft(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            if (stk.isEmpty()) {
                result[i] = -1;
                stk.push(i);
            } else if (arr[stk.peek()] >= current) {
                while (!stk.isEmpty() && arr[stk.peek()] >= current) {
                    stk.pop();
                }
                if (stk.isEmpty()) {
                    result[i] = -1;
                    stk.push(i);
                } else if (arr[stk.peek()] < current) {
                    result[i] = stk.peek();
                    stk.push(i);
                }
            } else if (arr[stk.peek()] < current) {
                result[i] = stk.peek();
                stk.push(i);
            }
        }

        return result;
    }

    public static int[] nextSmallerToRight(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stk = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            if (stk.isEmpty()) {
                result[i] = arr.length;
                stk.push(i);
            } else if (arr[stk.peek()] >= current) {
                while (!stk.isEmpty() && arr[stk.peek()] >= current) {
                    stk.pop();
                }
                if (stk.isEmpty()) {
                    result[i] = arr.length;
                    stk.push(i);
                } else if (arr[stk.peek()] < current) {
                    result[i] = stk.peek();
                    stk.push(i);
                }
            } else if (arr[stk.peek()] < current) {
                result[i] = stk.peek();
                stk.push(i);
            }
        }

        return result;
    }

}
