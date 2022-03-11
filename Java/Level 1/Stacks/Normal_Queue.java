import java.io.*;

public class Normal_Queue {

    public static class CustomQueue {
        int[] data;
        int front;
        int rear;
        int size;
        int cap;

        public CustomQueue(int cap) {
            data = new int[cap];
            front = 0;
            rear = 0;
            size=0;
            this.cap=cap;
        }

        int size() {
            return size;
        }

        void display() {
            int count=0,idx=front;
            while(count<size)
            {
                System.out.print(data[idx]+" ");
                count++;
                idx=(idx+1)%cap;
            }
            System.out.println();
        }

        void add(int val) {
            if (size == data.length) {
                int[] temp = new int[data.length * 2];
                int count = 0, idx = front;
                while (count < size) {
                    temp[count] = data[idx];
                    count++;
                    idx = (idx + 1) % data.length;
                }

                front = 0;
                rear = data.length;
                data = temp;
            }
            data[rear] = val;
            rear=(rear+1)%cap;;
            size++;


            
        }

        int remove() {
            if(size==0)
            {
                System.out.println("Queue underflow");
                return -1;
            }
            int val=data[front];
            front=(front+1)%cap;
            size--;
            return val;
        }

        int peek() {
            if (size == 0) {
                System.out.println("Queue underflow");
                return -1;
            }
            return data[front];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        CustomQueue qu = new CustomQueue(n);

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
            } else if (str.startsWith("display")) {
                qu.display();
            }
            str = br.readLine();
        }
    }
}