Write an iterator that iterates through a run-length encoded sequence.

The iterator is initialized by RLEIterator(int[] A), where A is a run-length encoding of some sequence.
More specifically, for all even i, A[i] tells us the number of times that the non-negative integer
value A[i+1] is repeated in the sequence.

The iterator supports one function: next(int n), which exhausts the next n elements (n >= 1) and returns
the last element exhausted in this way.  If there is no element left to exhaust, next returns -1 instead.

For example, we start with A = [3,8,0,9,2,5], which is a run-length encoding of the sequence [8,8,8,5,5].
This is because the sequence can be read as "three eights, zero nines, two fives".



Example 1:

Input: ["RLEIterator","next","next","next","next"], [[[3,8,0,9,2,5]],[2],[1],[1],[2]]
Output: [null,8,8,5,-1]
Explanation:
RLEIterator is initialized with RLEIterator([3,8,0,9,2,5]).
This maps to the sequence [8,8,8,5,5].
RLEIterator.next is then called 4 times:

.next(2) exhausts 2 terms of the sequence, returning 8.  The remaining sequence is now [8, 5, 5].

.next(1) exhausts 1 term of the sequence, returning 8.  The remaining sequence is now [5, 5].

.next(1) exhausts 1 term of the sequence, returning 5.  The remaining sequence is now [5].

.next(2) exhausts 2 terms, returning -1.  This is because the first term exhausted was 5,
but the second term did not exist.  Since the last term exhausted does not exist, we return -1.

Note:

0 <= A.length <= 1000
A.length is an even integer.
0 <= A[i] <= 10^9
There are at most 1000 calls to RLEIterator.next(int n) per test case.
Each call to RLEIterator.next(int n) will have 1 <= n <= 10^9.


题意
给定一个数组，偶数位A[i]代表A[i+1]元素的次数，注意次数上限为10^9
例如[3,8,0,9,2,5]，编码后变成 [8,8,8,5,5]
要求实现一个方法next，能够取得当前指针后的第n个元素。

我的思路
由于次数上限为10^9，所以不可能把原数组直接编码展开，会占用过大空间。
只需要针对偶数位维护一个指针cur，针对当前偶数位对应的次数空间维护一个指针p。
这样二级指针就可以表示该数组中所有的位置了。
class RLEIterator {
    int B[];
    int cur,p;
    public RLEIterator(int[] A) {
        B = new int[A.length];
        for(int i=0;i<A.length;i++){
            B[i]=A[i];
        }
        cur=p=0;
    }
    public int next(int n) {
        if(cur >= B.length)
            return -1;
        //如果当前次数空间下，这一次的步长不会超出空间
        if(p + n <= B[cur]){
            p = p + n;
            return B[cur+1];
        }
        //如果当前次数空间下，这一次的步长已经超出空间
        else{
            n -= B[cur]-p;      //先用 步长 减去 走完当前次数空间剩余空间
            p = 0;              //再将 次数空间内部指针 置为0
            cur += 2;           //进入下一个次数空间
            return next(n);     //用剩余步长递归下一个次数空间
        }
    }
}

别人的迭代写法
class RLEIterator {
    int[] A;
    int i, q;
    public RLEIterator(int[] A) {
        this.A = A;
        i = q = 0;
    }
    public int next(int n) {
        while (i < A.length) {
            if (q + n > A[i]) {
                n -= A[i] - q;
                q = 0;
                i += 2;
            } else {
                q += n;
                return A[i+1];
            }
        }

        return -1;
    }
}