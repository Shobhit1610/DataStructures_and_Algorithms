public class Check_If_Linked_List_Is_Pallendrome {

    static Node left;

    // -----------------------------------------------------
    // This is a functional problem. You have to complete this function.
    // This function takes as input the head of the linked list.
    // It should return true if list is palindrome, else return false.

    public static boolean isPalindrome(Node head) {
        // write your code here.

        // Find size
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        // Find Mid
        Node mid = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        Node prev = null, curr = null, ahead = null;
        if (cnt == 0) {
            return false;
        } else if (cnt == 1) {
            return true;
        } else if (cnt == 2) {
            if (head.data == head.next.data)
                return true;
            else
                return false;
        } else if (cnt == 3) {
            if (head.data == head.next.next.data)
                return true;
            else
                return false;
        } else {
            prev = null;
            curr = mid.next;
            ahead = mid.next.next;

            while (curr != null) {
                curr.next = prev;
                prev = curr;
                curr = ahead;
                if (ahead != null)
                    ahead = ahead.next;
            }
            // join last node of second half to the last pointer of first half
            mid.next = prev;
            // shift mid one place for corner case so in even length or odd length mid is
            // always at the starting of second half
            mid = prev;

            // Check from both parts now
            while (mid != null) {
                // System.out.println(head.data + " " + mid.data);
                if (head.data != mid.data)
                    return false;
                head = head.next;
                mid = mid.next;
            }
            return true;
        }

    }

    // Class declaration for a Node of the Linked List
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

}