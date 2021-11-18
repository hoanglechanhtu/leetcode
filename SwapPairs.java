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
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode cur = dummyHead;
        
        //dummy 1 2 3
        //next = 3
        // 2 -> 1 -> 3
        //
        while(cur != null && cur.next != null && cur.next.next != null) {
            ListNode next = cur.next.next.next;
            cur.next.next.next = cur.next;
            cur.next = cur.next.next;
            cur.next.next.next = next;
                   
            cur = cur.next.next; 
        }
        
        return dummyHead.next;
    }
}
