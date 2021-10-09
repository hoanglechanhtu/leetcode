

    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            spiralOrder(matrix);
            return matrix;
        }

        enum Move {
            RIGHT(0, 1),
            DOWN(1, 0),
            LEFT(0, -1),
            UP(-1, 0),
            NONE(0,0);
            int x;
            int y;
            Move(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        class Position {
            public Position(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public int x;
            public int y;
        }

        public void spiralOrder(int[][] matrix) {
            if (matrix.length == 0) return;
            Move curMove = Move.RIGHT;
            Move nextMove = Move.RIGHT;
            Position pos = new Position(0, 0);
            Position min = new Position(0, 0);
            Position max = new Position(matrix.length - 1, matrix[0].length - 1);
            int value = 1;
        
            while (nextMove != Move.NONE) {
                matrix[pos.x][pos.y] = value;
                value ++;
                nextMove = findNextMove(pos, min, max, curMove);
                move(pos, nextMove);
                adjustBound(min, max, curMove, nextMove);
                curMove = nextMove;
            }

        }

        public Move findNextMove(Position pos, Position min, Position max, Move currMove) {
            if (currMove == Move.RIGHT && pos.y < max.y) return Move.RIGHT;
            if (currMove == Move.RIGHT && pos.x < max.x) return Move.DOWN;
            if (currMove == Move.DOWN && pos.x < max.x) return Move.DOWN;
            if (currMove == Move.DOWN && pos.y > min.y) return Move.LEFT;
            if (currMove == Move.LEFT && pos.y > min.y) return Move.LEFT;
            if (currMove == Move.LEFT && pos.x > min.x) return Move.UP;
            if (currMove == Move.UP && pos.x > min.x) return Move.UP;
            if (currMove == Move.UP && pos.y < max.y) return Move.RIGHT;
            return Move.NONE;
        }


        public void move(Position pos, Move move) {
            pos.x += move.x;
            pos.y += move.y;
        }

        public void adjustBound(Position min, Position max, Move curMove, Move nextMove) {
            if (curMove == Move.RIGHT && nextMove == Move.DOWN) {
                min.x += 1;
            } else if (curMove == Move.DOWN && nextMove == Move.LEFT) {
                max.y -= 1;
            } else if (curMove == Move.LEFT && nextMove == Move.UP) {
                max.x -= 1;
            } else if (curMove == Move.UP && nextMove == Move.RIGHT) {
                min.y += 1;
            }
        }
    }
