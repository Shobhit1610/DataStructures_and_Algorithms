public class Add_First {
  
    public static class Node {
        int data;
        Node next;
        public Node(int val)
        {
            data=val;
            next=null;
        }
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public void addFirst(int val) {
            Node node = new Node(val);

            if(head==null)
            {
                head = tail = node;
                size=1;
            }
            else
            {
                node.next=head;
                head=node;
                size++;
            }
        }
    }
  
}
