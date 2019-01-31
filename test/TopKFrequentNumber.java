import java.util.*;

public class TopKFrequentNumber {
    public static void main(String[] args){
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,2,2,3,4,4,4,4,4,6,6,6,6,6,6,6};
        int k=3;
        TopKFrequentNumber topKFrequentNumber = new TopKFrequentNumber();
        List<Integer> list = topKFrequentNumber.topKFrequent(nums,k);
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer>[] bucket = new List[nums.length+1];
        for(Integer key:map.keySet()){
            int frequency = map.get(key);
            if(bucket[frequency]==null){
                bucket[frequency]=new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        // 1 1 1 2 2 3 3 k=2，这种情况，本来就不知道该输出 1 2 还是 1 3 题目就没说，所以这里用addAll
        for(int i=nums.length;i>=0&&list.size()<k;i--){
            if(bucket[i]!=null){
                list.addAll(bucket[i]);
            }
        }
        return list;
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Queue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((o1,o2)->{return o2.getValue()-o1.getValue();});
        for(Map.Entry<Integer,Integer> m:map.entrySet())
            queue.add(m);
        for(int i=0;i<k;i++)
            list.add(queue.poll().getKey());
        return list;
    }
}
