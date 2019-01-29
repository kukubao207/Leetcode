228. Summary Ranges

Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.


我的思路，就模拟
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if(nums.length==0)
            return result;
        if(nums.length==1){
            result.add(String.valueOf(nums[0]));
            return result;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(nums[0]));
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]-nums[i-1]==1&&nums[i+1]-nums[i]!=1){
                sb.append("->"+String.valueOf(nums[i]));
            }else if(nums[i]-nums[i-1]!=1){
                result.add(sb.toString());
                sb = new StringBuilder(String.valueOf(nums[i]));
            }
        }
        if(!sb.toString().equals("")&&nums[nums.length-1]-nums[nums.length-2]!=1){
            result.add(sb.toString());
        }else if(!sb.toString().equals("")&&nums[nums.length-1]-nums[nums.length-2]==1){
            sb.append("->"+String.valueOf(nums[nums.length-1]));
        }
        if(nums[nums.length-1]-nums[nums.length-2]!=1){
            sb = new StringBuilder(String.valueOf(nums[nums.length-1]));
        }
        result.add(sb.toString());
        return result;

    }
}

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if(nums.length==0)
            return result;
        if(nums.length==1){
            result.add(String.valueOf(nums[0]));
            return result;
        }
        StringBuilder sb = new StringBuilder();
        int start=0,end=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]==1)
                continue;
            end = i-1;
            if(start!=end){
                sb.append(String.format("%d->%d",nums[start],nums[end]));
            }else{
                sb.append(String.valueOf(nums[start]));
            }
            result.add(sb.toString());
            sb = new StringBuilder();
            start = i;
        }
        if(start!=nums.length-1){
            sb.append(String.format("%d->%d",nums[start],nums[nums.length-1]));
        }else{
            sb.append(String.valueOf(nums[nums.length-1]));
        }
        result.add(sb.toString());
        return result;
    }
}


别人的思路
    List<String> list=new ArrayList();
    if(nums.length==1){
        list.add(nums[0]+"");
        return list;
    }
    for(int i=0;i<nums.length;i++){
        int a=nums[i];
        while(i+1<nums.length&&(nums[i+1]-nums[i])==1){
            i++;
        }
        if(a!=nums[i]){
            list.add(a+"->"+nums[i]);
        }else{
            list.add(a+"");
        }
    }
    return list;
