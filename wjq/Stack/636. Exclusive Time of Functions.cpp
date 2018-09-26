636. Exclusive Time of Functions

Given the running logs of n functions that are executed in a nonpreemptive single threaded CPU, find the exclusive time of these functions.

Each function has a unique id, start from 0 to n-1. A function may be called recursively or by another function.

A log is a string has this format : function_id:start_or_end:timestamp. For example, "0:start:0" means function 0 starts from the very beginning of time 0. "0:end:0" means function 0 ends to the very end of time 0.

Exclusive time of a function is defined as the time spent within this function, the time spent by calling other functions should not be considered as this function's exclusive time. You should return the exclusive time of each function sorted by their function id.

Example 1:
Input:
n = 2
logs =
["0:start:0",
 "1:start:2",
 "1:end:5",
 "0:end:6"]
Output:[3, 4]
Explanation:
Function 0 starts at time 0, then it executes 2 units of time and reaches the end of time 1.
Now function 0 calls function 1, function 1 starts at time 2, executes 4 units of time and end at time 5.
Function 0 is running again at time 6, and also end at the time 6, thus executes 1 unit of time.
So function 0 totally execute 2 + 1 = 3 units of time, and function 1 totally execute 4 units of time.
Note:
Input logs will be sorted by timestamp, NOT log id.
Your output should be sorted by function id, which means the 0th element of your output corresponds to the exclusive time of function 0.
Two functions won't start or end at the same time.
Functions could be called recursively, and will always end.
1 <= n <= 100

我的思路
遇到start直接压栈。
遇到end时，说明函数对匹配成功，先让当前这个函数对加上时间log[i].timestamp-s.top().timestamp+1，
再看看这个人是不是被别的函数包裹住，如果是的话，包裹该函数的人的运行时间要减去该函数的运行时间。

class Solution {
public:
    struct Log
    {
        int id;
        string status;
        int timestamp;
    }log[10005];
    vector<int> exclusiveTime(int n, vector<string>& logs) {

        stack<Log> s;
        vector<int> res(n,0);
        parseLogs(logs);
        for(int i=0;i<logs.size();i++)
        {
            if(log[i].status=="start")
            {
                s.push(log[i]);
            }
            else
            {
                int num=log[i].timestamp-s.top().timestamp+1;
                res[log[i].id]+=num;
                s.pop();
                if(!s.empty())
                    res[s.top().id]-=num;
            }
        }
        return res;

    }
    void parseLogs(vector<string>& logs)
    {
        for(int i=0;i<logs.size();i++)
        {
            int first=logs[i].find_first_of(":");
            int last=logs[i].find_last_of(":");
            log[i].id=stoi(logs[i].substr(0,first+1));
            log[i].status=logs[i].substr(first+1,last-first-1);
            log[i].timestamp=stoi(logs[i].substr(last+1));
        }
    }
};

别人的思路
public int[] exclusiveTime(int n, List<String> logs) {
    int[] res = new int[n];
    Stack<Integer> stack = new Stack<>();
    int prevTime = 0;
    for (String log : logs)
    {
        String[] parts = log.split(":");
        if (!stack.isEmpty())
            res[stack.peek()] +=  Integer.parseInt(parts[2]) - prevTime;
        prevTime = Integer.parseInt(parts[2]);
        if (parts[1].equals("start"))
            stack.push(Integer.parseInt(parts[0]));
        else {
            res[stack.pop()]++;
            prevTime++;
        }
    }
    return res;
}
