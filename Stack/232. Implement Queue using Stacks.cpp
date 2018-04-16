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

�ҵĽⷨ
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

���˵Ľⷨ
���ҵĺ��˺ܶ࣬��������ջ��ģ����С�
���˼·��inputջ��������push��outputջ��������pop��top
outputջ���Ϊ�գ����inputջ��Ԫ�ص�����������ͳ�ջ��Ҫ���ֱ��outputջΪ��֮ǰ��
pop�����peek���񶼺�inputջ�޹��ˣ����outputջΪ���ˣ���ʱ������pop�����peek����
�����ٰ�input��Ԫ�ص������Ϳ����ˡ�

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

��һ�ֽⷨ������ÿ�β���Ԫ��ʱ ���õݹ��Ԫ�ز��뵽ջ�ף�������ֱ�Ӳ��뵽ջ������
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
