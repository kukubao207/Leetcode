import java.util.*;

public class ArrayListInsert {
    public static void main(String args[]) {
        int[] A = {3, 2, 1, 5, 6, 3};
        int k = 2;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<A.length;i++)
            list.add(A[i]);
        list.stream().forEach(e->{System.out.print(e+" ");});
        System.out.println();

        list.add(6,100);
        list.stream().forEach(e->{System.out.print(e+" ");});
        System.out.println();
        List<Integer> l2 = (List<Integer>) ((ArrayList<Integer>) list).clone();

        List<List<Integer>> res = new ArrayList<>();
        res.add(list);
        List<List<Integer>> test = new ArrayList<>(res);
        List<List<Integer>> temp = (List<List<Integer>>)((ArrayList<List<Integer>>) res).clone();
        for(List<Integer> l :temp){
            for (int n:l)
                System.out.println(n);
        }
        for(List<Integer> l :test){
            for (int n:l)
                System.out.println(n);
        }
        list.stream().forEach(e->{System.out.print(e+" ");});
        System.out.println();
        //int ans = findKthLargest(A, k);
        //int ans2 = partition2(A,0,5);
    }
}
