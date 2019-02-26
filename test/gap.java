import java.util.Arrays;

public class gap {
    public static void main(String[] args){
        int[] nums={3,6,9,1};
        Solution.maximumGap(nums);
    }
    public static class Solution {
        public static int maximumGap(int[] nums) {
            if(nums.length<2)
                return 0;

            //1.计算gap = (max-min)/(N-1),  结果一定比这个值要大
            int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
            for(int i=0;i<nums.length;i++){
                min = Math.min(nums[i],min);
                max = Math.max(nums[i],max);
            }
            int gap = (int)Math.ceil((double)(max-min)/(nums.length-1));

            //2.把所有元素填入最大值桶和最小值桶中
            int[] min_bucket = new int[nums.length-1];
            int[] max_bucket = new int[nums.length-1];
            Arrays.fill(min_bucket,Integer.MAX_VALUE);
            Arrays.fill(max_bucket,Integer.MIN_VALUE);
            for(int i=0;i<nums.length;i++){
                if(nums[i]==min||nums[i]==max)
                    continue;
                int idx = (nums[i]-min)/gap;
                min_bucket[idx]=Math.min(min_bucket[idx],nums[i]);
                max_bucket[idx]=Math.max(max_bucket[idx],nums[i]);
            }

            //3.比较后一个桶的最小值与前一个桶的最大值之间的间距
            int ans = Integer.MIN_VALUE,previous=min;
            for(int i=0;i<min_bucket.length;i++){
                if(min_bucket[i]==Integer.MAX_VALUE&&max_bucket[i]==Integer.MIN_VALUE)
                    continue;
                ans = Math.max(ans,min_bucket[i]-previous);
                previous = max_bucket[i];
            }
            ans = Math.max(ans,max-previous);
            return ans;
        }
    }
}
