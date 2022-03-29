public class MergeSort_Linked_list {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

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

        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
            LinkedList ml = new LinkedList();

            Node one = l1.head;
            Node two = l2.head;
            while (one != null && two != null) {
                if (one.data < two.data) {
                    ml.addLast(one.data);
                    one = one.next;
                } else {
                    ml.addLast(two.data);
                    two = two.next;
                }
            }

            while (one != null) {
                ml.addLast(one.data);
                one = one.next;
            }

            while (two != null) {
                ml.addLast(two.data);
                two = two.next;
            }

            return ml;
        }

        public static LinkedList mergeSort(Node head, Node tail) {

            return mergeSortHelper(head, tail);
        }

        public static LinkedList mergeSortHelper(Node head, Node tail) {

            // Base Condition
            if (head == tail) {
                Node onlyNode = new Node();
                onlyNode.data = head.data;
                onlyNode.next = null;

                LinkedList res = new LinkedList();
                res.head = onlyNode;
                res.tail = onlyNode;
                res.size = 1;
                return res;

            }

            // Find middle node such that in even length we get the first median node
            Node mid = head, fast = head;
            while (fast != tail && fast.next != tail) {
                mid = mid.next;
                fast = fast.next.next;
            }

            LinkedList l1 = mergeSortHelper(head, mid);
            LinkedList l2 = mergeSortHelper(mid.next, tail);
            return mergeTwoSortedLinkedList(l1, l2);
        }

        public static LinkedList mergeTwoSortedLinkedList(LinkedList l1, LinkedList l2) {
            LinkedList res = new LinkedList();

            Node l1Node = l1.head;
            Node l2Node = l2.head;

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
    }

}