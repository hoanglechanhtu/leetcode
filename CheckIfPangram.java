class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] map = new int[26];
        for (int i = 0; i < sentence.length(); i ++) {
            map[sentence.charAt(i) - 'a'] ++;
        }
        
        for (int i = 0; i < 26; i ++) {
            if (map[i] == 0) return false;
        }
        
        return true;
    }
}
