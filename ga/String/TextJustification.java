package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//68. Text Justification
//Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
//
//You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
//
//Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
//
//For the last line of text, it should be left justified and no extra space is inserted between words.
//
//Note:
//
//A word is defined as a character sequence consisting of non-space characters only.
//Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
//The input array words contains at least one word.
//Example 1:
//
//Input:
//words = ["This", "is", "an", "example", "of", "text", "justification."]
//maxWidth = 16
//Output:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
//Example 2:
//
//Input:
//words = ["What","must","be","acknowledgment","shall","be"]
//maxWidth = 16
//Output:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//Explanation: Note that the last line is "shall be    " instead of "shall     be",
//             because the last line must be left-justified instead of fully-justified.
//             Note that the second line is also left-justified becase it contains only one word.
//Example 3:
//
//Input:
//words = ["Science","is","what","we","understand","well","enough","to","explain",
//         "to","a","computer.","Art","is","everything","else","we","do"]
//maxWidth = 20
//Output:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//]
//Accepted
//102,042
//Submissions
//426,812
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int index = 0;//记录一行的开始
        while(index < words.length){
            int cur = index;
            int len = 0;
            // len + words[cur].length() + cur - index 为单词之间取 一个空格的长度
            while(cur < words.length && len + words[cur].length() + cur - index <= maxWidth){
                // 计算纯单词长度
                len = len + words[cur++].length();
            }
            cur--;
            StringBuilder sb = new StringBuilder();
            // 区分最后一行
            if(cur == words.length - 1){
                for(int i = index; i <= cur; i++){
                    sb.append(words[i]);
                    if(i < cur)
                        sb.append(" ");
                }
            }else{
                int base = cur > index ? (maxWidth - len) / (cur - index) : maxWidth - len;
                String baseStr = genSpace(base);
                int left = cur > index ? (maxWidth - len) % (cur - index) : 0;
                String leftStr = genSpace(base + 1);
                for(int i = index; i <= cur; i++){
                    sb.append(words[i]);
                    if(i < cur){
                        sb.append(left > 0 ? leftStr : baseStr);
                        left--;
                    }
                }
            }
            if(sb.length() < maxWidth){//最后一行填充不够用空格填充
                sb.append(genSpace(maxWidth - sb.length()));
            }
            res.add(sb.toString());
            index = cur + 1;
        }
        return res;
    }
    private String genSpace(int n){
        char[] cs = new char[n];
        Arrays.fill(cs, ' ');
        return new String(cs);
    }

}
