public class Merge_two_Sorted_Linked_List {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
            // write your code hered

            // Take a new Linked List and add the smaller node to the resultant list
            LinkedList res = new LinkedList();

            Node l1Node = l1.head, l2Node = l2.head;

            while (l1Node != null && l2Node != null) {
                if (l1Node.data < l2Node.data) {
                    res.addLast(l1Node.data);
                    l1Node = l1Node.next;
                } else {
                    res.addLast(l2Node.data);
                    l2Node = l2Node.next;
                }
            }
            if (l1Node == null) {
                while (l2Node != null) {
                    res.addLast(l2Node.data);
                    l2Node = l2Node.next;
                }
            } else if (l2Node == null) {
                while (l1Node != null) {
                    res.addLast(l1Node.data);
                    l1Node = l1Node.next;
                }
            }

            return res;
        }

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            size++;
        }
    }

}