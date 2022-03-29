
public class Remove_Duplicates_in_Sorted_Linked_list {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public void removeDuplicates() {
            Node l1 = head;
            while (l1 != null) {
                while (l1.next != null && l1.next.data == l1.data)
                    l1.next = l1.next.next;
                l1 = l1.next;
            }
        }
    }
}