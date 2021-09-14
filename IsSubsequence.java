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
