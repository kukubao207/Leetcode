package Offer;

import java.util.ArrayList;
import java.util.Arrays;

/**字符串的排序
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class StringSort {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str == null || str.length() == 0)
            return res;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        str = String.valueOf(chars);
        int[] vis = new int[str.length()];
        dfs(str, res, "", vis);
        return res;
    }
    public void dfs(String str, ArrayList<String> res, String tmp, int[] vis){
        if(tmp.length() == str.length()){
            res.add(tmp);
            return;
        }
        char lastUsed = '#';
        for(int i = 0; i < str.length(); i++){
            if(vis[i] == 0 && str.charAt(i) != lastUsed){
                tmp += str.charAt(i);
                vis[i] = 1;
                dfs(str, res, tmp, vis);
                vis[i] = 0;
                lastUsed = str.charAt(i);
                tmp = tmp.substring(0, tmp.length() - 1);
            }
        }
    }
}
