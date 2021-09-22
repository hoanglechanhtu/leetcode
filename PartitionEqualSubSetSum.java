class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        int[][] dp = new int[nums.length + 1][(sum/2) + 1];
        
        for (int i = 1; i < dp.length; i ++) {
            for (int j = 1; j < dp[0].length; j ++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        for (int i = 0; i < dp.length; i ++) {
            if (dp[i][sum/2] == sum/2) return true;
        }
        
        return false;
    }
}
