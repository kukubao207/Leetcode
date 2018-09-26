731. My Calendar II

Implement a MyCalendarTwo class to store your events. A new event can be added if adding
the event will not cause a triple booking.

Your class will have one method, book(int start, int end). Formally, this represents a
booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.

A triple booking happens when three events have some non-empty intersection
(ie., there is some time that is common to all 3 events.)

For each call to the method MyCalendar.book, return true if the event can be added to
the calendar successfully without causing a triple booking. Otherwise, return false
and do not add the event to the calendar.

Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
Example 1:
MyCalendar();
MyCalendar.book(10, 20); // returns true
MyCalendar.book(50, 60); // returns true
MyCalendar.book(10, 40); // returns true
MyCalendar.book(5, 15); // returns false
MyCalendar.book(5, 10); // returns true
MyCalendar.book(25, 55); // returns true
Explanation:
The first two events can be booked.  The third event can be double booked.
The fourth event (5, 15) can't be booked, because it would result in a triple booking.
The fifth event (5, 10) can be booked, as it does not use time 10 which is already double booked.
The sixth event (25, 55) can be booked, as the time in [25, 40) will be double booked with the third event;
the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
Note:

The number of calls to MyCalendar.book per test case will be at most 1000.
In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].

����
��������һϵ�е����䣬Ҫ��
���ڵ���Ҫ��������䣬
�ڰѸ������������֮ǰ��
�����������֮ǰ�����������1���ظ����䣬����true��
�����֮ǰ������������2���ظ����䣬����false��

˼·
�ж���������[a0,a1] [b0,b1]�ظ��������� max(a0,b0) < min(a1,b1)

case 1:
a: a0 |-------------| a1
b:     b0 |-----| b1

case 2:
a: a0 |--------| a1
b:     b0 |--------| b1

case 3:
a: a0 |----| a1
b:              b0 |----| b1

case 4:
a:    a0 |--------| a1
b: b0 |----------------| b1

case 5:
a:     a0 |--------| a1
b: b0 |------| b1

case 6:
a:               a0 |----| a1
b: b0 |----| b1

���ڵ�ǰ�����䣬�����ж�����֮ǰ�����������Ƿ���ڽ��������ڵĻ����������������������
ÿ������һ�� �뵱ǰ������ڽ��������䣬���ѽ�������������
ֱ��ĳһ�Σ�����һ�������뵱ǰ������ڽ���������  ���� ���� ���ڽ��������䣬�ͷ���false��
�������������֮ǰ��������䣬��������false����ô��������Ա����뵽���������󷵻�true��
class MyCalendar{
public:
    vector<pair<int,int>> books;
    bool book(int start,int end) {
        for(auto b:books)
        {
            if(max(b.first,start)<min(b.second,end))
                return false;
        }
        books.push_back({start,end});
        return true;
    }
};
class MyCalendarTwo {
    vector<pair<int,int>> books;
public:
    bool book(int start, int end) {
        MyCalendar myCalendar;
        pair<int,int> overlap;
        for(auto b:books)
        {
            if(max(b.first,start)<min(b.second,end))
            {
                overlap = {max(b.first,start),min(b.second,end)};
                if(!myCalendar.book(overlap.first,overlap.second))
                    return false;
            }
        }
        books.push_back({start,end});
        return true;
    }
};
