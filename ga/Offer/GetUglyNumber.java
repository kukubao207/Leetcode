package Offer;

//丑数
//把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
public class GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if (index == 0)
            return 0;
        if(index == 1)
            return 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int[] ugly = new int[index];
        ugly[0] = 1;
        int i = 1;
        while(i < index){
            int num = Math.min(Math.min(2 * ugly[index2], 3 * ugly[index3]), 5 * ugly[index5]);
            ugly[i++] = num;
            if(ugly[index2] * 2 == num)
                index2++;
            if(ugly[index3] * 3 == num)
                index3++;
            if(ugly[index5] * 5 == num)
                index5++;
        }
        return ugly[index - 1];
    }
}
