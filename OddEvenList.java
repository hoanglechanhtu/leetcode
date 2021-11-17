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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode cur = head.next.next, curOdd = oddHead, curEven = evenHead;
        boolean isOdd = true;
        while(cur != null) {
            if (isOdd) {
                curOdd.next = cur;
                curOdd = curOdd.next;
                isOdd = false;
            } else {
                curEven.next = cur;
                curEven = curEven.next;
                isOdd = true;
            }
            
            cur = cur.next;
        }
        
        curOdd.next = evenHead;
        curEven.next = null;
        return oddHead;
    }
}
