732. My Calendar III

Implement a MyCalendarThree class to store your events. A new event can always be added.

Your class will have one method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.

A K-booking happens when K events have some non-empty intersection (ie., there is some time that is common to all K events.)

For each call to the method MyCalendar.book, return an integer K representing the largest integer such that there exists a K-booking in the calendar.

Your class will be called like this: MyCalendarThree cal = new MyCalendarThree(); MyCalendarThree.book(start, end)
Example 1:
MyCalendarThree();
MyCalendarThree.book(10, 20); // returns 1
MyCalendarThree.book(50, 60); // returns 1
MyCalendarThree.book(10, 40); // returns 2
MyCalendarThree.book(5, 15); // returns 3
MyCalendarThree.book(5, 10); // returns 3
MyCalendarThree.book(25, 55); // returns 3
Explanation:
The first two events can be booked and are disjoint, so the maximum K-booking is a 1-booking.
The third event [10, 40) intersects the first event, and the maximum K-booking is a 2-booking.
The remaining events cause the maximum K-booking to be only a 3-booking.
Note that the last event locally causes a 2-booking, but the answer is still 3 because
eg. [10, 20), [10, 40), and [5, 15) are still triple booked.
Note:

The number of calls to MyCalendarThree.book per test case will be at most 400.
In calls to MyCalendarThree.book(start, end), start and end are integers in the range [0, 10^9].

题意
给定几个区间，这些区间可能存在交集。给出区间A、B、C、D、E
例如只有A和B存在交集，返回2
如果A和B和C同时存在交集，返回3
如果A和B和C和D同时存在交集，返回4
简单来说，就是求出某个区间被重复了的最大次数+1。

解题思路
从简单的开始想起，
假设学校里有1个会议室，这个会议室每天早上都会有很多人来预定，
新的预定成功之间，需要判断这个预定是否会和之前的预定有时间冲突，
那么只需要找到之前的预定是否存在一个时间区间(bStart,bEnd),与当前想要的时间区间(aStart,aEnd)满足这样的关系
max(aStart,bStart)<min(aEnd,bEnd)
如果存在，那就是冲突。

但在这个问题里，要求出冲突的次数，就有点难度了。
我们需要把每一个时间节点记录在数组里，每当遇到一个新的预定，
把预定的起始时间标记一个会议+1，在预定的终止时间标记一个会议-1
然后对这个序列排序，这样我们就得到了一个会议数目相对于时间节点的函数，
由于时间节点可能非常稀疏，所以我们用TreeMap来存储这些量。
比如对于题目中的例子[10,20],[50,60],[10,40],[5,15],[5,10],[25,55]

对于[10,20]
TreeMap=[10,1],[20,-1] 他的含义是，时间节点10，产生一个会议，时间节点20，结束一个会议
对于[50,60]
TreeMap=[10,1],[20,-1],[50,1],[60,-1]
对于[10,40]
TreeMap=[10,2],[20,-1],[40,-1][50,1],[60,-1]
对于[5,15]
TreeMap=[5,1],[10,2],[15,-1],[20,-1],[40,-1],[50,1],[60,-1]
对于[25,55]
TreeMap=[5,1],[10,2],[15,-1],[20,-1],[25,1],[40,-1],[50,1],[55,-1],[60,-1]

然后遍历这个TreeMap，找出某个时间节点下最大的会议数量即可。

JAVA代码
class MyCalendarThree {

    private TreeMap<Integer,Integer> timeline = new TreeMap<>();
    public int book(int start, int end) {
        timeline.put(start,timeline.getOrDefault(start,0)+1);
        timeline.put(end,timeline.getOrDefault(end,0)-1);
        int ongoing=0,k=0;
        for(int v:timeline.values())
            k=Math.max(k,ongoing+=v);
        return k;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */

做完了这道题，在回想一下之前的题，可以把这道题的思路应用到之前那个简单的问题，
用 时间节点-时间起始 时间节点-事件终止 映射来标记所有的事件，如果数组中[1]和[-1]不是成对出现，那就有重复的。

回忆之前做过的 731. My Calendar II
思路也非常简单了，只要维护一个时间线，判断一下当下正在进行的会议数量是否小于3，如果小于3，那还可以插进来，
如果=3，那么就不行了

C++代码
class MyCalendarTwo {
public:
    map<int, int> delta;
    bool book(int start, int end) {
        delta[start]++;
        delta[end]--;
        int booked = 0;
        for (auto &d : delta) {
            booked += d.second;
            if (booked == 3) {
                delta[start]--;
                delta[end]++;
                return false;
            }
        }
        return true;
    }
};


