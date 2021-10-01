class Solution {
    //eaeiou
    //left 1
    //right 1
    //max 
    public int longestBeautifulSubstring(String word) {
        int left = 0;
        int right = 0;
        int max = 0;
        while(right < word.length()) {
            if(checkWord(word, right, left)) {
                if (word.charAt(right) == 'u' && word.charAt(left) == 'a') max = Math.max(max, right - left + 1);
                right ++;
            } else {
                if (left == right) {
                    right ++;
                }
                left = right;
            }
        }
        return max;
    }
    
    boolean checkWord(String s, int right, int left) {
        if (right >= s.length()) return false;
        if (right == left) {
            if (s.charAt(left) == 'a') return true;
            else return false;
        }
        char cur = s.charAt(right - 1);
        char next = s.charAt(right);
        if (cur == 'a' && (next == 'a' || next == 'e')) return true;
        if (cur == 'e' && (next == 'e' || next == 'i')) return true;
        if (cur == 'i' && (next == 'i' || next == 'o')) return true;
        if (cur == 'o' && (next == 'o' || next == 'u')) return true;   
        if (cur == 'u' && next == 'u') return true;
        return false;
    }
}
