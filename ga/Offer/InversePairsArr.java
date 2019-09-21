package Offer;

//数组中的逆序对
//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
public class InversePairsArr {
    public int InversePairs(int [] array) {
        if(array == null || array.length == 0)
            return 0;
        helper(array, 0, array.length - 1);
        return count;
    }
    int count = 0;
    public void helper(int[] array, int l, int r){
        if(l >= r)
            return;
        int mid = l + (r - l) / 2;
        helper(array, l, mid);
        helper(array, mid + 1, r);
        merge(array, l, mid, r);
    }
    public void merge(int[] array, int l, int mid, int r){
        int[] tmp = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int t = 0;
        while(i <= mid && j <= r){
            if(array[i] < array[j]){
                tmp[t++] = array[i++];
                if(count >= 1000000007)
                    count %= 1000000007;
                count += j - mid - 1;
            }else
                tmp[t++] = array[j++];
        }
        while(i <= mid){
            tmp[t++] = array[i++];
            if(count >= 1000000007)
                count %= 1000000007;
            count += j - mid - 1;
        }
        while(j <= r)
            tmp[t++] = array[j++];
        for(int s = 0; s < t; s++){
            array[s + l] = tmp[s];
        }
    }
}
