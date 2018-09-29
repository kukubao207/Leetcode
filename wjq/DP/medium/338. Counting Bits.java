Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's
in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]
Example 2:

Input: 5
Output: [0,1,1,2,1,2]
Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)).
But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount
in c++ or in any other language.

我的思路
如何求一个int值num的二进制上有多少个1???
一个while循环就可以做到,num = num & (num-1) 可以将num的二进制上的从右向左的第一个1去掉
int count = 0
while(num!=0){
    num = num & (num-1);
    count++;
}

因此,朴素的思想下,直接一个for循环就可以求出结果数组,显然,这与DP没有关联.
class Solution {
    public int[] countBits(int num) {
        int res[] = new int[num+1];
        for(int i=0; i<=num; i++){
            int temp = i;
            int count = 0;
            while(temp!=0){
                temp = temp & temp - 1;
                count++;
            }
            res[i]=count;
        }
        return res;
    }
}

别人的思路,事实上在草稿纸上运算已经找出了一定的规律,却没有手动去实现下,下回有想法先试试
This uses the hint from the description about using ranges.
Basically, the numbers in one range are equal to 1 plus all of the numbers in the ranges before it.
If you write out the binary numbers, you can see that numbers 8-15 have the same pattern as 0-7 but
with a 1 at the front.
My logic was to copy the previous values (starting at 0) until a power of 2 was hit (new range),
at which point we just reset the t pointer back to 0 to begin the new range.


public int[] countBits(int num) {
    int[] ret = new int[num+1];
    ret[0] = 0;
    int pow = 1;
    for(int i = 1, t = 0; i <= num; i++, t++) {
        if(i == pow) {
            pow *= 2;
            t = 0;
        }
        ret[i] = ret[t] + 1;
    }
    return ret;
}


进阶解法
public int[] countBits(int num) {
    int[] ret = new int[num + 1];
    for (int i=1; i<=num; i++)
        ret[i] = ret[i&(i-1)] + 1;
    return ret;
}

