package Stack.hard;

import java.util.*;

/**
 * 726.Given a chemical formula (given as a string), return the count of each atom.

 An atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.

 1 or more digits representing the count of that element may follow if the count is greater than 1. If the count is 1, no digits will follow. For example, H2O and H2O2 are possible, but H1O2 is impossible.

 Two formulas concatenated together produce another formula. For example, H2O2He3Mg4 is also a formula.

 A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 are formulas.

 Given a formula, output the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.
 Example 1:
 Input:
 formula = "H2O"
 Output: "H2O"
 Explanation:
 The count of elements are {'H': 2, 'O': 1}.

 Example 2:
 Input:
 formula = "Mg(OH)2"
 Output: "H2MgO2"
 Explanation:
 The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.

 Example 3:
 Input:
 formula = "K4(ON(SO3)2)2"
 Output: "K4N2O14S4"
 Explanation:
 The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
 */
public class NumberofAtoms {
    public static void main(String[] args) {
        test();
    }
    //写的好长啊。。。。。
    public static String countOfAtoms(String formula) {
        Stack<String> stack = new Stack<>();
        Map<String, Integer> map = new TreeMap<>();//自然排序
        for (int i = 0; i < formula.length(); i++) {
            String s = "";
            String count = "";
            if (Character.isUpperCase(formula.charAt(i))) {
                s = formula.charAt(i) + "";
                i++;
                while (i < formula.length() && Character.isLowerCase(formula.charAt(i))) {
                    s = s + formula.charAt(i);
                    i++;
                }
                stack.push(s);
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    count = count + formula.charAt(i);
                    i++;
                }
                stack.push(count == "" ? "1" : count);
                i--;
            }
            else{
                stack.push(formula.charAt(i) + "");
                if(stack.peek().equals(")")){
                    Stack<String> tmp = new Stack<>();
                    String num = "";
                    i++;
                    while(i < formula.length() && Character.isDigit(formula.charAt(i))){
                        num += formula.charAt(i);
                        i++;
                    }
                    int n = num == "" ? 1 : Integer.parseInt(num);
                    stack.pop();
                    while(!stack.peek().equals("(")){
                        String ss = stack.pop();
                        if(isDigit(ss))
                            tmp.push((Integer.parseInt(ss) * n) + "");
                        else
                            tmp.push(ss);
                    }
                    stack.pop();
                    while(!tmp.isEmpty())
                        stack.push(tmp.pop());
                    i--;
                }
            }
        }
//        System.out.println(stack);
        while(!stack.isEmpty()){
            String value = stack.pop();
            String key = stack.pop();
            if(map.containsKey(key))
                map.put(key, map.get(key) + Integer.parseInt(value));
            else
                map.put(key, Integer.parseInt(value));
        }
        String res = "";
        Set<String> keySet = map.keySet();
        Iterator<String> iter = keySet.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            int value = map.get(key);
            if (value != 1)
                res += key + value;
            else
                res += key;
        }
        return res;
    }


    public static boolean isDigit(String str){
        char[] strArr = str.toCharArray();
        for(int i = 0; i < strArr.length; i++) {
            if(Character.isDigit(strArr[i]) == false) {
                return false;
            }
        }
        return true;
    }
    public static void test(){
        String s1 = "H2O";
        String s2 = "Mg(OH)2";
        String s3 = "K4(ON(SO3)2)2";
        System.out.println(countOfAtoms(s1));
        System.out.println(countOfAtoms(s2));
        System.out.println(countOfAtoms(s3));
    }
}
