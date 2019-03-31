import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WindowMax {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        new WindowMax().movingWindow(nums,3);
    }

    public ArrayList<Integer> movingWindow(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num.length == 0 || size == 0 || size > num.length)
            return res;
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=0;i<num.length;i++){
            if(!queue.isEmpty()){
                //如果当前队头已经不在窗口中
                if(i - queue.getFirst() >= size){
                    queue.removeFirst();
                }
                //如果队尾元素比当前值小，要出队
                while(!queue.isEmpty()&&num[i]>num[queue.getLast()]){
                    queue.removeLast();
                }
            }
            queue.offer(i);
            if(i>=size-1){
                res.add(num[queue.getFirst()]);
            }
        }
        System.out.println(res);
        return res;
    }
}
