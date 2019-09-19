package Exam.intel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**

 */
public class exam1 {
    public static void main(String[] args){
        int[] arr = new int[]{1, 6, 4, 2, 2};
        int swap = 1;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int j = 0; j < arr.length; j++)
            map.put(arr[j], j);//相同情况下会存放最后一个index
        int[] minArr = new int[]{1, 6, 4, 2, 2};
        Arrays.sort(minArr);
        swap(arr, minArr, map, swap, count);
        System.out.print(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int[] minArr, Map<Integer,Integer> map, int swap, int count){
        for(int i = 0; i < arr.length; i++){
            if(count >= swap)
                break;
            if(arr[i] == minArr[i])
                continue;
            else{
                int index = map.get(minArr[i]);
                int tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
                count++;
                for(int j = 0; j < arr.length; j++)
                    map.put(arr[j], j);//相同情况下会存放最后一个index
            }
        }
    }

}
