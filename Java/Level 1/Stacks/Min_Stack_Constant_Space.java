import java.io.*;
import java.util.*;

public class Min_Stack_Constant_Space {

    public static class MinStack {
        Stack<Integer> data;
        int min;

        public MinStack() {
            data = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        int size() {
            // write your code here
            return data.size();
        }

        void push(int val) {
            // write your code here
            if(val<=this.min)
            {
                data.push(val+val-this.min);
                this.min=val;
            }
            else
            {
                data.push(val);
            }

        }

        int pop() {
            // write your code here
            int actualVal=0;
            if(data.peek()<this.min){
                actualVal=this.min;
                this.min = this.min+this.min-data.pop();   
            }
            else 
                actualVal = data.pop();
            return actualVal;
        }

        int top() {
            // write your code here
            int actualTop=data.peek();
            if(data.peek()<this.min)
            {
                actualTop = this.min;
            }
            return actualTop;
        }

        int min() {
            // write your code here
            return this.min;
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