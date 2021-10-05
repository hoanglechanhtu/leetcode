class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i ++) {
            Arrays.fill(dp[i], true);
        }
        int max = 1;
        String maxS = s.substring(0, 1);
        for (int l = 2; l <= s.length(); l ++) {
            for (int i = 0; i <= s.length() - l; i ++) {
                if (s.charAt(i) != s.charAt(i + l - 1)) dp[i][i + l - 1] = false;
                else {
                    dp[i][i + l - 1] = dp[i + 1][i + l - 2];
                    if (dp[i][i + l - 1] && l > max) {
                        max = l;
                        maxS = s.substring(i, i + l);
                    }
                }
            }
        }
        
        return maxS;
        
    }
}
