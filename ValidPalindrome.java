class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right) {
            while (left < right && !isValidChar(s.charAt(left))) {
                left ++;   
            }
            
            while (right > left && !isValidChar(s.charAt(right))) {
                right --;
            }
            
            char leftChar = normalize(s.charAt(left));
            char rightChar = normalize(s.charAt(right));
            if (leftChar != rightChar) return false;
            left ++;
            right --;
            
        }
        
        return true;
    }
    
    boolean isValidChar(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) return true;
        else return false;
    }
    char normalize(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char)(c - ('A' - 'a'));
        }
        
        return c;
    }
}
