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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummyNode = new ListNode(head.val - 1, head);
        
        return deleteDup(dummyNode.val, dummyNode, head).next;
    }
    //0 1 2 3 3 4 4 5 
    ListNode deleteDup(int dup, ListNode pre, ListNode cur) {
        if (cur == null) return cur;
        if (cur.val == dup || (cur.next != null && cur.val == cur.next.val)) {
            dup = cur.val;
            pre.next = cur.next;
            deleteDup(dup, pre, pre.next);
            return pre;
        } else {
            deleteDup(cur.val, cur, cur.next);
            return pre;
        }
        
    }
}
