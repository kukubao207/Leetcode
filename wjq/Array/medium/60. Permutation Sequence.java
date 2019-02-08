60. Permutation Sequence
        The set [1,2,3,...,n] contains a total of n! unique permutations.

        By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

        "123"
        "132"
        "213"
        "231"
        "312"
        "321"
        Given n and k, return the kth permutation sequence.

        Note:

        Given n will be between 1 and 9 inclusive.
        Given k will be between 1 and n! inclusive.
        Example 1:

        Input: n = 3, k = 3
        Output: "213"
        Example 2:

        Input: n = 4, k = 9
        Output: "2314"

题意
求解n的全排列的第k个

我的思路
O（n)
对于 1 2 3 4
n=4，k=17

1 2 3 4
1 2 4 3
1 3 2 4
1 3 4 2
1 4 2 3
1 4 3 2

对于[1,2,3,4]
以1开头的有6个，以2开头的有6个，以3开头的有6个，以4开头的有留6个，
显然我们要找的k=17位于 以3开头的6个中
index = k / (数组元素数量 - 1)! = 17 / 3! = 2
k = k - index * (数组元素数量 - 1)! = 17 - 2 * 3! = 5
从数组[1,2,3,4]中删去下标为2的元素3，把3加入结果字符串res中。

得到数组[1,2,4]
1 2 4
1 4 2
2 1 4
2 4 1
4 1 2
4 2 1
以1开头的有2个，以2开头的有2个，以4开头的有2个
index = k / (数组元素数量 -1)! = 5 / 2! = 2
k = k - index * (数组元素数量 - 1)! = 5 - 2 * 2! = 1
从数组[1,2,4]中删除下标为index(2)的元素4，把4加入结果字符串res中。

得到数组[1,2]
同理
index = 1 / 1! = 1
k= 1 - 1 * 1! = 0
从数组[1,2]中删除下标为1的元素1，把1加入结果字符串res中

得到数组[2]
index = 0/0! = 0
k = 1 - 0 * 0! = 0
从数组[2]中删除下标为0的元素2，把2加入结果字符串res中


class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n+1];
        factorial[0]=1;
        for(int i=1,sum=1;i<=n;i++){
            sum*=i;
            factorial[i]=sum;
        }

        List<Integer> id = new ArrayList<>();
        for(int i=1;i<=n;i++){
            id.add(i);
        }

        String res="";
        k--;
        for(int i=1;i<=n;i++){
            int index = k / factorial[n-i];         //n=4,k=12   ,fac[3]=6
            res+=id.get(index);
            id.remove(index);
            k = k - factorial[n-i] * index;
        }
        return res;
    }

}
