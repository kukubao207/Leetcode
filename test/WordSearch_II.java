import java.util.ArrayList;
import java.util.List;

public class WordSearch_II {
    public static void main(String[] args) {
        char[][] board = {{'a'}};
        String[] words = {"a"};
        findWords(board, words);
    }

    private static class Node {
        Node[] next = new Node[26];
        String str = null;
    }

    public static Node buildTrie(String[] words) {
        Node root = new Node();
        for (String w : words) {
            Node cur = root;
            for (int i = 0; i < w.length(); i++) {
                int idx = w.charAt(i) - 'a';
                if (cur.next[idx] == null)
                    cur.next[idx] = new Node();
                cur = cur.next[idx];
            }
            cur.str = w;
        }
        return root;
    }

    public static void dfs(char[][] board, Node cur, int i, int j, List<String> res) {
        if (cur == null || board[i][j] == '#')
            return;
        char c = board[i][j];
        if (cur.next[c - 'a'].str != null) {
            res.add(cur.str);
            cur.next[c - 'a'].str = null;
        }
        board[i][j] = '#';
        if (i - 1 >= 0)
            dfs(board, cur.next[c - 'a'], i - 1, j, res);
        if (j - 1 >= 0)
            dfs(board, cur.next[c - 'a'], i, j - 1, res);
        if (i + 1 < board.length)
            dfs(board, cur.next[c - 'a'], i + 1, j, res);
        if (j + 1 < board[0].length)
            dfs(board, cur.next[c - 'a'], i, j + 1, res);
        board[i][j] = c;
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Node root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, i, j, res);
            }
        }
        return res;
    }

}
