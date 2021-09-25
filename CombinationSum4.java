
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int N = nums.length;
        int[][] dp = new int[N + 1][target + 1];
        Arrays.fill(dp[0], 0);
        for (int i = 1; i <= N; i ++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= target; j ++) {
            for (int i = 1; i <= N; i ++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[N][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[N][target];
    }
}
