class Solution {
    public String shortestPalindrome(String s) {
        int index = s.length() - 1;
        while(!isPalindrome(s, 0, index)) {
            index --;
        }
        
        StringBuilder builder = new StringBuilder();
        builder.append(s.substring(index + 1));
        builder.reverse();
        
        return builder.toString() + s;
    }
    
    boolean isPalindrome(String s, int from, int end) {
        for (int i = 0; i < (end - from + 1)/2; i ++) {
            if (s.charAt(from + i) != s.charAt(end - i)) return false;
        }
        
        return true;
    }
}

class Solution {
    public String shortestPalindrome(String s) {
        
        int m = 0;
        for (int n = s.length() - 1; n >= 0; n --) {
            if (s.charAt(m) == s.charAt(n)) {
                m ++;
            }
        }
        

        boolean[][] dp = new boolean[s.length()][s.length()];        
      
        for (int i = 0; i < dp.length; i ++) {
            for (int j = 0; j < dp[0].length; j ++) 
                dp[i][j] = true;
        }
        
        for (int l = 2; l <= m; l ++) {
            for (int i = 0; i <= m - l; i ++) {
                if (s.charAt(i) == s.charAt(i + l - 1) && dp[i + 1][i + l - 2]) dp[i][i + l - 1] = true;
                else dp[i][i + l - 1] = false;
            }
        }
        int index = m - 1;
        while(index >= 0 && !dp[0][index]) {
            index --;
        }
        
        StringBuilder builder = new StringBuilder();
        builder.append(s.substring(index + 1));
        builder.reverse();
        
        return builder.toString() + s;
        
    }
    
    boolean isPalindrome(String s, int from, int end) {
        for (int i = 0; i < (end - from + 1)/2; i ++) {
            if (s.charAt(from + i) != s.charAt(end - i)) return false;
        }
        return true;
    }
        
}

DP
class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        int i = 0;
        for (int j = n - 1; j >= 0; j --) {
            if (s.charAt(i) == s.charAt(j)) i ++;
        }
        
        if (i == n) return s;
        StringBuilder builder = new StringBuilder();
        String remainRev = builder.append(s.substring(i)).reverse().toString();
        
        return remainRev + shortestPalindrome(s.substring(0, i)) + s.substring(i);
        
        
    }
}
