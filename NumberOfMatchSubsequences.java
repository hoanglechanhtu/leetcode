class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int total = 0;
        Map<String, Boolean> map = new HashMap<>();
        
        for (int i = 0; i < words.length; i ++) {
            if (map.containsKey(words[i])) total += map.get(words[i]) ? 1 : 0;
            else {
                if(isSubsequence(words[i], s)) {
                    map.put(words[i], true);
                    total ++;
                } else {
                    map.put(words[i], false);
                }
            }
        }
        
        return total;
    }
    
    boolean isSubsequence(String s, String t) {
        int sl = s.length(), tl = t.length();
        
        if (tl == 0) {
            return sl == 0;
        }
        
        int k = 0;
        for (int i = 0; i < t.length(); i ++) {
            if (s.charAt(k) == t.charAt(i)) {
                k ++;
                if (k == sl) return true;
            }
        }
        
        return false;
    }
}
