public class ZigZag {
    public static void main(String[] args){
        String s = "PAYPALISHIRING";
        int numRows=3;
        Solution.convert(s,numRows);
    }
    public static class Solution {
        public static String convert(String s, int numRows) {
            if(numRows==1)
                return s;
            boolean down = true;
            StringBuilder sb = new StringBuilder("");
            for(int i=0;i<numRows&&i<s.length();i++){
                int start = i;
                down=true;
                while(start<s.length()){
                    sb.append(s.substring(start,start+1));
                    if(i==0||i==numRows-1||down==true){
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
}
