public class Remove_First {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public void removeFirst() {
            if(head==null)
            {
                System.out.println("List is empty");
                return;
            }
            else{
                head=head.next;
                size--;
            }  
        }
    }
}
