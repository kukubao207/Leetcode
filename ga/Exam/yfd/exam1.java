package Exam.yfd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class exam1 {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int C = sc.nextInt();
//        int[] result = new int[C];
//        for(int i = 0; i < C; i++){
//            int n = sc.nextInt();
//            int[] plays = new int[n];
//            for(int j = 0; j < n; j++){
//                plays[j] = sc.nextInt();
//            }
//
//
//        }
//    }
//    public int getTeams(int[] plays, int n){
//        if(n < 3)
//            return 0;
//        int res = 0;
//        Arrays.sort(plays);
//        int j = n - 1;
//        int i = j - 2;
//        while(i < j){
//            plays[j] -= plays[i];
//            j--;
//        }
//
//        return -1;
//    }

    static class A{
        public String show(D d){
            return ("AD");
        }
        public String show(A a){
            return ("AA");
        }
        static class B extends A{
            public String show(B b){
                return ("BB");
            }
            public String show(A a){
                return ("BA");
            }
        }
        static class C extends B{}
        static class D extends B{}
        public static class Test{
            List list = new ArrayList<>();


            public static void main(String[] args)
            {
                A a = new A();
                B b = new B();
                C c = new C();
                D d = new D();
                System.out.println(a.show(b) + "-" + a.show(c) + "-" + a.show(d) + "-" + b.show(a) + "-" + b.show(c) + "-" + b.show(d));
            }
        }
    }


}
