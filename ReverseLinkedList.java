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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(0, head);
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;
        return pre;
    }
}
class Solution {
    
    public ListNode reverseList(ListNode head) {
        return reverse(head);
    }
    
    ListNode reverse(ListNode node) {
        if (node == null || node.next == null) return node;
        
        ListNode res = reverse(node.next);
        node.next.next = node;      
        node.next = null;
        
        return res;
        
    }
}
