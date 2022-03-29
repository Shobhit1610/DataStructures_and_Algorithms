public class Segregate_Even_And_Odd_In_Linked_List {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {

        ListNode even = new ListNode(-1);
        ListNode odd = new ListNode(-1);

        ListNode evenStart = even;
        ListNode oddStart = odd;

        ListNode current = head;
        while (current != null) {
            if (current.val % 2 == 0) {
                even.next = current;
                even = current;
            } else if (current.val % 2 != 0) {
                odd.next = current;
                odd = current;
            }
            current = current.next;
        }

        // TO skip the starting dummy node
        oddStart = oddStart.next;

        even.next = oddStart;
        evenStart = evenStart.next;

        odd.next = null;

        return evenStart;
    }

}
