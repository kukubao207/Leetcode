package pd;

import java.util.HashMap;
import java.util.Map;

public class Find {
    public static void main(String[] args) {
        test();
    }

    public static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void test() {
        Interval v1 = new Interval(10, 20);
        Interval v2 = new Interval(25, 30);
        Interval v3 = new Interval(35, 40);
        int arr[] = {10, 25, 35};
        HashMap<Integer, Interval> map = new HashMap<>();
        map.put(0, v1);
        map.put(1, v2);
        map.put(2, v3);
        for (int i = 0; i < 50; i++) {
            find(i, arr, map);
        }

    }

    public static void find(int num, int[] arr, Map<Integer, Interval> map) {
        int idx = findFirstLowerEqualThan(arr, 0, arr.length - 1, num);
        if (idx > arr.length - 1 || idx < 0) {
            System.out.println(num + " Not Find");
        } else {
            Interval v = map.get(idx);
            if (num <= v.end) {
                System.out.println(num + " Find");
            } else {
                System.out.println(num + " Not Find");
            }
        }

    }

    // 二分查找 找到第一个小于等于target的元素，若不存在输出-1
    public static int findFirstLowerEqualThan(int[] arr, int l, int r, int target) {
        if (arr == null || arr.length == 0)
            return -1;
        if (l == r) {               // 判断l 和 r指针一进来就是重叠的情况
            if (arr[l] <= target)
                return l;
            else
                return -1;
        }
        while (l < r - 1) {         // l < r-1  可以保证两个指针l 和 r在做完while之后不重叠
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target)
                l = mid;
            else
                r = mid;
        }
        if (arr[r] <= target)
            return r;
        else if (arr[l] <= target)
            return l;
        return -1;
    }
}
