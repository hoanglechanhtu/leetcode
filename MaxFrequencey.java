class Solution {
    public int maxFrequency(int[] nums, int k) {
        if (nums.length <= 1) return nums.length;
        Arrays.sort(nums);
        int max = 0;
        int left = 0;
        int right = 1;
        int total = nums[right] - nums[left];
        while(right < nums.length) {
            if (total <= k) {
                max = Math.max(right - left + 1, max);
                if (right + 1 < nums.length) total = total + (nums[right + 1] - nums[right]) * (right - left + 1);
                right ++;
            } else {
                total = total - (nums[right] - nums[left]);
                left ++;
            }
        }
        
        return max;
    }
}
