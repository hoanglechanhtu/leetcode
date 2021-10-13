class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        dp[n - 1] = 1;
        if (n >= 2) dp[n - 2] = 2;
        for (int i = n - 3; i >= 0; i --) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }
        
        return dp[0];
    }
}
