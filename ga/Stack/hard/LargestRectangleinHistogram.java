package Stack.hard;

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
        int[] a = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(a));
    }

    public static int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i])
                p = left[p];
            left[i] = p;
        }
        for (int i = heights.length - 1; i >= 0; i--) {
            int p = i + 1;
            while (p < heights.length && heights[p] >= heights[i])
                p = right[p];
            right[i] = p;
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] - 1));
        }
        return maxArea;
    }
}
