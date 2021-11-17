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
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i ++) {
            set.add(nums[i]);
        }
        ListNode cur = head;
        boolean isComponent = false;
        int nComponents = 0;
        while(cur != null) {
            if (set.contains(cur.val)) {
                isComponent = true;
            } else {
                if (isComponent) {
                    nComponents ++;
                }
                isComponent = false;
            }
            cur = cur.next;
        }
        
        if (isComponent) nComponents ++;
        return nComponents;
    }
}
