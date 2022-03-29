public class Fold_Of_linkedList {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void fold(ListNode head) {

        // Find mid and keep the length of left part higher in odd length link list
        ListNode mid = head;
        ListNode fast = head;

        while (fast.next.next != null && fast.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }

        ListNode firstStart = head;
        ListNode firstEnd = mid;
        ListNode secondStart = mid.next;
        ListNode secondEnd = mid.next;
        while (secondEnd.next != null)
            secondEnd = secondEnd.next;

        // Reverse the second part
        ListNode prev = null;
        ListNode current = secondStart;
        ListNode ahead = secondStart.next;

        while (current != null) {
            current.next = prev;
            prev = current;
            current = ahead;
            if (ahead != null)
                ahead = ahead.next;

        }
        firstEnd.next = prev;
        secondStart = prev;
        secondEnd = prev;
        while (secondEnd.next != null)
            secondEnd = secondEnd.next;

        // Now take 4 pointers to traverse 2 parts of linked lis
        ListNode first = firstStart;
        ListNode firstNext = firstStart.next;
        ListNode second = secondStart;
        ListNode secondNext = secondStart.next;

        while (first != firstEnd.next && second != secondEnd.next && second != null) {
            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
            firstNext = first.next;
            if (second != null)
                secondNext = second.next;
            else
                secondNext = null;
        }
        secondEnd.next = null;

    }

}