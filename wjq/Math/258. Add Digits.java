258. Add Digits

        Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

        Example:

        Input: 38
        Output: 2
        Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
        Since 2 has only one digit, return it.
        Follow up:
        Could you do it without any loop/recursion in O(1) runtime?

找规律题
 输  入     输 出
   0    ->   0
 1...9  -> 1...9
10...18 -> 1...9
19...27 -> 1...9
...

总结
output = (input - 1) % 9 + 1;
class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}