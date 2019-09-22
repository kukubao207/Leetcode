package Offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**滑动窗口最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxValueOfSlidingWindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(num == null || num.length == 0 || size > num.length || size <= 0)
            return res;
        Deque<Integer> deque = new LinkedList<Integer>();
        for(int i = 0; i < num.length; i++){
            while(!deque.isEmpty() && num[i] > deque.getLast()){
                deque.pollLast();
            }
            deque.addLast(num[i]);
            if(i >= size - 1){
                res.add(deque.getFirst());
                if(num[i - size + 1] == deque.getFirst())
                    deque.removeFirst();
            }
        }
        return res;
    }
}
