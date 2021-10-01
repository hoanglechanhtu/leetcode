class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;
        ListNode tail = head;
        int length = getLength(head);
        while(tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        
        k = k % length;
        int move = length - k;
        while(move - 1 > 0) {
            head = head.next;
            move--;
        }
        
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
    }
    
    int getLength(ListNode head) {
        int size = 0;
        while(head != null) {
            head = head.next;
            size ++;
        }
        return size;
    }
}
