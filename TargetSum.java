class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
        }
        if (target > sum || target < -sum) return 0;
        if ((target + sum) % 2 != 0) return 0;
        int N = (target + sum)/2;
        int[][] dp = new int[nums.length + 1][N + 1];
        
        for (int i = 1; i < dp.length; i ++) {
            for (int j = 1; j < dp[0].length; j ++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        int total = 0;
        for (int i = 0; i < dp.length; i ++) {
            if (dp[i][N] == N) total += count(dp, i, N, nums);
        }
        return total;
    }
    
    int count(int[][] dp, int i, int j, int[] nums) {
        if (i == 0) return 1;
        int total = 0;
        int target = j - nums[i - 1];
        if (target < 0) return 0;
        for (int k = 0; k < i; k ++) {
            if (dp[k][target] == target) total += count(dp, k, target, nums);
        }
        
        return total;
    }
}


class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][10000];
        dp[0][2000] = 1;
        for (int i = 1; i <= n; i ++) {
            if (nums[i - 1] == 0 ){
                dp[i][2000] = 1;
            }
        }
        for (int i = 1; i <= n; i ++) {
            for (int t = 1000; t <= 3000; t ++) {
                dp[i][t] = dp[i - 1][t - nums[i - 1]] + dp[i - 1][t + nums[i - 1]];
            }
        }
        
        return dp[n][2000 + target];
    }
}
