class Solution {
    public void reverseString(char[] s) {
        if (s.length <= 1) return;
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}

class Solution {
    public void reverseString(char[] s) {
        reverse(s, 0);
    }
    
    void reverse(char[] s, int i) {
        if (i < s.length/2) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
            reverse(s, i + 1);
        }
    }
}
