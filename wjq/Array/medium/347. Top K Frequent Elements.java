347. Top K Frequent Elements
        Given a non-empty array of integers, return the k most frequent elements.

        Example 1:

        Input: nums = [1,1,1,2,2,3], k = 2
        Output: [1,2]
        Example 2:

        Input: nums = [1], k = 1
        Output: [1]
        You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
        Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

我的思路
O(nlogn)时间
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Comparator<P> cmp = new Comparator<P>() {
            @Override
            public int compare(P o1, P o2) {
                return o2.count-o1.count;
            }
        };
        Queue<P> queue = new PriorityQueue<>(cmp);
        for(Integer key:map.keySet())
            queue.add(new P(key,map.get(key)));
        for(int i=0;i<k;i++)
            list.add(queue.poll().key);
        return list;
    }
    public class P{
        private int key;
        private int count;
        P(int key,int count){
            this.key=key;
            this.count=count;
        }
    }
}