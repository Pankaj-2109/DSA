class Solution {

    public ListNode solve(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;

        first.next = solve(second.next);
        second.next = first;

        return second;
    }

    public ListNode swapPairs(ListNode head) {
        return solve(head);
    }
}