import java.util.Arrays;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, 0, i, j)) {
                        return true;
                    }
                } // end if
            } // end j
        } // end i
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int r, int c) {
        // base case : a. r >= row, c>=col; b. board[r][c] == word.charAt(index) ->
        // false
        if (index == word.length()) {
            return true;
        }
        int row = board.length;
        int col = board[0].length;
        if (r < 0 || r >= row || c < 0 || c >= col || board[r][c] != word.charAt(index)) {
            return false;
        }

        // b. index == word.length(), return true;
        char tmp = board[r][c];
        board[r][c] = '*';
        boolean rst = dfs(board, word, index + 1, r - 1, c) || dfs(board, word, index + 1, r + 1, c)
                || dfs(board, word, index + 1, r, c - 1) || dfs(board, word, index + 1, r, c + 1);
        board[r][c] = tmp;
        return rst;
    }

    public static void main(String[] args) {
        WordSearch sol = new WordSearch();
        char[][] board;
        String word;
        boolean res;

        board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        word = "ABCCED";
        res = sol.exist(board, word);
        System.out.println("Input : " + word);
        System.out.println("Input matrix : " + Arrays.deepToString(board));
        System.out.println("Output : " + res);
    }
}
