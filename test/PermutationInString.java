import java.util.ArrayList;
import java.util.List;

public class PermutationInString {
    public static void main(String[] args){
        String s1="ab";
        String s2="eidbaooo";
        checkInclusion(s1,s2);
    }
    public static boolean checkInclusion(String s1, String s2) {
        char[] ch = s1.toCharArray();
        List<String> res = new ArrayList<>();
        res.add(new String(""));
        for(char c:ch){
            List<String> temp = new ArrayList<>();
            for(String str:res){
                for(int j=0;j<=str.length();j++){
                    String new_s = insert_into_i(str,j,c);
                    temp.add(new_s);
                }
            }
            res=temp;
        }

        for(String str:res){
            if(s2.contains(str))
                return true;
        }
        return false;
    }
    public static String insert_into_i(String str,int i,char c){
        if(i==0)
            return c+str;
        else if(i==str.length())
            return str+c;
        else
            return str.substring(0,i)+c+str.substring(i);
    }
}
