class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i < n + 1; i ++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        
        int total = preSum[n];
        for (int i = 0; i < n; i ++) {
            if (preSum[i] == total - preSum[i + 1]) return i;
        }
        
        return -1;
    }
}
