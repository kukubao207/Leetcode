package HashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//30. 串联所有单词的子串
//给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
//
//        注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
//
//         
//
//        示例 1：
//
//        输入：
//        s = "barfoothefoobarman",
//        words = ["foo","bar"]
//        输出：[0,9]
//        解释：
//        从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
//        输出的顺序不重要, [9,0] 也是有效答案。
//        示例 2：
//
//        输入：
//        s = "wordgoodgoodgoodbestword",
//        words = ["word","good","best","word"]
//        输出：[]

public class SubstringWithConcatenationOfAllWords {
    //用两个 HashMap 来解决。
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return res;
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;//长度相同的单词
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        //遍历所有子串
        for (int i = 0; i < s.length() - all_len + 1; i++) {
            String tmp = s.substring(i, i + all_len);
            HashMap<String, Integer> tmp_map = new HashMap<>();
            for (int j = 0; j < all_len; j += one_word) {
                String w = tmp.substring(j, j + one_word);
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
            }
            if (map.equals(tmp_map)) res.add(i);
        }
        return res;
    }
}
