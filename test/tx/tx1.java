package tx;

import java.util.*;

public class tx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] in = str.split(" ");
        ArrayList<String> res = new ArrayList<>();
        for (int i = 1; i < in.length; i++) {
            int start = 0;
            while (in[i].length() != 0) {
                String temp = in[i].substring(start, Math.min(in[i].length(), start + 8));
                res.add(temp);
                in[i] = in[i].substring(Math.min(start + 8, in[i].length()));
            }
        }
        Collections.sort(res);
        List<String> resres = new ArrayList<>();
        for(String s:res){
            StringBuilder sb = new StringBuilder(s);
            while(sb.length()<8){
                sb.append("0");
            }
            resres.add(sb.toString());
        }
        System.out.println(resres);
    }

}
