class Solution {
    //C A B D D D A C   /// C B
    public String minWindow(String s, String t) {
        int[] tCount = new int[52];
        int[] subCount = new int[52];
        for (int i = 0; i < t.length(); i ++) {
            update(t.charAt(i), tCount, 1);
        }
        
        int left = 0, right = 0;
        update(s.charAt(left), subCount, 1);

        int min = s.length() + 1;
        int minLeft = left;
        while(left <= right && right < s.length()) {
            if (isMatch(subCount, tCount)) {
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    minLeft = left;
                }
                update(s.charAt(left), subCount, -1);
                left ++;
            } else {
                right ++;
                if (right < s.length()) update(s.charAt(right), subCount, 1);
            }
        }
        
        if (min == s.length() + 1) return "";
        else return s.substring(minLeft, minLeft + min);
    }   
    
    void update(char c, int[] count, int d) {
        if (c < 'a') {
            count[c - 'A'] += d;
        } else {
            count[c - 'a' + 26] += d;
        }
    }
    
    
    boolean isMatch(int[] s, int[] t) {
        for (int i = 0; i < 52; i ++) {
            if (s[i] < t[i]) return false;
        }
        
        return true;
    }
}
