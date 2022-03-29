public class Reverse_Linked_List_Iterative_Pointer {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public void reversePI() {
            Node prev = null;
            Node curr = head;
            Node ahead = curr.next;

            tail = head;
            while (curr != null) {
                curr.next = prev;
                prev = curr;
                curr = ahead;
                if (ahead != null)
                    ahead = ahead.next;
            }
            head = prev;
        }
    }

}