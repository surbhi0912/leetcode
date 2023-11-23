public class Solution {
    private void dfs(char[][] board, int row, int col) {
        // Base cases for recursion
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '.') {
            return;
        }

        // Mark the cell as visited
        board[row][col] = '.';

        // Recursively explore the neighbors (up, down, left, right)
        dfs(board, row - 1, col);
        dfs(board, row + 1, col);
        dfs(board, row, col - 1);
        dfs(board, row, col + 1);
    }
    public int countBattleships(char[][] board) {
        int rowSize = board.length;
        int colSize = board[0].length;
        int numBattleships = 0;

        for (int row = 0; row < rowSize; ++row) {
            for (int col = 0; col < colSize; ++col) {
                if (board[row][col] == 'X') {
                    numBattleships++;  // Found a battleship, increment count
                    dfs(board, row, col);  // Recursively explore the battleship
                }
            }
        }

        return numBattleships;
    }
}