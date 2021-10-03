class Solution {
    public int minimumMoves(String s) {
        int start = 0;
        int nMove = 0;
        while (start < s.length()) {
            if(s.charAt(start) == 'X') {
                nMove ++;
                start = start + 3;
            } else {
                start ++;
            }
        }
        return nMove;
    }
}
