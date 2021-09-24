    class Solution {
        public int integerBreak(int n) {
            int[][] dp = new int[n][n + 1];
            Arrays.fill(dp[0], 1);
            for (int i = 1; i < n; i ++) {
                for (int j = 0; j <= n; j ++) {
                    if (j >= i) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - i] * i);
                    } else{
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            return dp[n - 1][n];
        }
    }
