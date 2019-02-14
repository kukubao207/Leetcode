import java.util.*;

public class ConcatenationofAllWords {
    public static void main(String[] args){
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","word"};
        Solution2.findSubstring(s,words);
    }
    public static class Solution {
        public static List<Integer> findSubstring(String s, String[] words) {
            if(s.equals("")||words.length==0)
                return new ArrayList<>();
            Set<String> set = new HashSet<>();
            //1.求出所有字符串的不同拼接 permutation
            List<List<String>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            for(String word:words){
                List<List<String>> temp = new ArrayList<>();
                for(List<String> l:res){
                    for(int i=0;i<=l.size();i++){
                        List<String> t = new ArrayList<>(l);
                        t.add(i,word);
                        temp.add(t);
                    }
                }
                res = temp;
            }
            //2.把它们加入Set中
            for(List<String> l:res){
                StringBuilder sb = new StringBuilder("");
                for(String str:l){
                    sb.append(str);
                }
                set.add(sb.toString());
            }
            List<Integer> result = new ArrayList<>();
            //3.遍历Set，查找下标，加入结果集
            for(String str:set){
                int idx = s.indexOf(str);
                while(idx!=-1){
                    result.add(idx);
                    if(idx+1<s.length())
                        idx = s.indexOf(str,idx+1);
                    else
                        idx=-1;
                }
            }
            return result;
        }
    }

    public static class Solution2 {
        public static List<Integer> findSubstring(String s, String[] words) {
            if(s.equals("")||words.length==0)
                return new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            int num=words.length;
            int wordlen=words[0].length();
            Map<String,Integer> count = new HashMap<>();
            for(String word:words){
                count.put(word,count.getOrDefault(word,0)+1);
            }
            for(int i=0;i<s.length()-num*wordlen+1;i++){
                String substr = s.substring(i,i+num*wordlen);
                Map<String,Integer> map2 = new HashMap<>();
                int j=0;
                while(j<num){
                    String curstr = substr.substring(j*wordlen,(j+1)*wordlen);
                    if(count.containsKey(curstr)){
                        if(count.get(curstr)<map2.getOrDefault(curstr,0))
                            break;
                        map2.put(curstr,map2.getOrDefault(curstr,0)+1);
                    }else{
                        break;
                    }
                    j++;
                }
                if(j==num)
                    result.add(i);
            }

            return result;
        }
    }
}
