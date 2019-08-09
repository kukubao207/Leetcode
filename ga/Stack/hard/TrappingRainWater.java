package Stack.hard;
//42. Trapping Rain Water
//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
//
//The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
//
//Example:
//
//Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
public class TrappingRainWater {
    public static void main(String[] args){
        test();
    }
    //对于数组中的每个元素，下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
    public static int trap(int[] height) {
        int n = height.length;
        // left[i]表示i左边的最大值，right[i]表示i右边的最大值
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        int water = 0;
        for(int i = 0; i < n; i++){
            water += Math.max(0, Math.min(left[i], right[i]) - height[i]);
        }
        return water;
    }

    public static void test(){
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.print(trap(height));

    }
}
