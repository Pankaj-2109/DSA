class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null; // not necessary since handled by counter > 0, prev will be null 
        }
        ListNode curr = head, next = null, prev = null;
        int counter = k;
        while(curr != null && counter > 0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            counter--;
        }
        if(curr == null && counter > 0){ // if last group size is not k, reverse again
            curr = prev; prev = null; next = null;
            while(curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
        }
        if(counter > 0){
            return prev; // if last group size is not k, return the original head of last sub list which will be in prev after reversing two times
        }else{
            head.next = reverseKGroup(curr, k);
        }
        return prev;
    }
}