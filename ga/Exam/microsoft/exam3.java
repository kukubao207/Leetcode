package Exam.microsoft;

/**
 * Created by myh on 2019/9/23.
 */
public class exam3 {
    public static void main(String[] args){
        test();
    }
    public static void test(){
        int[] arr = new int[]{12, 3};
        int n = 2;
        System.out.print(getSpecialNum(arr, n));
    }
    public static int getSpecialNum(int[] arr, int n){
        int count = 0;
        for(int i = 0; i < n; i++){
            int num = arr[i];
            for(int j = 0; j <= num; j++){
                if(j + getReverseNum(j) == num){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    public static int getReverseNum(int num){
        String res = "";
        while(num != 0){
            int n = num % 10;
            if(!(res == "" && n == 0))
                res += n;
            num /= 10;
        }
        return res == "" ? 0 : Integer.parseInt(res);
    }
}
