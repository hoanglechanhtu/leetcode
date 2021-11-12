class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        for (int length = 1; length <= n; length ++) {
            for (int start = 0; start <= n - length; start ++) {
                int end = start + length - 1;
              
                for (int k = start; k <= end; k ++) {
                    int left = (k == start) ? 0 : dp[start][k - 1];
                    int right = (k == end) ? 0 : dp[k + 1][end];
                    int val = (start == 0 ? 1 : nums[start - 1]) * nums[k] *  (end == n - 1 ? 1 : nums[end + 1]);
                    dp[start][end] = Math.max(dp[start][end], left + right + val);
                }
            }
        }
        
        return dp[0][n - 1];
    }
}
