public class Atoi {
    public static void main(String[] args){
        String num= "2147483648";
        Solution.myAtoi(num);
    }
    public static class Solution {
        public static int myAtoi(String str) {
            //空串
            if(str==null||str.length()==0)
                return 0;
            //无效字符串 并处理符号位
            int start = 0, positive = 1;
            while(start<str.length()){
                if(str.charAt(start)==' '){
                    start++;
                    continue;
                }
                if(str.charAt(start)=='-'||str.charAt(start)=='+'){
                    if(start+1>=str.length()||!isNumber(str.charAt(start+1)))
                        return 0;
                    positive = str.charAt(start)=='-'? -1: 1;
                    start++;
                }
                break;
            }

            //计算
            int i=start,ans=0,prev_ans=0;
            while(i<str.length()&&isNumber(str.charAt(i))){
                ans= ans*10+ (str.charAt(i)-'0');
                if((ans-(str.charAt(i)-'0'))/10 != prev_ans)
                    return positive==1? Integer.MAX_VALUE:Integer.MIN_VALUE;
                prev_ans=ans;
                i++;
            }
            if(ans == Integer.MIN_VALUE && positive == -1)
                return positive==1? Integer.MAX_VALUE:Integer.MIN_VALUE;
            return ans * positive;
        }
        public static boolean isNumber(char c){
            if(c>='0'&&c<='9')
                return true;
            return false;
        }
    }
}
