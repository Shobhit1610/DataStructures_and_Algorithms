import java.io.*;
import java.util.*;

public class Add_at_Index {
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


    public void addAt(int idx, int val){

        Node node = new Node(val);

        if(head==null)
        {
            head=tail=node;
        }
        else
        {
            Node temp = head;

            if(idx==0)
            {
                node.next=head;
                head=node;
            }
            else if(idx==size)
            {
                tail.next=node;
                tail=node;
            }
            else if (idx > size) {
                System.out.println("Invalid arguments");
                return;
            }
            else
            {
                for(int i=0;i<idx-1;i++)
                {
                    temp=temp.next;
                }
                node.next=temp.next;
                temp.next=node;
            }
        }
    }
  }
}

