package BinarySearch;

/**
 *
 */
public class BinarySearch {
    public static void main(String[] args) {
        test();
    }
    //1.第一个=key的，不存在返回-1
    public static int firstEqual(int[] arr,int target){
        int left = 0, right = arr.length - 1; //在[l, r]查找第一个>=key的
        while(left < right){
            int mid = (left + right) >>> 1;//左中位数
            if(arr[mid] >= target)
                right = mid;
            else
                left = mid + 1;
        }
        if(arr[left] == target)
            return left;
        else return -1;
    }
    //2.第一个>=key的
    public static int firstLargeEqual(int[] arr,int target){
        int left = 0, right = arr.length - 1; //在[l, r]查找第一个>=key的
        while(left < right){
            int mid = (left + right) >>> 1;
            if(arr[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        if(arr[left] >= target)//需要判断 1，2，3（key = 4）
            return left;
        else return -1;
    }
    //3.第一个>key的
    public static int firstLarge(int[] arr,int target){
        int left = 0, right = arr.length - 1; //在[l, r]查找第一个>=key的
        while(left < right){
            int mid = (left + right) >>> 1;
            if(arr[mid] <= target)
                left = mid + 1;
            else
                right = mid;
        }
        if(arr[left] > target)//需要判断 1，2，3（key = 4）
            return left;
        else return -1;
    }


    //4.最后一个=key的，不存在返回-1
    public static int lastEqual(int[] arr,int target){
        int left = 0, right = arr.length - 1; //在[l, r]查找第一个>=key的
        while(left < right){
            int mid = (left + right + 1) >>> 1;//右中位数
            if(arr[mid] <= target)
                left = mid;
            else
                right = mid - 1;
        }
        if(arr[left] == target)
            return left;
        else return -1;
    }

    //5.最后一个<=key的
    public static int lastSmallEqual(int[] arr,int target){
        int left = 0, right = arr.length - 1; //在[l, r]查找第一个>=key的
        while(left < right){
            int mid = (left + right + 1) >>> 1;//右中位数
            if(arr[mid] <= target)
                left = mid;
            else
                right = mid - 1;
        }
        if(arr[left] <= target)
            return left;
        else return -1;
    }
    //6.最后一个<key 的
    public static int lastSmall(int[] arr,int target){
        int left = 0, right = arr.length - 1; //在[l, r]查找第一个>=key的
        while(left < right){
            int mid = (left + right + 1) >>> 1;//右中位数
            if(arr[mid] < target)
                left = mid;
            else
                right = mid - 1;
        }
        if(arr[left] < target)
            return left;
        else return -1;
    }

    public static void test(){
        int[] arr1 = new int[]{1, 3, 4, 6, 6, 6, 6, 6, 6, 8, 9};
        int[] arr2 = new int[]{ 6, 6, 6, 6, 6, 6};
        int[] arr3 = new int[]{ 1, 2, 3};
        System.out.println(firstEqual(arr1, 6));
        System.out.println(firstEqual(arr2, 6));
        System.out.println(firstLargeEqual(arr3, 4));
        System.out.println(firstLarge(arr3, 4));
        System.out.println(lastEqual(arr1, 6));
        System.out.println(lastSmall(arr1, 6));
    }
}
