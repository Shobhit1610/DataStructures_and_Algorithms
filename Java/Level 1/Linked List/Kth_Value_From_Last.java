
public class Kth_Value_From_Last {
  public static class Node {
    int data;
    Node next;
  }

  public static class LinkedList {
    Node head;
    Node tail;
    int size;

    public int kthFromLast(int k){
        Node slow=head,fast=head;

        while(k-- >0) fast=fast.next;
        while(fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }

        return slow.data;
    }
  }

}