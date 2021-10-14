class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i ++) {
            if (s.charAt(i) != '0'){
                dp[i][i] = 1;
            }
        }
        
        for (int l = 2; l <= n; l ++) {
            for (int i = 0; i <= n - l; i ++) {
                int j = i + l - 1;
                dp[i][j] = dp[i][i] * dp[i + 1][j];
                if (s.charAt(i) != '0' && Integer.valueOf(s.substring(i, i + 2)) <= 26) dp[i][j] += (i + 2 < n ?  dp[i + 2][j] : 1);
            }
        }
        
        return dp[0][n - 1];
    }
}
