class Solution {
     enum Direction{
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
    public boolean placeWordInCrossword(char[][] board, String word) {
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (check(i, j, board, word)) return true;
            }
        }
        
        return false;
    }
    
    boolean check(int px, int py, char[][] board, String word) {
        for (Direction dir : Direction.values()) {
            if (checkUtil(px, py, board, dir, word)) return true;
        }
        return false;
    }
    
    
    boolean checkUtil(int px, int py, char[][] board, Direction dir, String word) {
        if (!(px - dir.x < 0 || px - dir.x >= board.length || py - dir.y < 0 || py - dir.y >= board[0].length || board[px - dir.x][py - dir.y] == '#')) return false;
        for (int i = 0; i < word.length(); i ++) {
            if (px >= 0 && py >= 0 && px < board.length && py < board[0].length && (board[px][py] == word.charAt(i) || board[px][py] == ' ')) {
                px = px + dir.x;
                py = py + dir.y;
            } else {
                return false;
            }
        }
        
        return px < 0 || px >= board.length || py < 0 || py >= board[0].length || board[px][py] == '#';
    }
}
