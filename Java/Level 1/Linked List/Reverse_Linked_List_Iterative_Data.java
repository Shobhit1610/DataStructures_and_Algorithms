public class Reverse_Linked_List_Iterative_Data {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public Node nodeAt(int idx) {
            if (size == 0) {
                return null;
            } else if (idx < 0 || idx >= size) {
                return null;
            } else {
                Node temp = head;
                for (int i = 0; i < idx; i++) {
                    temp = temp.next;
                }
                return temp;
            }
        }

        public void reverseDI() {
            int l = 0;
            int r = size - 1;
            while (l < r) {
                Node leftNode = nodeAt(l);
                Node rightNode = nodeAt(r);
                int temp = -1;
                temp = leftNode.data;
                leftNode.data = rightNode.data;
                rightNode.data = temp;
                l++;
                r--;
            }
        }
    }
}