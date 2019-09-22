package Offer;
//旋转数组的最小数
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
//        例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
//        NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
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
