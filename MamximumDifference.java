class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        max[n - 1] = nums[n - 1];
        int[] min = new int[n];
        min[0] = nums[0];
        for (int i = 1; i < n; i ++) {
            min[i] = Math.min(min[i - 1], nums[i]);
            max[n - i - 1] = Math.max(max[n - i], nums[n - i  - 1]);
        }
        
        int res = 0;
        for (int i = 0; i < n; i ++) {
            res = Math.max(res, max[i] - min[i]);
        }
        
        if (res <= 0) return -1;
        else return res;
    }
}
