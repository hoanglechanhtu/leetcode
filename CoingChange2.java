class Solution {
    public int change(int amount, int[] coins) {
        return getTotalCombine(coins, 0, 0, amount);
    }
    
    int getTotalCombine(int[] coins,int start, int current, int amount) {
        if (current == amount) return 1;
        if (current > amount) return 0;
        int total = 0;
        
        for (int i = start; i < coins.length; i ++) {
            total += getTotalCombine(coins, i, current + coins[i], amount);
        }
        return total;
    }
}

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);
        for (int i = 0; i < coins.length; i ++) {
            dp[coins[i]] = 1;
        }
        
        for (int i = 0; i < dp.length; i ++) {
            int total = 0;
            for (int j = 0; j < coins.length; j ++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != 0) total += dp[i - coins[j]];
            }
            dp[i] += total;
        }
        
        return dp[amount];
    }
    
}



class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount  + 1];
        for (int i = 0; i < dp.length; i ++) {
            Arrays.fill(dp[i], -1);
            
        }
        return getTotalCombine(coins, 0, 0, amount, dp);
    }
    
    int getTotalCombine(int[] coins,int start, int current, int amount, int[][] dp) {
        if (current == amount) return 1;
        if (current > amount) return 0;
        int total = 0;
        if (dp[start][current] != -1) return dp[start][current];
        for (int i = start; i < coins.length; i ++) {
            total += getTotalCombine(coins, i, current + coins[i], amount, dp);
        }
        dp[start][current] = total;
        return total;
    }
}

class Solution {
    public int change(int amount, int[] coins) {
        int []dp = new int[amount + 1];
        dp[0] = 1;
        for(int i = 0;i<coins.length;i++){
            for(int j = coins[i]; j <= amount;j++){
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
