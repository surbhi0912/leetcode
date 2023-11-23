public class Solution {
    private void dfs(char[][] board, int i, int j) {
        // Base cases for recursion
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '.') {
            return;
        }

        // Mark the cell as visited
        board[i][j] = '.';

        // Recursively explore the neighbors (up, down, left, right)
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
    public int countBattleships(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return 0;
        }

        int n = board[0].length;
        int count = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'X') {
                    count++;  // Found a battleship, increment count
                    dfs(board, i, j);  // Recursively explore the battleship
                }
            }
        }

        return count;
    }
}