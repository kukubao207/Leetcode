package Sort;

import java.util.Arrays;

/**
 * 归并排序 类似于二叉树的后序遍历 先将一个数组分成两半 再分别对这两部分进行归并排序 最后将两个有序的部分merge
 */
public class mergeSort {
    public static void main(String[] args){
        test();
    }
    public static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);//左边归并排序，使得左子序列有序
            mergeSort(arr, mid + 1, right);//右边归并排序，使得右子序列有序
            merge(arr, left, mid, right);//合并两个子序列
        }
    }
    public static void merge(int[] arr, int left, int mid, int right){
        int i = left;
        int j = mid + 1;
        int[] tmp = new int[right - left + 1];//用来存放有序数组
        int k = 0;//记录数组的索引
        while(i <= mid && j <= right){
            if(arr[i] < arr[j])
                tmp[k++] = arr[i++];
            else
                tmp[k++] = arr[j++];
        }
        while(i <= mid){//将左边剩余元素填充进temp中
            tmp[k++] = arr[i++];
        }
        while(j <= right){//将右序列剩余元素填充进temp中
            tmp[k++] = arr[j++];
        }
        //将temp中的元素全部拷贝到原数组中
        for (int t = 0; t < tmp.length; t++) {
            arr[t + left] = tmp[t];
        }
    }

    public static void test(){
        int[] arr = new int[]{9,2,6,3,5,7,10,11,12};
        mergeSort(arr, 0, arr.length - 1);
        System.out.print(Arrays.toString(arr));
    }
}
