package Offer;

/**数组中超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfInArr {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0)
            return 0;
        int n = 0;
        int count = 1;
        for(int i = 0; i < array.length; i++){
            if(array[i] != n){
                count--;
                if(count == 0){
                    n = array[i];
                    count = 1;
                }
            }else{
                count++;
            }
        }
        int sum = 0;
        for(int i = 0; i < array.length; i++)
            if(array[i] == n)
                sum++;
        return sum > array.length / 2 ? n : 0;
    }
}
