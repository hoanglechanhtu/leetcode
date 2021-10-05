class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        Map<Character, Integer> charToIndex = new HashMap<>();
        int left = 0, right = 1;
        charToIndex.put(s.charAt(left), left);
        int max = 0;
        while(right < s.length()) {
            if (charToIndex.containsKey(s.charAt(right))) {
                int newLeft = charToIndex.get(s.charAt(right)) + 1;
               
                for (int i = left; i < newLeft; i ++) {
                    charToIndex.remove(s.charAt(i));
                }
                
                left = newLeft;
            } 
            charToIndex.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
            right ++;
        }
                
        return max;                
    }
}
