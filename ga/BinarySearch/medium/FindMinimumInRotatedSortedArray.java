package BinarySearch.medium;
//153. 寻找旋转排序数组中的最小值
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
//( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
//请找出其中最小的元素。
//
//你可以假设数组中不存在重复元素。
//
//示例 1:
//
//输入: [3,4,5,1,2]
//输出: 1
//示例 2:
//
//输入: [4,5,6,7,0,1,2]
//输出: 0
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] > nums[right]){//右逆序，左边肯定顺序
                left = mid + 1;
            }else{//右顺序
                right = mid;
            }
        }
        return nums[left];
    }

    //寻找旋转点
    public int findMin1(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i + 1])
                return nums[i + 1];
        }
        return nums[0];
    }

    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            // 左边顺序 & 右边顺序
            if(nums[left] < nums[mid] && nums[mid] < nums[right]){
                break;
            }
            // 左边顺序 & 右边逆序 => 在右边
            else if(nums[mid] > nums[right]){
                left = mid + 1;
            }
            // 左边逆序 & 右边顺序 => 在左边
            else{
                right = mid;
            }
            // 不存在左边逆序，右边逆序，因为原数组是递增序列
        }
        return nums[left];
    }
}
