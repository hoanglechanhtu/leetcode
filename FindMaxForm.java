class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        int[][] charCount = new int[strs.length][2];
        Arrays.sort(strs, Comparator.comparing(s -> s.length()));
        for (int i = 0; i < charCount.length; i ++){
            charCount[i][0] = count(strs[i], 0);
            charCount[i][1] = count(strs[i], 1);
        }
        
        for (int i = 1; i < dp.length; i ++) {
            for (int j = 0; j < dp[0].length; j ++) {
                for (int k = 0; k < dp[0][0].length; k ++) {
                    if (j >= charCount[i - 1][0] && k >= charCount[i - 1][1]) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - charCount[i - 1][0]][k - charCount[i - 1][1]] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        
        return dp[strs.length][m][n];
    }
    
    int count(String s, int value) {
        int total = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == value + '0') total ++;
        }
        return total;
    }
}
