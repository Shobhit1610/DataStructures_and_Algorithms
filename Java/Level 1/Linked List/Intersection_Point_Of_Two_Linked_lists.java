public class Intersection_Point_Of_Two_Linked_lists {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public static int findIntersection(LinkedList one, LinkedList two) {
            // Change bigger LL to h1 and smaller to h2

            if (one.size < two.size) {
                LinkedList temp = one;
                one = two;
                two = temp;
            }

            int diff = one.size - two.size;
            Node slow = two.head, fast = one.head;

            while (diff-- > 0)
                fast = fast.next;

            while (slow != null && fast != null && slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            // if (slow == null || fast == null)
            // return -1;
            return slow.data;
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