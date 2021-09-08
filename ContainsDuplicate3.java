class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                if (j - i >= k && Math.abs(nums[i] - nums[j]) <= t) return true;
            }
        }
        
        return false;
    }
}
