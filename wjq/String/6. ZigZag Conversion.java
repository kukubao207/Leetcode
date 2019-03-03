6. ZigZag Conversion
        The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

        P   A   H   N
        A P L S I I G
        Y   I   R
        And then read line by line: "PAHNAPLSIIGYIR"

        Write the code that will take a string and make this conversion given a number of rows:

        string convert(string s, int numRows);
        Example 1:

        Input: s = "PAYPALISHIRING", numRows = 3
        Output: "PAHNAPLSIIGYIR"
        Example 2:

        Input: s = "PAYPALISHIRING", numRows = 4
        Output: "PINALSIGYAHRPI"
        Explanation:

        P     I    N
        A   L S  I G
        Y A   H R
        P     I


class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        boolean down = true;
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<numRows&&i<s.length();i++){
            int start = i;
            down=true;
            while(start<s.length()){
                sb.append(s.substring(start,start+1));
                if(i==0){
                    start += 2*(numRows-i-1);
                    continue;
                }else if(i==numRows-1){
                    start += 2*i;
                    continue;
                }
                else if(down==true){
                    start += 2*(numRows-i-1);
                    down=false;
                }else{
                    start += 2*i;
                    down=true;
                }
            }
        }
        return sb.toString();
    }
}


class Solution {
    public String convert(String s, int numRows) {
        if(numRows<=1)
            return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++)
            sb[i]=new StringBuilder("");
        char[] c = s.toCharArray();

        int i=0;
        while(i<c.length){
            for(int idx=0;idx<numRows&&i<c.length;idx++){
                sb[idx].append(c[i++]);
            }
            for(int idx=numRows-2;idx>0&&i<c.length;idx--){
                sb[idx].append(c[i++]);
            }
        }
        for(i=1;i<numRows;i++){
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}