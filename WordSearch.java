
    class Solution {
        
        enum Move{
            Down(1, 0),
            Up(-1, 0),
            Right(0, 1),
            Left(0, -1);
            int x;
            int y;
            Move(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        public boolean exist(char[][] board, String word) {
            
            
            for (int i = 0; i < board.length; i ++) {
                for (int j = 0; j < board[0].length; j ++) {
                    if (backtracking(0, i, j, word, board, new boolean[board.length][board[0].length])) return true;
                }
            }
            return false;
        }
        
        boolean backtracking(int index, int posX, int posY, String word, char[][] board, boolean[][] isVisited) {
            if (index == word.length()) return true;
            if (posX < 0 || posX >= board.length || posY < 0 || posY >= board[0].length) return false;
            if (isVisited[posX][posY]) return false;
            isVisited[posX][posY] = true;
            
            boolean res = false;
            
            for(Move move : Move.values()) {
                if (word.charAt(index) == board[posX][posY]) res = res || backtracking(index + 1, posX + move.x, posY + move.y, word, board, isVisited);
            }
            
            
            isVisited[posX][posY] = false;
            return res;
        }
    }
