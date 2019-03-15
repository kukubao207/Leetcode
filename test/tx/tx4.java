package tx;

import java.util.ArrayList;
import java.util.List;

public class tx4 {
    public static void main(String[] args){
        //List<String> res = Permutation("abc");
        ArrayList<String> res2 = new ArrayList<String>();
        boolean[] vis = new boolean[3];
        dfs("aaa","",res2,vis);
        System.out.println(res2);
    }
    public static ArrayList<String> Permutation(String str) {
        if(str.equals(""))
            return new ArrayList<String>();
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<StringBuilder> temp = new ArrayList<>();
        temp.add(new StringBuilder());
        for(int i=0;i<str.length();i++){
            String cur = str.substring(i,i+1);
            ArrayList<StringBuilder> t = new ArrayList<>();
            for(StringBuilder s:temp){
                for(int j=0;j<=s.length();j++){
                    StringBuilder sb = new StringBuilder(s);
                    while(j<s.length()&&(""+s.charAt(j)).equals(cur))
                        j++;
                    t.add(sb.insert(j,cur));
                }
            }
            System.out.println(t);
            temp = t;
        }
        for(int i=0;i<temp.size();i++)
            res.add(temp.get(i).toString());
        return res;
    }

    public static void dfs(String str,String temp,ArrayList<String> res,boolean[] vis){
        if(temp.length()==str.length()){
            String tttt = new String(temp);
            res.add(tttt);
            return;
        }
        for(int i=0;i<str.length();i++){
            if(vis[i]==true)
                continue;
            if(i>=1&&str.charAt(i)==str.charAt(i-1)&&vis[i-1]==false)
                continue;
            vis[i]=true;
            dfs(str,temp+str.charAt(i),res,vis);
            vis[i]=false;
        }
    }
}
