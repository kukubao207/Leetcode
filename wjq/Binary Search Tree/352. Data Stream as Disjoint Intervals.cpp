352. Data Stream as Disjoint Intervals

Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]

题意，合并区间。

我的思路
用TreeMap，有之前的lowerKey()和higherKey()的学习基础，这题较为简单，分类讨论一下即可。
主要是
if(tree.containsKey(val))
    return;
这两行代码必须加上，否则对于之前的[6,8] 再出来一个元素6，就会导致[6,8]被[6,6]覆盖，会报错，不谈了。
今天时间太晚了，就不写思路了。

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class SummaryRanges {

    /** Initialize your data structure here. */
    TreeMap<Integer,Interval> tree;
    public SummaryRanges() {
        tree = new TreeMap<Integer,Interval>();
    }

    public void addNum(int val) {
        if(tree.containsKey(val))
            return;
        //返回小于等于key的最大的键值对所对应的KEY，没有的话返回null”
        Integer l=tree.lowerKey(val);
        //返回大于等于key的最小的键值对所对应的KEY，没有的话返回null”
        Integer h = tree.higherKey(val);
        if(l!=null&&h!=null&&tree.get(l).end+1==val&&val+1==h)
        {
            tree.get(l).end=tree.get(h).end;
            tree.remove(h);
        }
        else if(l!=null &&tree.get(l).end+1>=val)
            tree.get(l).end=Math.max(tree.get(l).end,val);
        else if(h!=null &&val+1==h)
        {
            tree.put(val,new Interval(val,tree.get(h).end));
            tree.remove(h);
        }
        else
            tree.put(val,new Interval(val,val));
    }

    public List<Interval> getIntervals() {
        return  new ArrayList<Interval>(tree.values());
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
