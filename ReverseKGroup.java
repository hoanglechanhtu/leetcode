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
    public ListNode reverseKGroup(ListNode head, int k) {
        return revertNode(head, k);
    }
    
    //1 2 3 null
    ListNode revertNode(ListNode head, int k) {
        if (!haveMoreThan(head, k)) return head;
        
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        for (int i = 0; i < k; i ++) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (cur != null) next = cur.next;
        }
        
        ListNode nextNode = revertNode(cur, k);
        head.next = nextNode;
        return pre;
    }
    
    boolean haveMoreThan(ListNode head, int kElement) {
        int i = 0;
        while (head != null && i < kElement) {
            i ++;
            head = head.next;
        }
        
        return i == kElement;
    }
}
