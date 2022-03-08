import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Min_Stack {
    public static class MinStack {
        Stack<Integer> allData;
        Stack<Integer> minData;

        public MinStack() {
            allData = new Stack<>();
            minData = new Stack<>();
        }

        int size() {
            // write your code here
            return allData.size();
        }

        void push(int val) {
            // write your code here
            allData.push(val);
            if(minData.isEmpty())
            {
                minData.push(val);
            }
            else if(minData.peek()>=val)
            {
                minData.push(val);
            }
        }

        int pop() {
            // write your code here
            int popped = allData.pop();
            if(minData.peek()==popped)
                minData.pop();
            return popped;
        }

        int top() {
            // write your code here
            return allData.peek();
        }

        int min() {
            // write your code here
            return minData.peek();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("min")) {
                int val = st.min();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            str = br.readLine();
        }
    }
}
