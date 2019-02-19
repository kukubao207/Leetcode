93. Restore IP Addresses

        Given a string containing only digits, restore it by returning all possible valid IP address combinations.

        Example:

        Input: "25525511135"
        Output: ["255.255.11.135", "255.255.111.35"]


class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        for(int a=1;a<=3;a++){
            for(int b=1;b<=3;b++){
                for(int c=1;c<=3;c++){
                    for(int d=1;d<=3;d++){
                        if(a+b+c+d!=s.length())
                            continue;
                        if(isValid(s.substring(0,a))&&isValid(s.substring(a,a+b))&&isValid(s.substring(a+b,a+b+c))&&isValid(s.substring(a+b+c,a+b+c+d))){
                            res.add(s.substring(0,a)+"."+s.substring(a,a+b)+"."+s.substring(a+b,a+b+c)+"."+s.substring(a+b+c,a+b+c+d));
                        }
                    }
                }
            }
        }
        return res;
    }
    public boolean isValid(String str){
        if(str.length()==0||(str.charAt(0)=='0'&&str.length()!=1)||Integer.parseInt(str)>255)
            return false;
        return true;
    }
}