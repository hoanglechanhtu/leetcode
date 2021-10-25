class Solution {
    public int countValidWords(String sentence) {
        int left = 0, right = 0;
        int total = 0;
        while (right < sentence.length()) {
            while(right < sentence.length() && sentence.charAt(right) != ' ') {
                right ++;
            }
            
            String s = sentence.substring(left, right);
            if (isValidWord(s)) total ++;
            
            while (right < sentence.length() && sentence.charAt(right) == ' ') {
                right ++;
            }
            left = right;
        }
        return total;
    }
    
    boolean isValidWord(String s) {
        if (s.equals("") ) return false;
        int n = s.length();
        int nHyphen = 0;
        int nPunc = 0;
        for (int i = 0; i < n; i ++) {
            if (s.charAt(i) == ' ') return false;
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0') return false;
            if (s.charAt(i) == '-') {
                if  (i == 0 || i == n - 1 || nHyphen > 0) return false;
                if (s.charAt(i - 1) < 'a' || s.charAt(i - 1) > 'z' || s.charAt(i + 1) < 'a' || s.charAt(i + 1) > 'z') return false;
                nHyphen ++;
            } 
            if (s.charAt(i) == '.' || s.charAt(i) == '!' || s.charAt(i) == ',') {
                if (nPunc > 0 || i != n - 1) return false;
                nPunc ++;                
            }
        }
        
        return true;
    }
}
