
import java.util.*;

//Only have to print distinct elements

public class Remove_Duplicated_in_Sorted_Linked_list_constant_space {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removeDuplicates(ListNode head) {

        // Fnd first node that will become head

        if (head.val == head.next.val) {
            while (head.val == head.next.val)
                head = head.next;

            // To skip the last occurence
            head = head.next;
        }

        // Rest of the list
        ListNode lastUniqueNode = null;
        ListNode current = head;

        while (current != null) {
            // This is the last node which is unique so have to add it
            if (current.next == null) {
                if (lastUniqueNode != null)
                    lastUniqueNode.next = current;
                lastUniqueNode = current;
            } else if (current.val == current.next.val) {
                while (current.next != null && current.val == current.next.val)
                    current = current.next;
            } else {
                if (lastUniqueNode != null)
                    lastUniqueNode.next = current;
                lastUniqueNode = current;
            }
            current = current.next;

        }
        lastUniqueNode.next = null;

        return head;

    }

}