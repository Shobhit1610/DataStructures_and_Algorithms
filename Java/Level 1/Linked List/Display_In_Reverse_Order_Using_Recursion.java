public class Display_In_Reverse_Order_Using_Recursion {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public void displayReverse() {
            displayReverseHelper(head);
            System.out.println();
        }

        private void displayReverseHelper(Node node) {
            //Go to end and then print one by one

            if(node==null) return;

            displayReverseHelper(node.next);
            System.out.print(node.data+" ");
        }
    }
}
