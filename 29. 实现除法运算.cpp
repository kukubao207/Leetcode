29. 实现除法运算
Divide two integers without using multiplication, division and mod operator.
If it is overflow, return MAX_INT.

my solution:
class Solution {
public:
    int divide(int dividend, int divisor) {
    	//溢出的情况
        if(divisor==0)
        	return INT_MAX;
        if(dividend==INT_MIN&&divisor==-1)
        	return INT_MAX;

        int sign=-1,ans=0;
        if((dividend>0&&divisor>0)||(dividend<0&&divisor<0))
        	sign=1;
        long long did=labs(dividend);
        long long dvd=labs(divisor);
        while(did>=dvd)
        {
        	long long temp1=dvd,temp2=1;
        	while(did>=(temp1<<1))
        	{
        		temp1=temp1<<1;
        		temp2=temp2<<1;
        	}
        	did-=temp1;
        	ans+=temp2;
        }
        return sign==1?ans:-ans;
    }
};

others solution:
class Solution {
public:
    int divide(int dividend, int divisor) {
        if (!divisor || (dividend == INT_MIN && divisor == -1))
            return INT_MAX;
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long long dvd = labs(dividend);
        long long dvs = labs(divisor);
        int res = 0;
        while (dvd >= dvs) {
            long long temp = dvs, multiple = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dvd -= temp;
            res += multiple;
        }
        return sign == 1 ? res : -res;
    }
};

summary:
	1.考虑到溢出的情况：
		·除数为0
		·被除数为INT_MIN且除数为-1
	2. 算法思想：
	除法其实就是要求我们去计算 被除数 由 多少个 除数相加构成，
	意思就是，当被除数>=0时，我们不断地用 被除数-除数，次数
	就是答案。但是因为一次一次地用被除数减去除数效率太慢了，我
	们可以增加 除数 上升的速度，采用左移运算，即每次用被除数
	减去除数时，让除数*2^n次，n每次+1，这样很快就能让被除数-
	除数成为负数。
	举个例子来说，我们用15-3=12，结果为正数。继续减，我们将3
	左移一位，得到6,15-6=9，结果为正数。继续减，我们将3左移两
	位，得到12,15-12=3，结果为正数。继续减，我们将3左移三位，
	得到24，这时候15-24=-9，结果为负，所以我们知道左移两位就
	是极限了，即2^2（1<<2)=4个3。
	这时原数还剩下 15-3*2^2=3 ，>=除数，因此继续对数字3重复
	上述步骤，3-3*2^0=0，<=除数，就得到了答案，只需要左移0次，
	2^0（1<<0）=1个3。
