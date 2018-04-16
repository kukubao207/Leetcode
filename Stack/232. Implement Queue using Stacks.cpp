232. Implement Queue using Stacks

Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

我的解法
class MyQueue {
public:
    /** Initialize your data structure here. */
    stack<int> s;
    MyQueue() {

    }

    /** Push element x to the back of queue. */
    void push(int x) {
        s.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        stack<int> temp;
        while(!s.empty())
        {
            temp.push(s.top());
            s.pop();
        }
        int result=temp.top();
        temp.pop();
        while(!temp.empty())
        {
            s.push(temp.top());
            temp.pop();
        }
        return result;
    }

    /** Get the front element. */
    int peek() {
        stack<int> temp;
        while(!s.empty())
        {
            temp.push(s.top());
            s.pop();
        }
        int result=temp.top();
        while(!temp.empty())
        {
            s.push(temp.top());
            temp.pop();
        }
        return result;
    }

    /** Returns whether the queue is empty. */
    bool empty() {
        return s.empty();
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * bool param_4 = obj.empty();
 */

别人的解法
比我的好了很多，用了两个栈来模拟队列。
这个思路：input栈用来处理push，output栈用来处理pop和top
output栈如果为空，则从input栈把元素倒进来做输出和出栈，要理解直到output栈为空之前，
pop任务和peek任务都和input栈无关了，如果output栈为空了，此时还遇到pop任务和peek任务
，就再把input的元素倒进来就可以了。

class Queue {
    stack<int> input, output;
public:

    void push(int x) {
        input.push(x);
    }

    void pop(void) {
        peek();
        output.pop();
    }

    int peek(void) {
        if (output.empty())
            while (input.size())
                output.push(input.top()), input.pop();
        return output.top();
    }

    bool empty(void) {
        return input.empty() && output.empty();
    }
};

另一种解法，就是每次插入元素时 利用递归把元素插入到栈底（而不是直接插入到栈顶）。
class Queue {
public:
    stack<int> s;

    // Push element x to the back of queue.
    void push(int x) {
        pushHelper(x);
    }
    void pushHelper(int x){
        if(s.size()==0){
            s.push(x);
            return;
        }
        int data;
        data = s.top();
        s.pop();
        pushHelper(x);
        s.push(data);
        return;

    }

    // Removes the element from in front of queue.
    void pop(void) {
        s.pop();
    }

    // Get the front element.
    int peek(void) {
        return s.top();
    }

    // Return whether the queue is empty.
    bool empty(void) {
        return (s.size()==0);
    }
};
