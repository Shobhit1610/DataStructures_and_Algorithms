public class Reverse_Linked_List_Recursive_Data {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        Node left;

        public void reverseDR() {
            left = head;
            reverseDRHelper(head, 0);
        }

        public void reverseDRHelper(Node r, int count) {

            if (r == null) {
                return;
            }
            reverseDRHelper(r.next, count + 1);

            if (count >= size / 2) {
                int temp = left.data;
                left.data = r.data;
                r.data = temp;

                left = left.next;
            }

        }
    }
}