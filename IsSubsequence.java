//Recursive
class Solution {
    public boolean isSubsequence(String s, String t) {
        return isSubsequenceUtil(s, t);
    }
    
    boolean isSubsequenceUtil(String s, String t) {
        if (s.equals("")) return true;
        if (t.equals("")) return false;
        if (t.charAt(t.length() - 1) == s.charAt(s.length() - 1)) return isSubsequenceUtil(s.substring(0, s.length() - 1), t.substring(0, t.length() - 1));
        else return isSubsequenceUtil(s, t.substring(0, t.length() - 1));
    }
}

//DP
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (t.equals("")) {
            return s.equals("");
        }
        boolean[][] isSub = new boolean[s.length()][t.length()];
        for (int i = 0; i < s.length(); i ++) {
            for (int j = 0; j < t.length(); j ++) {
                if (t.charAt(j) == s.charAt(i)) isSub[i][j] = true;
            }
        }
        int i = s.length() - 1, j = t.length();
        
        while(i >= 0) {
            j --;
            while(j >= 0 && !isSub[i][j]) {
                j --;
            }
            i --;
        }
        
        return j >= 0;
    }
    
    boolean isSubsequenceUtil(String s, String t) {
        if (s.equals("")) return true;
        if (t.equals("")) return false;
        if (t.charAt(t.length() - 1) == s.charAt(s.length() - 1)) return isSubsequenceUtil(s.substring(0, s.length() - 1), t.substring(0, t.length() - 1));
        else return isSubsequenceUtil(s, t.substring(0, t.length() - 1));
    }
}
