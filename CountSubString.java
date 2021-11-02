class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i ++){
            Arrays.fill(dp[i], true);
        }
        for (int l = 2; l <= n; l ++) {
            for (int start = 0; start <= n - l; start ++) {
                int end = start + l - 1;
                if (s.charAt(start) == s.charAt(end) && dp[start + 1][end - 1]) {
                    dp[start][end] = true;
                } else {
                    dp[start][end] = false;
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = i; j < n; j ++) {
                if(dp[i][j]) count ++;
            }
        }
        
        return count;
    }
}
