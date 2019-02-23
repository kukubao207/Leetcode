public class ValidPalindrome {
    public static void main(String[] args){
        String a = "0P";
        boolean flag = Solution.isPalindrome(a);
        System.out.println(flag);
    }
    public static class Solution {
        public static boolean isPalindrome(String s) {
            if(s==null||s.equals(""))
                return true;
            int left=0,right=s.length()-1;
            s=s.toLowerCase();
            while(left<right){
                while(left<s.length()&&left<right){
                    if(s.charAt(left)>='a'&&s.charAt(left)<='z')
                        break;
                    left++;
                }
                while(right>=0&&right>left){
                    if(s.charAt(right)>='a'&&s.charAt(right)<='z')
                        break;
                    right--;
                }
                if(s.charAt(left)==s.charAt(right)){
                    left++;
                    right--;
                }else{
                    return false;
                }
            }
            return true;
        }
    }
}
