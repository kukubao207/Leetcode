352. Data Stream as Disjoint Intervals

Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]

���⣬�ϲ����䡣

�ҵ�˼·
��TreeMap����֮ǰ��lowerKey()��higherKey()��ѧϰ�����������Ϊ�򵥣���������һ�¼��ɡ�
��Ҫ��
if(tree.containsKey(val))
    return;
�����д��������ϣ��������֮ǰ��[6,8] �ٳ���һ��Ԫ��6���ͻᵼ��[6,8]��[6,6]���ǣ��ᱨ����̸�ˡ�
����ʱ��̫���ˣ��Ͳ�д˼·�ˡ�

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
        //����С�ڵ���key�����ļ�ֵ������Ӧ��KEY��û�еĻ�����null��
        Integer l=tree.lowerKey(val);
        //���ش��ڵ���key����С�ļ�ֵ������Ӧ��KEY��û�еĻ�����null��
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
