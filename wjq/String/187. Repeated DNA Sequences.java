187. Repeated DNA Sequences

All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]

我的思路
class Solution {
    private int window = 10;
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(int i=0;i<=s.length()-window;i++){
            String str = s.substring(i,i+window);
            int str_count = map.getOrDefault(str,0);
            if(str_count==1){
                res.add(str);
            }
            map.put(str,str_count+1);
        }
        return res;
    }
}