import java.util.Queue;
import java.util.ArrayDeque;
import java.io.*;

public class Queue_To_Stack_Push_Efficient {

    public static class QueueToStackAdapter {
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        public QueueToStackAdapter() {
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        int size() {
            return mainQ.size();
        }

        void push(int val) {
            mainQ.add(val);
        }

        int pop() {
            while(mainQ.size()>1)
            {
                helperQ.add(mainQ.remove());
            }
            int popped=mainQ.remove();
            
            Queue<Integer> temp=mainQ;
            mainQ=helperQ;
            helperQ=temp;

            return popped;
        }

        int top() {
            while (mainQ.size() > 1) {
                helperQ.add(mainQ.remove());
            }
            int popped = mainQ.remove();
            helperQ.add(popped);

            Queue<Integer> temp = mainQ;
            mainQ = helperQ;
            helperQ = temp;

            return popped;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        QueueToStackAdapter st = new QueueToStackAdapter();

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
            }
            str = br.readLine();
        }
    }
    
}
