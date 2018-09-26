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

����
�����������䣬��Щ������ܴ��ڽ�������������A��B��C��D��E
����ֻ��A��B���ڽ���������2
���A��B��Cͬʱ���ڽ���������3
���A��B��C��Dͬʱ���ڽ���������4
����˵���������ĳ�����䱻�ظ��˵�������+1��

����˼·
�Ӽ򵥵Ŀ�ʼ����
����ѧУ����1�������ң����������ÿ�����϶����кܶ�����Ԥ����
�µ�Ԥ���ɹ�֮�䣬��Ҫ�ж����Ԥ���Ƿ���֮ǰ��Ԥ����ʱ���ͻ��
��ôֻ��Ҫ�ҵ�֮ǰ��Ԥ���Ƿ����һ��ʱ������(bStart,bEnd),�뵱ǰ��Ҫ��ʱ������(aStart,aEnd)���������Ĺ�ϵ
max(aStart,bStart)<min(aEnd,bEnd)
������ڣ��Ǿ��ǳ�ͻ��

������������Ҫ�����ͻ�Ĵ��������е��Ѷ��ˡ�
������Ҫ��ÿһ��ʱ��ڵ��¼�������ÿ������һ���µ�Ԥ����
��Ԥ������ʼʱ����һ������+1����Ԥ������ֹʱ����һ������-1
Ȼ���������������������Ǿ͵õ���һ��������Ŀ�����ʱ��ڵ�ĺ�����
����ʱ��ڵ���ܷǳ�ϡ�裬����������TreeMap���洢��Щ����
���������Ŀ�е�����[10,20],[50,60],[10,40],[5,15],[5,10],[25,55]

����[10,20]
TreeMap=[10,1],[20,-1] ���ĺ����ǣ�ʱ��ڵ�10������һ�����飬ʱ��ڵ�20������һ������
����[50,60]
TreeMap=[10,1],[20,-1],[50,1],[60,-1]
����[10,40]
TreeMap=[10,2],[20,-1],[40,-1][50,1],[60,-1]
����[5,15]
TreeMap=[5,1],[10,2],[15,-1],[20,-1],[40,-1],[50,1],[60,-1]
����[25,55]
TreeMap=[5,1],[10,2],[15,-1],[20,-1],[25,1],[40,-1],[50,1],[55,-1],[60,-1]

Ȼ��������TreeMap���ҳ�ĳ��ʱ��ڵ������Ļ����������ɡ�

JAVA����
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

����������⣬�ڻ���һ��֮ǰ���⣬���԰�������˼·Ӧ�õ�֮ǰ�Ǹ��򵥵����⣬
�� ʱ��ڵ�-ʱ����ʼ ʱ��ڵ�-�¼���ֹ ӳ����������е��¼������������[1]��[-1]���ǳɶԳ��֣��Ǿ����ظ��ġ�

����֮ǰ������ 731. My Calendar II
˼·Ҳ�ǳ����ˣ�ֻҪά��һ��ʱ���ߣ��ж�һ�µ������ڽ��еĻ��������Ƿ�С��3�����С��3���ǻ����Բ������
���=3����ô�Ͳ�����

C++����
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


