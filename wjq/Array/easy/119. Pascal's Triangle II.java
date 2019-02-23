119. Pascal's Triangle II

        Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

        Note that the row index starts from 0.


        In Pascal's triangle, each number is the sum of the two numbers directly above it.

        Example:

        Input: 3
        Output: [1,3,3,1]
        Follow up:

        Could you optimize your algorithm to use only O(k) extra space?

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if(rowIndex<0)
            return res;
        for(int i=0;i<rowIndex+1;i++){
            res.add(0,1);
            for(int j=1;j<res.size()-1;j++){
                res.set(j,res.get(j)+res.get(j+1));
            }
        }
        return res;
    }
}

class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] A = new int[rowIndex+1];
        A[0]=1;
        for(int i=1;i<rowIndex+1;i++){
            for(int j=i;j>=1;j--){
                A[j]=A[j-1]+A[j];
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<A.length;i++){
            res.add(A[i]);
        }
        return res;
    }
}