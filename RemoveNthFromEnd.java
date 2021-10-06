/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);
        remove(dummyHead, n);
        return dummyHead.next;
    }
    
    int remove(ListNode head, int n) {
        int x = 0;
        if (head.next == null) x = 1;
        else x = 1 + remove(head.next, n);
        if (x == n + 1)  {
            head.next = head.next.next;
        }
        return x;
    } 
}
