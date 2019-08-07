package Exam.wy;


import java.util.Scanner;

//牛牛以前在老师那里得到了一个正整数数对(x, y), 牛牛忘记他们具体是多少了。
//但是牛牛记得老师告诉过他x和y均不大于n, 并且x除以y的余数大于等于k。
//牛牛希望你能帮他计算一共有多少个可能的数对。
public class exam1 {
    //1.暴力超时
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int pairs = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i % j >= k)
                    pairs++;
            }
        }
        System.out.println(pairs);
    }
    //2.要求x%y>=k，则y一定是要大于k的，y的取值范围为(k,n]
    // y确定时，然后看看可能的x有哪些。（核心）
    // 首先想，从1到n闭区间的范围内，可以划分为若干的段，比如[1,y] [y+1,2y] [2y+1,3y]……[my+1,n]
    //每个长度为y的段中，都有k个数（[my+1,my+k)）(加上my)除以y的余数是小于k的，则这一段中余数大于等于k的有y-k个
    //所以统计，一共有n/y个长度为y的段，共有n/y*(y-k)个数字满足条件；
    //然后考虑最后剩余的那一段，即[mk+1,n]，这段的长度为n%y，要判断其长度，如果大于k了，则说明有满足条件的数字，要统计其个数并加上；如果小于k则说明没有把满足条件的数字包含进来。
    public static void exam1(int n, int k){
        long count = 0;
        if(k == 0){
            System.out.println(n * n);
            return;
        }
        //被除数x,除数y,因为x%y>+k， 所以k一定是大于k的
        //对于每个y统计可能的x
        //先确定y
        for(long y = k + 1;y <= n;y++){
            //在每个长度为y的区间内，都有y-k个数字除以y后的余数大于等于k
            count += (n / y) * (y - k);
            long temp= n % y;
            //余下的数 区间长度如果大于k则要加上
            if(temp >= k)
                count += temp - (k - 1);//这里就只有(k -1)个数（[my+1,my+k)）除以y的余数是小于k的
        }
        System.out.println(count);
    }
}
