137. Single Number II

        Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

        Note:

        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

        Example 1:

        Input: [2,2,3,2]
        Output: 3
        Example 2:

        Input: [0,1,0,1,0,1,99]
        Output: 99

思路
对于Single Number I问题
是求一个数组中，所有元素都出现2次，只有1一个元素出现一次，找那个元素
这个问题通过异或来解决问题
利用的特性是
两个相同的数异或为0
0异或一个数为该数本身
也就是说，对于出现两次的元素，迟早会变成0
最后相当于，0异或那个出现一次的元素  = 那个出现一次的元素


对于该问题
我们也希望能够找到一种方式
使得一个数  做某种运算 3次 能回到本身
同时这种运算必须满足交换律和结合律

大佬设计了下面这个算法

数组为[2,2,2,3]，一共有四个元素，进行四次循环。
第一次循环，b=(0000^0010)&1111=0010=2，a=(0000^0010)&1101=0000=0
第二次循环，b=(0010^0010)&1111=0000=0，a=(0000^0010)&1111=0010=2
第三次循环，b=(0000^0010)&1101=0000=0，a=(0010^0010)&1111=0000=0
第四次循环，b=(0000^0011)&1111=0011=3，a=(0000^0011)&1100=0000=0

class Solution {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; ++i)
        {
            b = (b ^ nums[i]) & ~a;
            a = (a ^ nums[i]) & ~b;
        }
        return b;
    }
}

//2 2 3 2
//3

