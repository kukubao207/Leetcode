import java.util.ArrayList;
import java.util.List;

public class BiSearch {
    public static int[] test = {-5,-3,1,2,3,4,5,6,7,8,9,10};
    public static void main(String args[]) {
        //int[] A = {-5,-3,1,2,3,4,5,6,7,8,9,10};
        //Solution.findClosestElements(A,4,3);
        System.out.println(find_first_higher_and_equal_than_target_index(test,0,test.length-1,-10));
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

    public static int find_first_lower_and_equal_than_target_index(int[] arr,int l,int r,int target){
        int index = -1;
        while(l<r-1){
            int mid = l + (r-l)/2;
            if(arr[mid]<=target)
                l=mid;
            else
                r=mid;
        }
        if(arr[r]<=target)
            index=r;
        else if(arr[l]<=target)
            index=l;
        return index;
    }

    public static int find_first_lower_than_target_index(int[] arr,int l,int r,int target){
        int index = -1;
        while(l<r-1){
            int mid = l + (r-l)/2;
            if(arr[mid]<target)
                l=mid;
            else
                r=mid;
        }
        if(arr[r]<target)
            index=r;
        else if(arr[l]<target)
            index=l;
        return index;
    }

    public static int find_first_higher_and_equal_than_target_index(int[] arr,int l,int r,int target){
        int index = -1;
        while(l<r-1){
            int mid = l + (r-l)/2;
            if(arr[mid]>=target)
                r=mid;
            else
                l=mid;
        }
        if(arr[l]>=target)
            index=l;
        else if(arr[r]>=target)
            index=r;
        return index;
    }

    public static int find_first_higher_than_target_index(int[] arr,int l,int r,int target){
        int index = -1;
        while(l<r-1){
            int mid = l + (r-l)/2;
            if(arr[mid]>target)
                r=mid;
            else
                l=mid;
        }
        if(arr[l]>target)
            index=l;
        else if(arr[r]>target)
            index=r;
        return index;
    }
}
