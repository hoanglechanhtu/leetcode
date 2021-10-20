class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return backtracking(s, 0, wordDict, dp);   
    }
    
    boolean backtracking(String s, int index, List<String> wordDict, int[] dp) {
        int length = s.length();
        if (index == length) return true;
        if (index > length) return false;
        
        if (dp[index] != -1) return dp[index] == 1;
    
        boolean result = false;
        for(String word: wordDict) {
            if (length - index >= word.length() && s.substring(index).startsWith(word)) {
                result = result || backtracking(s, index + word.length(), wordDict, dp);
            }
        }
        dp[index] = result ? 1 : 0;
        return result;
    }
}
