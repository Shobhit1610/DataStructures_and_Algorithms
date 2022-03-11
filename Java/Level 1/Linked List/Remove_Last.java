public class Remove_Last {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public void removeLast() {
            if (head == null) {
                System.out.println("List is empty");
            } else if (head == tail) {
                head = tail = null;
                size = 0;
            } else {
                Node temp = head;
                while (temp.next != tail)
                    temp = temp.next;
                tail = temp;
                tail.next = null;
                size--;
            }
        }
    }
}
