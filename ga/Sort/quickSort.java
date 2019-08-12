package Sort;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.util.Arrays;

/**
 * 快速排序
 * 类似于二叉树的先序遍历 先确定基准的index 再分治处理（0，index - 1）和（index + 1, end）
 */
public class quickSort {
    public static void main(String[] args){
        test();
    }
    //1.递归
    public static int divide(int[] arr, int low, int high) {
        int tmp = arr[low];//temp就是基准位
        while (low < high) {
            //先看右边，依次往左递减
            while (low < high && arr[high] >= tmp)
                high--;
            if (low >= high)
                break;
            else
                arr[low] = arr[high];
            //看左边
            while (low < high && arr[low] <= tmp)
                low++;
            if (low >= high)
                break;
            else
                arr[high] = arr[low];
        }
        arr[low] = tmp;
        return low;
    }

    public static void Quick(int arr[], int start, int end) {
        int i = divide(arr, start, end);
        if (i - 1 > 0)
            divide(arr, 0, i - 1);
        if (i + 1 < end)
            divide(arr, i + 1, end);
    }

    public static void Quicksort(int array[]) {
        Quick(array, 0, array.length - 1);
    }

    //2.非递归 利用栈 基准两侧控制范围的下标入栈
    public static void Quicks(int[] arr){
        int[] stack = new int[arr.length];
        int top = 0;
        int low = 0;
        int high = arr.length - 1;
        int par = divide(arr, low, high);
        //入栈
        if(par - 1 > low){
            stack[top++] = low;
            stack[top++] = par - 1;
        }
        if(par + 1 < high){
            stack[top++] = par + 1;
            stack[top++] = high;
        }
        //出栈
        while(top > 0){
            high = stack[--top];
            low = stack[--top];
            par = divide(arr, low, high);
            if(par - 1 > low){
                stack[top++] = low;
                stack[top++] = par - 1;
            }
            if(par + 1 < high){
                stack[top++] = par + 1;
                stack[top++] = high;
            }
        }
    }
    public static void test(){
        int[] arr = new int[]{4, 3, 1, 2, 5};
//        Quicksort(arr);
        Quicks(arr);
        System.out.print(Arrays.toString(arr));
    }
}
