class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i ++) {
            set.add(nums[i]);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (set.contains(nums[i])) {
                int left = nums[i] - 1;
                //left side of nums[i]
                while(set.contains(left)) {
                    set.remove(left);
                    left--;
                }
                //right side of nums[i]
                int right = nums[i] + 1;
                while(set.contains(right)) {
                    set.remove(right);
                    right ++;
                }
                
                max = Math.max(max, right - left - 1);
            }
        }
        return max;
    }
}
