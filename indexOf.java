class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        for (int i = 0; i < haystack.length(); i ++) {
            if (isStartWith(haystack, needle, i)) return i;
        }
        return -1;
    }
    
    boolean isStartWith(String haystack, String needle, int offset) {
        if (haystack.length() - offset < needle.length()) return false;
        for (int i = 0; i < needle.length(); i ++) {
            if (haystack.charAt(i + offset) != needle.charAt(i)) return false;
            
        }
        return true;
    }
}
