package Exam2020.microsoft;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    public class TrieNode {
        public char val;
        public boolean isWord;  // 根节点到当前节点是不是一个单词
        public TrieNode[] child = new TrieNode[26];

        public TrieNode() {
        }

        TrieNode(char c) {
            TrieNode node = new TrieNode();
            node.val = c;
        }

    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    public void insert(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt((i));
            if (ws.child[c - 'a'] == null) {
                ws.child[c - 'a'] = new TrieNode(c);
            }
            ws = ws.child[c - 'a'];
        }
        ws.isWord = true;
    }

    //1.首先我们要找到这个前缀的最后一个字母在这颗前缀树上的节点 也就是ws
    public List<String> startWith(String prefix) {
        TrieNode ws = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (ws.child[c - 'a'] == null) {
                System.out.println("不存在这个前缀的单词");
                return null;
            }
            ws = ws.child[c - 'a'];
        }
        //2.从ws开始往下深度优先搜索，找到所有单词（isword=true） 保存在res数组里面
        res = new ArrayList<>();
        findWords(ws, "", prefix);
        return res;
    }

    public static List<String> res;

    public void findWords(TrieNode root, String temp, String prefix) {
        if (root == null) {
            return;
        }
        if (root.isWord == true) {
            res.add(prefix + temp);
        }
        for (int i = 0; i < 26; i++) {
            if (root.child[i] != null)
                findWords(root.child[i], temp + ('a' + i), prefix);
        }
    }

}

