package design.medium;

class TicTacToe {
    int[][] board; //this is added to only show game state, not use in the solution otherwise
    int[] rows;
    int[] cols;
    int diag;
    int antiDiag;
    int size;

    public TicTacToe(int n) {
        size = n;
        board = new int[n][n];
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;
        int current = player == 1 ? 1 : -1;
        rows[row] += current;
        cols[col] += current;
        if(row==col) {
            diag += current;
        }
        if(col == (size - row - 1)) {
            antiDiag += current;
        }

        if(Math.abs(rows[row]) == size ||
                Math.abs(cols[col]) == size ||
                Math.abs(diag) == size ||
                Math.abs(antiDiag) == size) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
