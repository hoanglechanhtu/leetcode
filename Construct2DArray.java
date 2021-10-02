class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) return new int[0][0];
        int[][] twoDArray = new int[m][n];
        for (int i = 0; i < original.length; i ++) {
            int k = i / n;
            int h = i % n;
            twoDArray[k][h] = original[i];
        }
        return twoDArray;
    }
}
