public class Unfold_The_LinkedList {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void unfold(ListNode head) {

        ListNode firstStart = head;
        ListNode firstEnd = null;
        ListNode secondStart = head.next;
        // ListNode secondEnd = null;

        ListNode first = firstStart;
        ListNode second = secondStart;

        while (first.next != null && second.next != null) {
            first.next = first.next.next;
            second.next = second.next.next;
            first = first.next;
            second = second.next;

        }
        firstEnd = first;
        // secondEnd = second;

        // reverse the second part
        ListNode prev = null;
        ListNode curr = secondStart;
        ListNode ahead = curr.next;
        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = ahead;
            if (ahead != null)
                ahead = ahead.next;

        }
        secondStart = prev;
        // secondEnd = null;
        firstEnd.next = secondStart;

    }

}