import java.util.ArrayList;
import java.util.List;

public class BiSearch {
    public static void main(String args[]) {
        int[] A = {-5,-3,1,2,3,4,5,6,7,8,9,10};
        Solution.findClosestElements(A,4,3);
        //int ans = findKthLargest(A, k);
        //int ans2 = partition2(A,0,5);
    }

    public static class Solution {
        public static List<Integer> findClosestElements(int[] arr, int k, int x) {
            int lo = 0, hi = arr.length - k;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (x - arr[mid] > arr[mid+k] - x)
                    lo = mid + 1;
                else
                    hi = mid;
            }
            List<Integer> res = new ArrayList<>();
            for(int i=lo;i<lo+k;i++){
                res.add(arr[i]);
            }
            return res;
        }
    }
}
