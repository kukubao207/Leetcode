49. Group Anagrams
        Given an array of strings, group anagrams together.

        Example:

        Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
        Output:
        [
        ["ate","eat","tea"],
        ["nat","tan"],
        ["bat"]
        ]
        Note:

        All inputs will be in lowercase.
        The order of your output does not matter.

我的思路
这道题非常流畅自然就解出来了
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> m = new HashMap<>();
        for(String str:strs){
            char[] cur_str = str.toCharArray();
            Arrays.sort(cur_str);
            String new_str = new String(cur_str);
            if(m.containsKey(new_str)){
                List<String> list = m.get(new_str);
                list.add(str);
            }else{
                List<String> new_list = new ArrayList<String>();
                new_list.add(str);
                m.put(new_str,new_list);
                res.add(new_list);
            }
        }
        return res;
    }
}

别人的思路
public static List<List<String>> groupAnagrams(String[] strs) {
    int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z

    List<List<String>> res = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    for (String s : strs) {
        int key = 1;
        for (char c : s.toCharArray()) {
            key *= prime[c - 'a'];
        }
        List<String> t;
        if (map.containsKey(key)) {
            t = res.get(map.get(key));
        } else {
            t = new ArrayList<>();
            res.add(t);
            map.put(key, res.size() - 1);
        }
        t.add(s);
    }
    return res;
}