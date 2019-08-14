package Stack.easy;

import java.util.Stack;

//155. Min Stack
//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//push(x) -- Push element x onto stack.
//pop() -- Removes the element on top of the stack.
//top() -- Get the top element.
//getMin() -- Retrieve the minimum element in the stack.
//
//
//Example:
//
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> Returns -3.
//minStack.pop();
//minStack.top();      --> Returns 0.
//minStack.getMin();   --> Returns -2.
public class MinStack {
    /** initialize your data structure here. */
    public static void main(String[] args){
        test();
    }
    public Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    //取出最小值的时候时间复杂度O(n)
    //也有人用两个栈  stack<int> data stack<int> minstack;
    public int getMin() {
        int min = Integer.MAX_VALUE;
        Stack<Integer> tmp = (Stack<Integer>) stack.clone ();//复制stack  不能直接等于
        while(!tmp.isEmpty()){
            min = Math.min(min, tmp.peek());
            tmp.pop();
        }
        return min;
    }
    public static void test(){
        MinStack s = new MinStack();
        s.push(-2);
        s.push(0);
        s.push(-3);
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.top());
        System.out.println(s.getMin());
//        System.out.print(s.stack);
    }
}
