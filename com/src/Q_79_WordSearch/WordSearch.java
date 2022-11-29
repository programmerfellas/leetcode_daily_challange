package Q_79_WordSearch;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist2(board,word));
    }



    public static boolean exist(char[][] board, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;

        for (int i = 0; i < ROWS; ++i)
            for (int j = 0; j < COLS; ++j)
                if (backtrack(i, j, word, 0,ROWS,COLS,board))
                    return true;
        return false;
    }

    protected static boolean backtrack(int i, int j, String word, int index,int ROWS,int COLS,char[][] board) {
        /* Step 1). check the bottom case. */
        if (index >= word.length())
            return true;

        /* Step 2). Check the boundaries. */
        if (i < 0 || i == ROWS || j < 0 || j == COLS
                || board[i][j] != word.charAt(index))
            return false;

        /* Step 3). explore the neighbors in DFS */
        boolean ret = false;
        // mark the path before the next exploration
        board[i][j] = '#';

        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int d = 0; d < 4; ++d) {
            ret = backtrack(i + rowOffsets[d],
                    j + colOffsets[d], word, index + 1,ROWS,COLS,board);
            if (ret)
                break;
        }

        /* Step 4). clean up and return the result. */
        board[i][j] = word.charAt(index);
        return ret;
    }


    public static boolean exist2(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (exist(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y < 0 || x < 0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x+1, word, i+1)
                || exist(board, y, x-1, word, i+1)
                || exist(board, y+1, x, word, i+1)
                || exist(board, y-1, x, word, i+1);
        board[y][x] ^= 256;
        return exist;
    }


    public static boolean exist3(char[][] board, String word) {
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++){
                if(exist(board, i, j, word, 0))
                    return true;
            }
        return false;
    }
    private static boolean exist(char[][] board, int i, int j, String word, int ind){
        if(ind == word.length()) return true;

        if(i > board.length-1 || i < 0 || j < 0 || j > board[0].length-1 || board[i][j] != word.charAt(ind))
            return false;

        board[i][j]='*';

        boolean result =    exist(board, i-1, j, word, ind+1) ||
                exist(board, i, j-1, word, ind+1) ||
                exist(board, i, j+1, word, ind+1) ||
                exist(board, i+1, j, word, ind+1);

        board[i][j] = word.charAt(ind); // backtracking
        return result;
    }
}
