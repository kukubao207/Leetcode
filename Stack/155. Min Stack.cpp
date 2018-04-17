155. Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.


我的思路

class MinStack {
public:
    stack<int> s,temp;
    void push(int x) {
        s.push(x);
    }

    void pop() {
        s.pop();
    }

    int top() {
        return s.top();
    }

    int getMin() {
        int minNum=s.top();
        temp=s;
        while(!temp.empty())
        {
            if(temp.top()<minNum)
                minNum=temp.top();
            temp.pop();
        }
        return minNum;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class MinStack {
public:
    /** initialize your data structure here. */
    stack<int> s1;
    stack<int> s2;
    void push(int x) {
	    s1.push(x);
	    if (s2.empty() || x <= getMin())
            s2.push(x);
    }

    void pop()
    {
	    if (s1.top() == getMin())
            s2.pop();
	    s1.pop();
    }

    int top() {
	    return s1.top();
    }

    int getMin() {
	    return s2.top();
    }
};
