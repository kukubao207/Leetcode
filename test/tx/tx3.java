package tx;

import java.util.*;

public class tx3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < 100; i++)
           System.out.println(GetResult(i));
    }

    static String GetResult(int N) {
        int num = 1,temp = N, level = 0, sum = 0;
        while (temp > 0) {
            temp -= num;
            sum += num;
            level++;
            num++;
        }
        sum = sum - num + 2;
        int x = level;
        int y = 1;
        while (sum < N) {
            x--;
            y++;
            sum++;
        }
        return level%2==1? (x + "/" + y ): (y + "/" + x);
    }
}
