package Offer;
public class SmallestNumofRotatingArray {
        public int minNumberInRotateArray(int [] array) {
            if(array.length == 0)
                return 0;
            int i = 0;
            int j = array.length - 1;
            if(array[j] > array[i])
                return array[i];//没有旋转  1，2，3，4，5
            while(i + 1 < j){
                int mid = i + (j - i) / 2;
                if(array[mid] > array[i])
                    i = mid;
                else if(array[mid] < array[i])
                    j = mid;
                else{//有相等的数字：1，1，1，0，1 或者 1，0，1，1，1
                    int min = Integer.MAX_VALUE;
                    for(int t = 0; t < array.length; t++)
                        min = Math.min(min, array[t]);
                    return min;
                }
            }
            return array[j];
        }
}
