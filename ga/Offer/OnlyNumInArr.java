package Offer;

//数组中只出现一次的数字
//一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
public class OnlyNumInArr {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int n = 0;
        for(int i = 0; i < array.length; i++)
            n ^= array[i];
        int x = 1;
        while((n & x) == 0){//这里判断的时候要注意  判断是否等于1不合理！！！！！
            x = x << 1;
        }
        int[] arr1 = new int[array.length];
        int p = 0;
        int[] arr2 = new int[array.length];
        int q = 0;
        for(int i = 0; i < array.length; i++){
            if((array[i] & x) == 0)//这里注意 位运算要加() !!!!!!!
                arr1[p++] = array[i];
            else
                arr2[q++] = array[i];
        }
        num1[0] = getNum(arr1, p);
        num2[0] = getNum(arr2, q);
    }
    public int getNum(int[] arr, int length){
        int data = 0;
        for(int i = 0; i < length; i++)
            data ^= arr[i];
        return data;
    }
}
