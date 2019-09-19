package SwordTowardsOffer;

/**
 * 计算1到n中每一位包含多少个1
 */
public class CountOne {
    public static void test(){
        int n = 12;
        System.out.println(countOne1(n));
    }
    public static void main(String[] args){
        test();
    }
    public static int countOne(int n){
        if(n <= 0)
            return 0;
        int numberOfDigit = 0;
        int tailNumber = 0;
        int count = 0;
        int num = 0;
        while(n != 0){
            int tailDigit = getNum(numberOfDigit);
            tailNumber += num * (tailDigit / 10);
            num = n % 10;
            n = n / 10;
            if(num != 0 && num != 1)
                count += (n + 1) * tailDigit;
            else if(num == 0)
                count += n * tailDigit;
            else
                count += tailNumber + 1 + n * tailDigit;
            numberOfDigit++;
        }
        return count;
    }
    public static int getNum(int numberOfDigit){
        int num = 1;
        for(int i = 0; i < numberOfDigit; i++)
            num *= 10;
        return num;
    }

    public static int countOne1(int n){
        int digit = 1;
        int count = 0;
        while(digit <= n){
            int left = n / digit, right = n % digit;
            int num = left % 10;
            if(num != 0 && num != 1)
                count += (left / 10 + 1) * digit;
            else if(num == 0)
                count += (left / 10) * digit;
            else
                count += right + 1 + (left / 10) * digit;
            digit *= 10;
        }
        return count;
    }
}
