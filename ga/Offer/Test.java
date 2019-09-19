package Offer;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        input = input.toLowerCase();
        String res = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            res += input.charAt(i) == ' '? '0' : input.charAt(i);
        }
        System.out.println(res);
    }


}