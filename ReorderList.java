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
    public void reorderList(ListNode head) {
        if (head.next == null) return;
        ListNode middle = getMiddle(head);
        Deque<ListNode> queue = new ArrayDeque<>();
        while(middle != null) {
            queue.addFirst(middle);
            middle = middle.next;
        }
        ListNode cur = head;
        ListNode pre = head;
        // 1 -> 2
        // 3 -> null
        // 1 -> 4 -> 2 -> 3 -> null
        
        while(queue.size() != 0) {
            ListNode temp = queue.removeFirst();
            if (cur == null) {
                pre.next = temp;
                temp.next = null;
            } else {
                temp.next = cur.next;
                cur.next = temp;
                pre = cur.next;
                cur = cur.next.next;
            }
        }

        
    }
    
    ListNode getMiddle(ListNode head) {
        ListNode preNode = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            preNode = slow;
            slow = slow.next;
        }
        preNode.next = null;
        return slow;
    }
}
