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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0, l1);
        ListNode pre = dummyHead;
        int rem = 0;
        while(l1 != null && l2 != null) {
            int total = l1.val + l2.val + rem;
            int newVal = total % 10;
            rem = total / 10;
            pre = l1;
            l1.val = newVal;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null) {
            pre = l1;
            int total = l1.val + rem;
            int newVal = total % 10;
            rem = total / 10;
            l1.val = newVal;
            l1 = l1.next;
        }
        
        pre.next = l2;
        
         while(l2 != null) {
            pre = l2;
            int total = l2.val + rem;
            int newVal = total % 10;
            rem = total / 10;
            l2.val = newVal;
            l2 = l2.next;
        }
        
        if (rem != 0) {
            pre.next = new ListNode(rem, null);
        }
        
        return dummyHead.next;
        
        
    }
}
