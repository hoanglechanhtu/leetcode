class Solution {
    //1 2 1
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] newNums = new int[nums.length * 2];
        for (int i = 0; i < newNums.length; i ++) {
            newNums[i] = nums[i > nums.length - 1 ? i - nums.length : i];
        }
        int[] res = new int[newNums.length];
        Arrays.fill(res, -1);
        for (int i = newNums.length - 1; i >= 0; i -- ) {
            int cur = newNums[i];
            while (queue.size() != 0 && queue.getFirst() <= cur) {
                queue.removeFirst();
            }
            if (queue.size() != 0) {
                res[i] = queue.getFirst();
            }
            queue.addFirst(cur);
        }
        return Arrays.copyOf(res, nums.length);
    }
}
