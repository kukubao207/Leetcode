11. Container With Most Water

        Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

        Note: You may not slant the container and n is at least 2.





        The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.



        Example:

        Input: [1,8,6,2,5,4,8,3,7]
        Output: 49


这题的核心思路
双指针 + 贪心吧
理解到如何左右指针如何收缩，肯定是

假设我们有  a1 -> a20
如果  a10 a15 有最大值,
当左指针指向a10,右指针指向a16
一定满足 a10>a16

下面我们来用反证法证明这个结论
假设a10 < a16
那么 area(a10,a15) < area(a10,a16)
    (15-10) * a10 < (16-10) * a10
这与原始结论  area(a10,a15)有最大值相违背。

因此当   a10 a15有最大值时，
一定满足 a10 > a16
因此如果那时候指针指向的是a16，那么a16一定可以被舍弃，也就是说，右指针可以往左边移动。
也就是说，那边指针指向的高度小，就收缩哪边的指针


class Solution {
    public int maxArea(int[] height) {
        int start=0,end = height.length-1;
        int max_area=0;
        while(start<end){
            max_area = Math.max(max_area,(end-start)*Math.min(height[start],height[end]));
            if(height[start]<height[end]){
                start++;
            }else{
                end--;
            }
        }
        return max_area;
    }
}

