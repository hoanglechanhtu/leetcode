class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[amount + 1][coins.length];
        for (int i = 0; i < dp.length; i ++) {
            Arrays.fill(dp[i], -1);
        }
        Arrays.fill(dp[0], 0);
        for (int i = 1; i < dp.length; i ++) {
            for (int j = 0; j < dp[0].length; j ++) {
                if (i >= coins[j]) {
                    int min = Integer.MAX_VALUE;
                    for (int k = 0; k < dp[0].length; k ++) {
                        if (dp[i - coins[j]][k] != -1) min = Math.min(min, dp[i - coins[j]][k]); 
                    }
                    if (min != Integer.MAX_VALUE) {
                        dp[i][j] = min + 1;
                    }
                }
            }
        }
      
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i ++) {
            if (dp[amount][i] >= 0) {
                min = Math.min(min, dp[amount][i]); 
            }
        }
        
        return min != Integer.MAX_VALUE ? min : -1;
    }
}


class Solution {
 
    public int coinChange(int[] coins, int amount) {
        int[] min = new int[amount + 1];
        Arrays.fill(min, -1);
        min[0] = 0;
        for (int i = 0; i < coins.length; i ++) {
            if (coins[i] < amount + 1) min[coins[i]] = 1;
        }
        for (int i = 1; i < min.length; i ++) {
            int newMin = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j ++) {
                if (i > coins[j] && min[i - coins[j]] != -1) {
                    newMin = Math.min(newMin, min[i - coins[j]] + 1);
                }
            }
            if (newMin != Integer.MAX_VALUE)
                min[i] = min[i] != -1 ? Math.min(min[i], newMin) : newMin;
        }
        return min[amount];
    }
}
