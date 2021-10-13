class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i ++) {
            Arrays.fill(dp[i], - 1);
        }
        return count(0, 0, m - 1, n - 1, dp);
    }
    
    int count(int posX, int posY, int maxX, int maxY, int[][] dp) {
        if (posX > maxX || posY > maxY) return 0;
        if (posX == maxX && posY == maxY) return 1;
        if (dp[posX][posY] != -1) return dp[posX][posY];
        int moveRight = count(posX, posY + 1, maxX, maxY, dp);
        int moveDown = count(posX + 1, posY, maxX, maxY, dp);
        dp[posX][posY] = moveRight + moveDown;
        return moveRight + moveDown;
    }
}
