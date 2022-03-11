public class Remove_At_Index {

  public static class Node {
    int data;
    Node next;
  }

  public static class LinkedList {
    Node head;
    Node tail;
    int size;

    public void removeAt(int idx) {

      if (head == null) {
        System.out.println("List is empty");
        size = 0;
      } else if (head == tail) {
        head = tail = null;
        size = 0;
      } else {
        if (idx == 0) {
          head = head.next;
          size--;
        } else if (idx == size - 1) {
          Node temp = head;
          while (temp.next != tail) {
            temp = temp.next;
          }
          temp.next = null;
          tail = temp;
          size--;
        } else if (idx > size - 1) {
          System.out.println("Invalid arguments");
        } else {
          Node temp = head;
          for (int i = 0; i < idx - 1; i++) {
            temp = temp.next;
          }
          temp.next = temp.next.next;
          size--;
        }

      }

    }

  }
}
