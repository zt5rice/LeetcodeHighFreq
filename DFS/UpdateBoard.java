public class UpdateBoard {
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = board.length, col = board[0].length;
        int r = click[0], c = click[1];

        if (board[r][c] == 'M') {
            board[r][c] = 'X';
        } else {
            // check the around M of r,c        
            int count = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    int rc = r + i, cc = c + j;
                    if (rc < 0 || rc >= row || cc < 0 || cc >= col) {
                        continue;
                    }
                    if (board[rc][cc] == 'M' || board[rc][cc] == 'X') {
                        count++;
                    }
                }
            }
            
            if (count > 0) {
                board[r][c] = (char) ('0' + count);    
            } else { // continue DFS to find adjacent E
                board[r][c] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        int rc = r + i, cc = c + j;
                        if (rc < 0 || rc >= row || cc < 0 || cc >= col) {
                            continue;
                        }
                        if (board[rc][cc] == 'E') {
                            updateBoard(board, new int[]{rc, cc});
                        }
                    }
                }
            }
        }            
        return board;
    }
}
/*abstract

You are given an m x n char matrix board representing the game board where:

'M' represents an unrevealed mine,
'E' represents an unrevealed empty square,
'B' represents a revealed blank square that has no adjacent mines (i.e., above, below, left, right, and all 4 diagonals),
digit ('1' to '8') represents how many mines are adjacent to this revealed square, and
'X' represents a revealed mine.
You are also given an integer array click where click = [clickr, clickc] represents the next click position among all the unrevealed squares ('M' or 'E').

Return the board after revealing this position according to the following rules:

If a mine 'M' is revealed, then the game is over. You should change it to 'X'.
If an empty square 'E' with no adjacent mines is revealed, then change it to a revealed blank 'B' and all of its adjacent unrevealed squares should be revealed recursively.
If an empty square 'E' with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
Return the board when no more squares will be revealed.

Input: board = [["E","E","E","E","E"],["E","E","M","E","E"],["E","E","E","E","E"],["E","E","E","E","E"]], click = [3,0]
Output: [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]

Input: board = [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]], click = [1,2]
Output: [["B","1","E","1","B"],["B","1","X","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]
*/
