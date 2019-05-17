package Array.medium;
//56. 合并区间

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//给出一个区间的集合，请合并所有重叠的区间。
//
//示例 1:
//
//输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//示例 2:
//
//输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2)
            return intervals;
        //按二维数组第一位排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {//当o1[0] - o2[0]大于0时就交换
                return o1[0] - o2[0];
            }
        });
        List<int []> list = new ArrayList<>();
        for(int i = 0; i < intervals.length - 1; i++){
            if(intervals[i + 1][0] <= intervals[i][1]){
                intervals[i + 1][0] = intervals[i][0];
                intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
            }else
                list.add(intervals[i]);
        }
        //最后的区间加入list中
        list.add(intervals[intervals.length - 1]);
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}

