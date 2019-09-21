package Offer;
//整数中1出现的次数
//求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
public class Count1InInteger {
    public int NumberOf1Between1AndN_Solution(int n) {
        int digit = 1;
        int left = n / digit;
        int right = n % digit;
        int count = 0;
        while(left != 0){
            int num = left % 10;
            if(num == 0){
                count += (left / 10) * digit;
            }else if(num == 1){
                count += (left / 10) * digit + right + 1;
            }else{
                count += (left / 10 + 1) * digit;
            }
            digit *= 10;
            left = n / digit;
            right = n % digit;
        }
        return count;
    }
}
