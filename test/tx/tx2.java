package tx;

import java.util.*;

public class tx2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        str=str.toLowerCase();
        //System.out.println(remove(str).charAt(0));
        System.out.println("res="+remove(str));
        Stack<Integer> sta = new Stack<>();
    }
    public static String remove(String s) {
        if(s.length()==0)
            return "";
        int[] letter = new int[26];
        int index = 0;
        for (int i = 0; i < s.length(); i++)
            letter[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(index))
                index = i;
            letter[s.charAt(i)-'a']--;
            if (letter[s.charAt(i) - 'a'] == 0)
                break;
        }
        String temp = s.substring(index + 1).replaceAll("" + s.charAt(index), "");
        System.out.println("before remove: " + temp);
        String remove_temp = remove(temp);
        System.out.println("after remove: " + remove_temp);
        return s.charAt(index) + remove_temp;
    }
}
