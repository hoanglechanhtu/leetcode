class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = -1;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        
        while(right < s.length()){
            if (getCount(map) <= k) {
                max = Math.max(max, right - left + 1);
                right ++;
                if (right < s.length()) map.merge(s.charAt(right), 1, Integer::sum);
            } else {
                map.merge(s.charAt(left), -1, Integer::sum);
                left ++;
            }
        }
        return max;
    }
    
    int getCount(Map<Character, Integer> map) {
        int total = 0;
        int max = 0;
        for (int val : map.values()) {
            total += val;
            max = Math.max(max, val);
        }
        
        return total - max;
    }
}
