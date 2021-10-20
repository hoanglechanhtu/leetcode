/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode dummyHead = new ListNode(0, head);
        ListNode slow = dummyHead, fast = dummyHead;
        
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while(fast != null && fast.next != null && slow != fast);
        
        return slow == fast;
    }
}
