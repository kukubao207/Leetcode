package tx;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class tx5 {
    public static void main(String[] args){
        int[] inp = {1,3,3,3,3,4,5};
        new tx5().GetNumberOfK(inp,0);
    }
    public int GetNumberOfK(int [] array , int k) {
        if(array.length==0)
            return 0;
        int idx1 = firstLessThanK(array, k);
        int idx2 = firstMoreThanK(array, k);
        return idx2-idx1-1;
    }
    public int firstLessThanK(int[] array, int k){
        int l=0,r=array.length-1;
        while(l<r-1){
            int m=l+(r-l)/2;
            if(array[m]>=k){
                r=m;
            }else if(array[m]<k){
                l=m;
            }
        }
        if(array[r]<k)
            return r;
        else if(array[l]<k)
            return l;
        else
            return -1;
    }
    public int firstMoreThanK(int[] array, int k){
        int l=0,r=array.length-1;
        while(l<r-1){
            int m=l+(r-l)/2;
            if(array[m]>k){
                r=m;
            }else if(array[m]<=k){
                l=m;
            }
        }
        if(array[l]>k)
            return l;
        else if(array[r]>k)
            return r;
        else
            return array.length;
    }
}