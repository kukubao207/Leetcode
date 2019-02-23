125. Valid Palindrome

        Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

        Note: For the purpose of this problem, we define empty string as valid palindrome.

        Example 1:

        Input: "A man, a plan, a canal: Panama"
        Output: true
        Example 2:

        Input: "race a car"
        Output: false

class Solution {
    public boolean isPalindrome(String s) {
        if(s==null||s.equals(""))
            return true;
        int left=0,right=s.length()-1;
        String sb = s.toLowerCase();
        while(left<right){
            while(left<sb.length()&&left<right){
                if(isValid(sb.charAt(left)))
                    break;
                left++;
            }
            while(right>=0&&right>left){
                if(isValid(sb.charAt(right)))
                    break;
                right--;
            }
            if(sb.charAt(left)!=sb.charAt(right))
                return false;
            else{
                left++;
                right--;
            }
        }
        return true;
    }
    public boolean isValid(char c){
        if(c>='a'&&c<='z'||(c>='0'&&c<='9'))
            return true;
        return false;
    }
}