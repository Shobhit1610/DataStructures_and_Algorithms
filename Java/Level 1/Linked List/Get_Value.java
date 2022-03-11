public class Get_Value {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public int getFirst() {
            if(head==null)
            {
                System.out.println("List is empty");
                return -1;
            }
            return head.data;
        }

        public int getLast() {
            if(tail==null)
            {
                System.out.println("List is empty");
                return -1;
            }
            return tail.data;
        }

        public int getAt(int idx) {

            Node temp = head;

            if (idx == 0)
                return getFirst();
            else if (idx == size-1)
                return getLast();
            else if (idx > size-1) {
                System.out.println("Invalid arguments");
                return -1;
            } else {
                for (int i = 0; i < idx; i++) {
                    temp = temp.next;
                }
                return temp.data;

            }

        }
    }
}
