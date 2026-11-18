class Solution {
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {

            ListNode first = prev.next;
            ListNode second = first.next;

            // Swap the pair
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move prev to the end of swapped pair
            prev = first;
        }

        return dummy.next;
    }
}