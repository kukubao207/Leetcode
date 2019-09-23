package Offer;

/**二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class isPostorderOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0)
            return false;
        return helper(sequence, 0, sequence.length - 1);

    }
    public boolean helper(int[] arr, int start, int end){
        if(start >= end)
            return true;
        int i = start;
        for(; i < end; i++){
            if(arr[i] > arr[end])
                break;
        }
        int j = i;
        for(; j < end; j++){
            if(arr[j] < arr[end])
                return false;
        }
        return helper(arr, start, i - 1) && helper(arr, i, end - 1);
    }
}
