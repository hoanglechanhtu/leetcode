class Solution {
    //1 2 1
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = nums.length - 1; i >= 0; i -- ) {
            int cur = nums[i];
            while (queue.size() != 0 && queue.getFirst() <= cur) {
                queue.removeFirst();
            }
            if (queue.size() != 0) {
                res[i] = queue.getFirst();
            }
            queue.addFirst(cur);
        }
        return res;
    }
}
