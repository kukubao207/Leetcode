package TwoPointer.medium;

import java.util.Arrays;

//11. Container With Most Water
//        给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
//        说明：你不能倾斜容器，且 n 的值至少为 2。
public class ContainerWithMostWater {
    //小爱写完之后证明该算法的正确性,写下你的证明过程
    public static void main(String args[]){
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    //暴力
    //时间复杂度O(n * n)，空间复杂度O(1)
    public static int maxArea(int[] height){
        int max = 0;
        for(int i = 0; i < height.length - 1; i++){
            for(int j = i + 1; j < height.length; j++){
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }
    //我们在由线段长度构成的数组中使用两个指针，一个放在开始，一个置于末尾。 此外，我们会使用变量 maxareamaxarea 来持续存储到目前为止所获得的最大面积。
    // 在每一步中，我们会找出指针所指向的两条线段形成的区域，更新 maxareamaxarea，并将指向较短线段的指针向较长线段那端移动一步。
    //时间复杂度O(n),空间复杂度O(1)
    public static int maxArea_one(int[] height){
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while(l < r){
            max = Math.max(max, Math.min(l, r) * (r - l));
            if(height[l] < height[r])
                l++;
            else
                r++;
        }
        return max;
    }
    //证明

}
