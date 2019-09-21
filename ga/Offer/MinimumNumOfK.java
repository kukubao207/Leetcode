package Offer;

import java.util.ArrayList;

/**最小的k个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class MinimumNumOfK {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(input == null || input.length == 0 || k > input.length || k <= 0)
            return res;
        getKMin(input, 0, input.length - 1, k);
        for(int i = 0; i < k; i++)
            res.add(input[i]);
        return res;
    }
    public void getKMin(int[] arr, int start, int end, int k){
        int p = divide(arr, start, end);
        if(p == k - 1)
            return;
        else if(p < k - 1){
            getKMin(arr, p + 1, end , k);
        }else{
            getKMin(arr, start, p - 1, k);
        }
    }
    public int divide(int[] arr, int start, int end){
        int tmp = arr[start];
        int i = start;
        int j = end;
        while(i < j){
            while(i < j && arr[j] >= tmp)
                j--;
            arr[i] = arr[j];
            while(i < j && arr[i] <= tmp)
                i++;
            arr[j] = arr[i];
        }
        arr[i] = tmp;
        return i;
    }
}
