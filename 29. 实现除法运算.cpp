29. ʵ�ֳ�������
Divide two integers without using multiplication, division and mod operator.
If it is overflow, return MAX_INT.

my solution:
class Solution {
public:
    int divide(int dividend, int divisor) {
    	//��������
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
	1.���ǵ�����������
		������Ϊ0
		��������ΪINT_MIN�ҳ���Ϊ-1
	2. �㷨˼�룺
	������ʵ����Ҫ������ȥ���� ������ �� ���ٸ� ������ӹ��ɣ�
	��˼���ǣ���������>=0ʱ�����ǲ��ϵ��� ������-����������
	���Ǵ𰸡�������Ϊһ��һ�ε��ñ�������ȥ����Ч��̫���ˣ���
	�ǿ������� ���� �������ٶȣ������������㣬��ÿ���ñ�����
	��ȥ����ʱ���ó���*2^n�Σ�nÿ��+1�������ܿ�����ñ�����-
	������Ϊ������
	�ٸ�������˵��������15-3=12�����Ϊ�����������������ǽ�3
	����һλ���õ�6,15-6=9�����Ϊ�����������������ǽ�3������
	λ���õ�12,15-12=3�����Ϊ�����������������ǽ�3������λ��
	�õ�24����ʱ��15-24=-9�����Ϊ������������֪��������λ��
	�Ǽ����ˣ���2^2��1<<2)=4��3��
	��ʱԭ����ʣ�� 15-3*2^2=3 ��>=��������˼���������3�ظ�
	�������裬3-3*2^0=0��<=�������͵õ��˴𰸣�ֻ��Ҫ����0�Σ�
	2^0��1<<0��=1��3��
