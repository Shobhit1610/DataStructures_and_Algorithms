public class Reverse_Linked_List_Recursive_Pointer {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        private void reversePRHelper(Node node) {

            if (node.next == null) {
                head = node;
                return;
            }

            reversePRHelper(node.next);
            node.next.next = node;

        }

        public void reversePR() {

            tail = head;
            reversePRHelper(head);
        }
    }
}