public class Middle_Of_LinkedList {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public int mid() {
            Node slow = head, fast = head;

            // Odd fast will reach last node fast=tail
            // Even fast will reach second last fast.next=tail

            while (fast != tail && fast.next != tail) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.data;
        }
    }

}