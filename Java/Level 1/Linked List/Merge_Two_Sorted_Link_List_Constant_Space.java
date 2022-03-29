public class Merge_Two_Sorted_Link_List_Constant_Space {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {

            // Swap so l1 head is smaller
            if (l1.head.data > l2.head.data) {
                LinkedList temp = l1;
                l1 = l2;
                l2 = temp;
            }

            // Check for right neighbour and down neighbour , whomsoever is smaller join the
            // current to that
            Node current = l1.head;
            Node right = l1.head.next;
            Node down = l2.head;
            while (right != null && down != null) {

                if (right.data < down.data) {
                    current.next = right;
                    right = right.next;
                } else if (right.data >= down.data) {
                    current.next = down;
                    down = down.next;
                }
                current = current.next;
            }
            if (right == null) {
                current.next = down;
            } else if (down == null) {
                current.next = right;
            }

            return l1;

        }
    }

}