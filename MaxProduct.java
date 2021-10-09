class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int N = nums.length;
        
        int[] dp = new int[N];
        for (int i = 0; i < N; i ++) {
            dp[i] = nums[i];
            max = Math.max(max, dp[i]);
        }
        
        for (int l = 2; l <= N; l ++) {
            for (int i = 0; i <= N - l; i ++) {
                dp[i] *= nums[i + l - 1];
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}

class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int maxPrd = nums[0];
        int minPrd = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            int tempMax = maxPrd;
            maxPrd = Math.max(Math.max(maxPrd * nums[i], minPrd * nums[i]), nums[i]);
            minPrd = Math.min(Math.min(tempMax * nums[i], minPrd * nums[i]), nums[i]);
            max = Math.max(max, maxPrd);
        }
        return max;
    }
}
