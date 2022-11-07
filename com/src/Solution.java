import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(new Solution().findWords(board,words));
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String currWord : words) {
            TrieNode curr = root;
            for (int i = 0; i < currWord.length(); ++i) {
                curr.children.putIfAbsent(currWord.charAt(i), new TrieNode());
                curr = curr.children.get(currWord.charAt(i));
            }
            curr.endOfWord = true;
        }

        List<String> result = new ArrayList<>();
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // Up, right, down, left.
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                dfs(result, new StringBuilder(), dirs, board, i, j, root);
            }
        }
        return result;
    }

    private void dfs(List<String> result, StringBuilder currPrefix, int[][] dirs, char[][] board, int row, int col, TrieNode currNode) {
        if (!currNode.children.containsKey(board[row][col])) return;

        currNode = currNode.children.get(board[row][col]);
        currPrefix.append(board[row][col]);
        char orig = board[row][col];
        board[row][col] = '#';

        if (currNode.endOfWord) {
            result.add(currPrefix.toString());
            currNode.endOfWord = false;
        }

        for (int[] currDir : dirs) {
            int newRow = row + currDir[0], newCol = col + currDir[1];
            if (0 <= newRow && newRow < board.length && 0 <= newCol && newCol < board[0].length && board[newRow][newCol] != '#') {
                dfs(result, currPrefix, dirs, board, newRow, newCol, currNode);
            }
        }

        currPrefix.setLength(currPrefix.length() - 1);   // Backtrack.
        board[row][col] = orig;
    }

    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }
}
