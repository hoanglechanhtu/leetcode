class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        int index = 0;
        while (isCommon(strs, index)) {
            index ++;
        } 
        return strs[0].substring(0, index);
    }
    
    boolean isCommon(String[] strs, int index) {
        for (int i = 0; i < strs.length; i ++) {
            if (index >= strs[i].length() || strs[i].charAt(index) != strs[0].charAt(index)) return false;
        }
        return true;
    }
}
