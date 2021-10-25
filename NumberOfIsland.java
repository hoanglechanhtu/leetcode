class Solution {
    enum Direction {
        Up(-1, 0),
        Down(1, 0),
        Right(0, 1),
        Left(0, -1);
        int x;
        int y;
        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j] == '1') {
                    Deque<int[]> queue = new ArrayDeque<>();
                    queue.addLast(new int[]{i, j});
                    grid[i][j] = '0';
                    while(!queue.isEmpty()) {
                        int[] cell = queue.removeFirst();
                        List.of(Direction.values()).forEach(dir -> {
                            if (cell[0] + dir.x >= 0 && cell[0] + dir.x < m && cell[1] + dir.y >= 0 && cell[1] + dir.y < n && grid[cell[0] + dir.x][cell[1] + dir.y] == '1') {
                                queue.addLast(new int[]{cell[0] + dir.x, cell[1] + dir.y});
                                grid[cell[0] + dir.x][cell[1] + dir.y] = '0';
                            }
                        });
                    }
                    
                total ++;
                }
                
            }
        }
        return total;
    }
}
