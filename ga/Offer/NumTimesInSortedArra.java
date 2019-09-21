package Offer;
//数字在排序数组中出现的次数
//统计一个数字在排序数组中出现的次数。

public class NumTimesInSortedArra {
    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0)
            return 0;
        int first = getFirstNum(array, k, 0, array.length - 1);
        int last = getLastNum(array, k, 0, array.length - 1);
        if(first == -1)
            return 0;
        else
            return last - first + 1;
    }
    public int getFirstNum(int [] arr , int k, int l, int r){
        while(l < r){
            int mid = (l + r) >> 1;
            if(arr[mid] >= k)
                r = mid;
            else
                l = mid + 1;
        }
        if(arr[l] == k)
            return l;
        return -1;
    }
    public int getLastNum(int [] arr , int k, int l, int r){
        while(l < r){
            int mid = (l + r + 1) >> 1;
            if(arr[mid] <= k)
                l = mid;
            else
                r = mid - 1;
        }
        if(arr[l] == k)
            return l;
        return -1;
    }
}
