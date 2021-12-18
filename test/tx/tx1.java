package tx;

import java.util.*;

public class tx1 {
    private static class Man {
        int num;
        int time;

        public Man(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Man> manList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            manList.add(new Man(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(manList, new Comparator<Man>() {
            @Override
            public int compare(Man o1, Man o2) {
                return o1.time - o2.time;
            }
        });
        int i = 0;
        int j = manList.size() - 1;
        int minTime = Integer.MAX_VALUE;
        while (i <= j && manList.get(i).num > 0 && manList.get(j).num > 0) {
            manList.get(i).num--;
            manList.get(j).num--;
            minTime = Math.min(manList.get(i).time + manList.get(j).time, minTime);
            if (manList.get(i).num == 0)
                i++;
            if (manList.get(j).num == 0)
                j--;
        }
        System.out.println(minTime);
        sc.close();
    }
}
