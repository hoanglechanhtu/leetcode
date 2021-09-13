class Solution {
    public int firstUniqChar(String s) {
        int[] index = new int[26];
        Arrays.fill(index, -1);
        for (int i = 0; i < s.length(); i ++) {
            if (index[s.charAt(i) - 'a'] == -1) index[s.charAt(i) - 'a'] = i;
            else index[s.charAt(i) - 'a'] = -2;
        }
        int min = s.length();
        for (int i = 0; i < 26; i ++) {
            if (index[i] != -1 && index[i] != -2) min = Math.min(min, index[i]);
        }
        if (min == s.length()) return -1;
        else return min;
    }
}
