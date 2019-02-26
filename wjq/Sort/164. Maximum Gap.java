164. Maximum Gap

        Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

        Return 0 if the array contains less than 2 elements.

        Example 1:

        Input: [3,6,9,1]
        Output: 3
        Explanation: The sorted form of the array is [1,3,6,9], either
        (3,6) or (6,9) has the maximum difference 3.
        Example 2:

        Input: [10]
        Output: 0
        Explanation: The array contains less than 2 elements, therefore return 0.

题意
给一个未排序的数组，以O（n)时间O（n）空间找出  该数组排序之后相邻元素之差的最大值

思路
假设数组最小值为min,最大值为max,数组元素n个，
那么排序相邻元素之差的最大值至少大于等于 gap =  (max-min)/(n-1)
那么我们可以定义n-1个桶， 根据下标（当前元素与min之差/gap）分配元素到每个桶中，
可知相同桶里面的元素的差的最大值一定是小于等于gap的，不然不会分配到一个桶里
我们只需要去比较  前一个桶的最大值 和 后一个桶的最小值 之差即可找出 要求的结果
也就是说，
我们的桶，需要记录当前桶中的最大值和最小值。
也就有了 最大值桶和最小值桶。

class Solution {
    public int maximumGap(int[] nums) {
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