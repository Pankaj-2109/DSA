class Solution {
    // Helper function to find the length of the linked list
    public int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int n = getLength(head);
        int groups = n / k;
        
        ListNode prevHead = null;
        ListNode currentHead = head;
        ListNode answerNode = null;
        
        for (int i = 0; i < groups; i++) {
            ListNode prev = null;
            ListNode current = currentHead;
            ListNode nextNode = null;
            
            // Reverse k nodes
            for (int j = 0; j < k; j++) {
                nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
            }
            
            // Link the previous group's tail to the current reversed group's head
            if (prevHead == null) {
                answerNode = prev; // This is the new head of the entire linked list
            } else {
                prevHead.next = prev;
            }
            
            // Update pointers for the next iteration
            prevHead = currentHead;
            currentHead = current;
        }
        
        // Connect the last reversed group's tail to any remaining unreversed nodes
        if (prevHead != null) {
            prevHead.next = currentHead;
        }
        
        return answerNode;
    }
}