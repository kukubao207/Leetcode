57. Insert Interval

        Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

        You may assume that the intervals were initially sorted according to their start times.

        Example 1:

        Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
        Output: [[1,5],[6,9]]
        Example 2:

        Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
        Output: [[1,2],[3,10],[12,16]]
        Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].


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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int i=0;
        int start=newInterval.start,end=newInterval.end;

        //把不交叉的区域先加入
        while(i<intervals.size()&&intervals.get(i).end<start){
            res.add(intervals.get(i));
            i++;
        }

        while(i<intervals.size()&&intervals.get(i).start<=end){
            start=Math.min(intervals.get(i).start,start);
            end=Math.max(intervals.get(i).end,end);
            i++;
        }
        res.add(new Interval(start,end));

        while(i<intervals.size()){
            res.add(intervals.get(i));
            i++;
        }
        return res;
    }
}