
import java.io.*;
import java.util.*;

public class Stack_To_Queue_adapter_Add_Efficient {

    public static class StackToQueueAdapter {
        Stack<Integer> mainS;
        Stack<Integer> helperS;

        public StackToQueueAdapter() {
            mainS = new Stack<>();
            helperS = new Stack<>();
        }

        int size() {
            return mainS.size();
        }

        void add(int val) {
            mainS.push(val);
        }

        int remove() {
            while (!mainS.isEmpty()) {
                helperS.push(mainS.pop());
            }

            int popped = -1;

            if (helperS.size() == 0)
                System.out.println("Queue underflow");
            else
                popped = helperS.pop();

            while (!helperS.isEmpty()) {
                mainS.push(helperS.pop());
            }

            return popped;
        }

        int peek() {
            while (!mainS.isEmpty()) {
                helperS.push(mainS.pop());
            }

            int popped = -1;

            if (helperS.size() == 0)
                System.out.println("Queue underflow");
            else
                popped = helperS.peek();

            while (!helperS.isEmpty()) {
                mainS.push(helperS.pop());
            }

            return popped;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StackToQueueAdapter qu = new StackToQueueAdapter();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}
