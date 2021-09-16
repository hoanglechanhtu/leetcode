class Solution {
    public char findTheDifference(String s, String t) {
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            charCount[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < t.length(); i ++) {
            int count = -- charCount[t.charAt(i) - 'a'];
            if (count  < 0) return t.charAt(i);
        }
        
        return 'n';
    }
}
