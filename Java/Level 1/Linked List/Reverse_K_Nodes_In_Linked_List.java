public class Reverse_K_Nodes_In_Linked_List {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public Node reverse(Node firstNode, Node lastNode) {
            Node prev = null;
            Node curr = firstNode;
            Node ahead = curr.next;

            while (prev != lastNode) {
                curr.next = prev;
                prev = curr;
                curr = ahead;
                if (ahead != null)
                    ahead = ahead.next;
            }

            return prev;
        }

        public void kReverse(int k) {

            int cnt = 0;

            // First iteartion
            Node current = head;
            Node firstNode = head;
            Node lastNode = head;
            while (cnt < k) {
                if (current == null)
                    break;

                if (cnt == k - 1) {
                    lastNode = current;
                }
                current = current.next;
                cnt++;

            }

            if (current == null && cnt < k) {

            } else {
                reverse(firstNode, lastNode);
                head = lastNode;
                tail = firstNode;
            }

            // Rest Iteration
            while (current != null) {
                cnt = 0;
                firstNode = current;
                while (cnt < k) {
                    if (current == null)
                        break;
                    if (cnt == k - 1) {
                        lastNode = current;
                    }
                    current = current.next;
                    cnt++;
                }
                if (current == null && cnt < k) {
                    tail.next = firstNode;
                    while (tail.next != null)
                        tail = tail.next;
                } else {
                    reverse(firstNode, lastNode);
                    tail.next = lastNode;
                    tail = firstNode;
                }

            }

        }
    }

}