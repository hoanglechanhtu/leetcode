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

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        int nCenter = 2 * s.length() - 1;
        int max = 1;
        String maxS = s.substring(0, 1);
        for (int i = 0; i < nCenter; i ++) {
            int left = 0, right = 0;
            if (i % 2 == 0) {
                left = (i / 2) - 1;
                right = (i / 2) + 1;
                
            } else {
                left = i / 2;
                right = (i / 2) + 1;
            }
            
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left --;
                right ++;
            }
            
            if (right - 1 - (left + 1) + 1 > max) {
                max = right - 1 - (left + 1) + 1;
                maxS = s.substring(left + 1, right);
            }
        }
        
        return maxS;
    }
}
