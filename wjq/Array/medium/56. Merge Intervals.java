56. Merge Intervals

        Given a collection of intervals, merge all overlapping intervals.

        Example 1:

        Input: [[1,3],[2,6],[8,10],[15,18]]
        Output: [[1,6],[8,10],[15,18]]
        Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
        Example 2:

        Input: [[1,4],[4,5]]
        Output: [[1,5]]
        Explanation: Intervals [1,4] and [4,5] are considered overlapping.

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<=1)
            return intervals;
        //以start排序，小的在前，lambda表达式
        intervals.sort((i1,i2)->Integer.compare(i1.start,i2.start));
        List<Interval> res = new ArrayList<>();
        int start=intervals.get(0).start,end=intervals.get(0).end;
        for(Interval i:intervals){
            if(i.start<=end){
                end=Math.max(end,i.end);
            }else{
                res.add(new Interval(start,end));
                start=i.start;
                end=i.end;
            }
        }
        res.add(new Interval(start,end));
        return res;
    }

}



/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<=1)
            return intervals;
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        for(int i=0;i<intervals.size();i++){
            start[i]=intervals.get(i).start;
            end[i]=intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        List<Interval> res = new ArrayList<>();
        for(int i=0,j=0;i<intervals.size();i++){
            if(i==intervals.size()-1||start[i+1]>end[i]){
                res.add(new Interval(start[j],end[i]));
                j=i+1;
            }
        }
        return res;
    }

}