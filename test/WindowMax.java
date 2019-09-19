import java.util.*;

public class WindowMax {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(new WindowMax().movingWindow(nums,3));
    }
    private class MaxQueue {
        private Deque<Integer> queue = new LinkedList<Integer>();
        public void push(int t) {
            while (!queue.isEmpty() && t > queue.getLast()) {
                queue.removeLast();
            }
            queue.addLast(t);

        }
        public void pop(int x) {
            if (!queue.isEmpty() && queue.getFirst() == x)
                queue.removeFirst();
        }
        public int max() {
            return queue.getFirst();
        }

    }
    public ArrayList<Integer> movingWindow(int[] num, int size) {
        MaxQueue queue = new MaxQueue();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            if (i < size - 1) {
                queue.push(num[i]);
            } else {
                queue.push(num[i]);
                res.add(queue.max());
                queue.pop(num[i - size + 1]);
            }
        }
        return res;
    }
}
