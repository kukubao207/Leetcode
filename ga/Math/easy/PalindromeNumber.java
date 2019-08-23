package Math.easy;
//9. Palindrome Number
//Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
//
//Example 1:
//
//Input: 121
//Output: true
//Example 2:
//
//Input: -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
//Example 3:
//
//Input: 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
//Follow up:
//
//Coud you solve it without converting the integer to a string?
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        else if(x == 0)
            return true;
        else{
            String str = String.valueOf(x);
            int i = 0;
            int j = str.length() - 1;
            while(i <= j){
                if(str.charAt(i) == str.charAt(j)){
                    i++;
                    j--;
                }else
                    return false;
            }
        }
        return true;
    }
}
