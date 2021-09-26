class Solution {
    
    public long gridGame(int[][] grid) {
        int N = grid[0].length;
        long[] sumUp = new long[N];
        sumUp[N - 1] = grid[0][N - 1];
        long[] sumDown = new long[N];
        sumDown[0] = grid[1][0];
        for (int i = 1; i < N; i ++) {
            sumDown[i] = sumDown[i - 1] + grid[1][i];
            sumUp[N - i - 1] = sumUp[N - i] + grid[0][N - i - 1];
        }
        
        long min = Math.max(sumDown[N - 1], sumUp[0]);
        for (int i = 0; i < N; i ++) {
            long up = i + 1 < N ? sumUp[i + 1] : 0;
            long down = i - 1 >= 0 ? sumDown[i - 1] : 0;
            long max = Math.max(up, down);
            min = Math.min(max, min);
        }
        return min;
    }
    
 
}
