
import java.io.*;

public class Two_Stacks_One_Array {

    public static class TwoStack {
        int[] data;
        int tos1;
        int tos2;

        public TwoStack(int cap) {
            tos1 = -1;
            tos2 = cap;
            data = new int[cap];
        }

        int size1() {
            return tos1 + 1;
        }

        int size2() {
            return tos2 - 1;
        }

        void push1(int val) {
            if (tos2 - tos1 == 1) {
                System.out.println("Stack overflow");
            } else
                data[++tos1] = val;
        }

        void push2(int val) {
            if (tos2 - tos1 == 1) {
                System.out.println("Stack overflow");
            } else
                data[--tos2] = val;
        }

        int pop1() {
            int popped = -1;
            if (tos1 == -1)
                System.out.println("Stack underflow");
            else
                popped = data[tos1--];
            return popped;
        }

        int pop2() {
            int popped = -1;
            if (tos2 == data.length)
                System.out.println("Stack underflow");
            else
                popped = data[tos2++];
            return popped;
        }

        int top1() {
            int popped = -1;
            if (tos1 == -1)
                System.out.println("Stack underflow");
            else
                popped = data[tos1];
            return popped;
        }

        int top2() {
            int popped = -1;
            if (tos2 == data.length)
                System.out.println("Stack underflow");
            else
                popped = data[tos2];
            return popped;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TwoStack st = new TwoStack(n);

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push1")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push1(val);
            } else if (str.startsWith("pop1")) {
                int val = st.pop1();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top1")) {
                int val = st.top1();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size1")) {
                System.out.println(st.size1());
            } else if (str.startsWith("push2")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push2(val);
            } else if (str.startsWith("pop2")) {
                int val = st.pop2();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top2")) {
                int val = st.top2();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size2")) {
                System.out.println(st.size2());
            }
            str = br.readLine();
        }
    }
}