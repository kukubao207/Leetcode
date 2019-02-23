118. Pascal's Triangle

        Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

        In Pascal's triangle, each number is the sum of the two numbers directly above it.

        Example:

        Input: 5
        Output:
        [
        [1],
        [1,1],
        [1,2,1],
        [1,3,3,1],
        [1,4,6,4,1]
        ]


class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows==0)
            return res;
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        if(numRows==1)
            return res;
        for(int i=1;i<numRows;i++){
            List<Integer> pre_level = res.get(i-1);
            List<Integer> cur_level = new ArrayList<>();
            cur_level.add(1);
            for(int j=0;j<pre_level.size();j++){
                int sum = j==pre_level.size()-1?pre_level.get(j):pre_level.get(j)+pre_level.get(j+1);
                cur_level.add(sum);
            }
            res.add(cur_level);
        }
        return res;
    }
}