package String;

import java.util.ArrayList;
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
//    public static void main(String[] args) {
//        test();
//    }
//
//    public static void test() {
//        //case 1
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
//        int maxWidth = 16;
//        List<String> output = fullJustify(words, maxWidth);
//        System.out.println(output);
//
//        //case 2
//        String[] words2 = {"What", "must", "be", "acknowledgment", "shall", "be"};
//        int maxWidth2 = 16;
//        List<String> output2 = fullJustify(words2, maxWidth2);
//        System.out.println(output2);
//
//        //case 3
//        String[] words3 = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
//                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
//        int maxWidth3 = 20;
//        List<String> output3 = fullJustify(words3, maxWidth3);
//        System.out.println(output3);
//    }
//
//    public static class Record {
//        int endIdx;
//        int numOfInterval;
//        int numOfSpace;
//
//        Record(int e, int n1, int n2) {
//            endIdx = e;
//            numOfInterval = n1;
//            numOfSpace = n2;
//        }
//    }
//
//    public static List<String> fullJustify(String[] words, int maxWidth) {
//        List<Record> records = new ArrayList<>();       // 一个Record对应一行输出
//        int curSum = 0, numOfInterval = 0;              // curSum统计当前累计的单词长度和，numOfInterval表示当前单词之间至少需要的空格总数
//        for (int i = 0; i < words.length; i++) {
//            if (curSum + words[i].length() + numOfInterval > maxWidth) {
//                records.add(new Record(i - 1, numOfInterval - 1, maxWidth - curSum));
//                numOfInterval = 0;
//                curSum = 0;
//            }
//            curSum += words[i].length();
//            numOfInterval++;
//        }
//
//        List<String> res = new ArrayList<>();
//        int start = 0;
//        for (Record r : records) {
//            String temp = "";
//            List<String> space = ComputeSpace(r);   //计算该行单词之间的空格应该如何存放 需要注意  只有一个单词的特殊情况
//            int space_idx = 0;
//            while (space_idx < space.size()) {
//                temp += words[start];
//                temp += space.get(space_idx);
//                start++;
//                space_idx++;
//            }
//            if (start <= r.endIdx) {
//                temp += words[start];
//                start++;
//            }
//            res.add(temp);
//        }
//        String temp = "";
//
//        records.add(new Record(words.length - 1, numOfInterval - 1, maxWidth - curSum));
//        while (start <= records.get(records.size() - 1).endIdx) {
//            temp += words[start];
//            if (temp.length() < maxWidth)
//                temp += " ";
//            start++;
//        }
//        while (temp.length() < maxWidth)
//            temp += " ";
//        res.add(temp);
//        return res;
//    }
//
//    public static List<String> ComputeSpace(Record r) {
//        List<String> space = new ArrayList<>();
//        if (r.numOfInterval == 0) {
//            String temp = "";
//            for (int j = 0; j < r.numOfSpace; j++)
//                temp += " ";
//            space.add(temp);
//            return space;
//        }
//        int everyone = r.numOfSpace / r.numOfInterval;
//        int addToLeft = r.numOfSpace % r.numOfInterval;
//        for (int i = 0; i < r.numOfInterval; i++) {
//            String temp = i + 1 <= addToLeft ? " " : "";
//            for (int j = 0; j < everyone; j++) {
//                temp += " ";
//            }
//            space.add(temp);
//        }
//        return space;
//    }
}
