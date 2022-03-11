public class Add_Last_In_Linked_List {
    public static class Node {
        int data;
        Node next;

        public Node(int val) {
            data = val;
            next = null;
        }
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            Node node = new Node(val);

            if (head == null) {
                head = node;
                tail = node;
                size = 1;
            } else {
                tail.next = node;
                tail = node;
                size++;
            }
        }
    }
}