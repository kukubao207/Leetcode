package niuke;

import java.util.Scanner;
import java.util.Stack;

public class MaxMinStack {
    public static class MMStack{
        private Stack<Integer> s = new Stack<>();
        private Stack<Integer> maxStack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();
        public void push(int num){
            s.push(num);
            if(maxStack.empty())
                maxStack.push(num);
            else{
                if(num>maxStack.peek())
                    maxStack.push(num);
                else
                    maxStack.push(maxStack.peek());
            }
            if(minStack.empty())
                minStack.push(num);
            else{
                if(num<maxStack.peek())
                    minStack.push(num);
                else
                    minStack.push(minStack.peek());
            }
        }
        public void pop(){
            if(!s.empty())
                s.pop();
            if(!maxStack.empty())
                maxStack.pop();
            if(!minStack.empty())
                minStack.pop();
        }
        public int max(){
            if(!maxStack.empty())
                return maxStack.peek();
            return Integer.MIN_VALUE;
        }
        public int min(){
            if(!minStack.empty())
                return minStack.peek();
            return Integer.MAX_VALUE;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        MMStack maxMinStack = new MMStack();
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int temp = sc.nextInt();
            maxMinStack.push(temp);
        }
        maxMinStack.pop();
        System.out.println(maxMinStack.max()+","+maxMinStack.min());
        sc.close();
    }
}
