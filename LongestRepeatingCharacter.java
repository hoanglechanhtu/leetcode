//Using map
//And sliding window
//We can build up the solution, to modify the substring to be repeating, let say, from left and right, total = right - left + 1, and the character with
//maximun frequency X and X's frequency is x, so the number of character have to be change is total - x, then if total - x <= k, this string will be eligible.
//Key words: longest, repeating, substring

class Solution {
    public int characterReplacement(String s, int k) {
        //ABAB
        int[] map = new int[26];
        //A -> 2
        //B -> 2
        Arrays.fill(map, 0);
        //left 0
        //right 4 < 4
        int left = 0, right = 0;
        map[s.charAt(left) - 'A'] ++;
        int max = 1;
        while(left <= right && right < s.length()){
            int total = right - left + 1; //4
            int maxFreqCharCount = getMaxFreqCharCount(map); //2
            if (total - maxFreqCharCount <= k) { // 2 <= 2
                max = Math.max(max, total); // 4
                right ++;
                if (right < s.length()) map[s.charAt(right) - 'A'] ++;
            } else {
                map[s.charAt(left) - 'A'] --;
                left ++;
            }
        }
        
        return  max;
        
    }    
    
    int getMaxFreqCharCount(int[] map) {
        int max = 0;
        for (int i = 0; i < map.length; i ++) {
            max = Math.max(max, map[i]);
        }
        
        return max;
    }
}
