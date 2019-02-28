import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringM {
    public static void main(String[] args){
        String s = "AAAAAAAAAAA";
        Solution.findRepeatedDnaSequences(s);
    }
    public static class Solution {
        private static int window = 10;
        public static List<String> findRepeatedDnaSequences(String s) {
            Map<String,Integer> map = new HashMap<>();
            List<String> res = new ArrayList<>();
            for(int i=0;i<s.length()-window;i++){
                String str = s.substring(i,i+window);
                int str_count = map.getOrDefault(str,0);
                if(str_count==1){
                    res.add(str);
                }else{
                    map.put(str,str_count+1);
                }
            }
            return res;
        }
    }
}
