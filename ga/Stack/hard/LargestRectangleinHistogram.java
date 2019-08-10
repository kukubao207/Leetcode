package Stack.hard;

import java.util.Stack;

//84. Largest Rectangle in Histogram
//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
//
//
//
//
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
//
//
//
//
//The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
//
//
//Example:
//
//Input: [2,1,5,6,2,3]
//Output: 10
public class LargestRectangleinHistogram {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int[] a1 = {2, 1, 5, 6, 2, 3};
        int[] a2 = {2, 1, 2};
        int[] a3 = {1, 1};
        System.out.println(largestRectangleArea1(a1));
        System.out.println(largestRectangleArea1(a2));
        System.out.println(largestRectangleArea1(a3));
    }

//    public static int largestRectangleArea(int[] heights) {
//        int[] left = new int[heights.length];
//        int[] right = new int[heights.length];
//        for (int i = 0; i < heights.length; i++) {
//            int p = i - 1;
//            while (p >= 0 && heights[p] >= heights[i])
//                p = left[p];
//            left[i] = p;
//        }
//        for (int i = heights.length - 1; i >= 0; i--) {
//            int p = i + 1;
//            while (p < heights.length && heights[p] >= heights[i])
//                p = right[p];
//            right[i] = p;
//        }
//        int maxArea = 0;
//        for (int i = 0; i < heights.length; i++) {
//            maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] - 1));
//        }
//        return maxArea;
//    }

    //1,暴力超时
    public static int largestRectangleArea(int[] heights) {
        int max = 0;
        for(int i = 0; i < heights.length; i++){
            int width = 0;
            int preMin = Integer.MAX_VALUE;
            for(int j = i; j < heights.length; j++){
                width++;
                if(heights[j] < preMin || preMin == Integer.MAX_VALUE){
                    max = Math.max(max, heights[j] * width);

                }
                else if(heights[j] >= preMin){
                    max = Math.max(max, preMin * width);
                }
                preMin = Math.min(preMin, heights[j]);
            }
        }
        return max;
    }
    /**https://blog.csdn.net/Zolewit/article/details/88863970
     * 利用单调栈求解，总体思路是 以柱子i高度为矩形高度时所能形成最大面积
     * （利用性质找出第i个柱子向左边和右边遍历时第一个比它低的柱子）
     * 单调栈定义：只存高度递增的柱子
     * 性质
     * 出栈时：
     * 那么如果单调栈为空了：说明没有比这个柱子更低的了（矩形宽度为这根柱子的序号：左边沿为0）
     * 如果单调栈不为空：说明栈里面的柱子高度都小，那么左边沿为栈顶柱子的序号
     *
     * 矩形右边沿为i 因为你出栈 就说明你比别人低了，这已经是你能达到的面积极限了.出栈记录面积
     * **/
    public static int largestRectangleArea1(int[] heights) {
        int[] heightn = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            heightn[i] = heights[i];
        }
        heightn[heights.length] = 0;   //最后增加个高度为0的柱子，以便把单调栈里面的都弹出去。
        Stack<Integer> stack = new Stack<>(); //存储序号
        int maxS = 0;
        for (int i = 0; i < heightn.length; i++) {
            while (!stack.isEmpty() && heightn[i] < heightn[stack.peek()]){  //一直出栈 直到遇见小的
                int temp = stack.pop();
                maxS = Math.max(maxS, ((stack.isEmpty() ? i : (i - stack.peek() - 1) ) * heights[temp]));//求包含heights[tmo]的面积
            }
            stack.push(i);//递增push
        }
        return maxS;
    }
}
