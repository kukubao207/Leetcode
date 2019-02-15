67. Add Binary

Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

class Solution {
    public String addBinary(String a, String b) {
        String res = "";
        a=new StringBuilder(a).reverse().toString();
        b=new StringBuilder(b).reverse().toString();
        int jinwei=0,sum=0;
        for(int i=0;i<Math.max(a.length(),b.length());i++){
            if(i<a.length()&&i<b.length())
                sum=a.charAt(i)-'0'+b.charAt(i)-'0'+jinwei;
            else if(i<a.length())
                sum=a.charAt(i)-'0'+jinwei;
            else if(i<b.length())
                sum=b.charAt(i)-'0'+jinwei;
            res=sum%2+res;
            jinwei = sum/2;
        }
        if(jinwei!=0)
            res=jinwei+res;
        return res;
    }
}

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder("");
        int jinwei=0, sum=0;
        int i=a.length()-1, j=b.length()-1;
        while(i>=0||j>=0){
            if(i>=0&&j>=0)
                sum=a.charAt(i--)-'0'+b.charAt(j--)-'0'+jinwei;
            else if(i>=0)
                sum=a.charAt(i--)-'0'+jinwei;
            else if(j>=0)
                sum=b.charAt(j--)-'0'+jinwei;
            sb.append(sum%2);
            jinwei = sum/2;
        }
        if(jinwei!=0)
            sb.append(jinwei);
        return sb.reverse().toString();
    }
}
