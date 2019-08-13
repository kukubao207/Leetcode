package Sort;

/**
 * 题目描述
 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 输入描述:
 题目保证输入的数组中没有的相同的数字

 数据范围：

 对于%50的数据,size<=10^4

 对于%75的数据,size<=10^5

 对于%100的数据,size<=2*10^5

 示例1
 输入
 1,2,3,4,5,6,7,0
 输出
 7
 */
public class InversePairs {
    public static void main(String[] args){
        test();
    }
    //利用归并排序
    //假如有两个有序数组A和数组B 每次数组A的索引i向后移动时 sum加上数组B的索引j的值
    // 一次归并后 sum求的是数组A中的每个数在数组B中有多少个数比其小
    //完整归并以后 求得的结果是在数组arr中逆序对的个数
    public static int sum = 0;
    public static void InversePairs(int [] arr, int left, int right) {
        if(left < right){
            int mid = left + (right - left) / 2;
            InversePairs(arr, left, mid);
            InversePairs(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int i = left;
        int j = mid + 1;
        int[] tmp = new int[right - left + 1];//用来存放有序数组
        int k = 0;//记录数组的索引
        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
                tmp[k++] = arr[i++];
                if(sum > 1000000007)//mod一般都在中间处理
                    sum = sum % 1000000007;//防止中途计算的时候sum就溢出 所以对每次的sum都取模 （6 % 7 = 1 % 7 + 5 % 7）最后结果取模就等于每次取模后相加
                sum += j - (mid + 1);//注意一下  sum求和的时候j应该从0开始 但是实际不是
            }
            else
                tmp[k++] = arr[j++];
        }
        while(i <= mid){
            tmp[k++] = arr[i++];
            if(sum > 1000000007)
                sum = sum % 1000000007;
            sum += j - (mid + 1);
        }
        while(j <= right){
            tmp[k++] = arr[j++];
        }
        //将temp中的元素全部拷贝到原数组中
        for (int t = 0; t < tmp.length; t++) {//每一次归并 要修改原数组
            arr[t + left] = tmp[t];
        }
    }

    public static  void test(){
        int arr[] = new int[]{1,2,3,4,5,6,7,0};
        InversePairs(arr, 0, arr.length - 1);
        System.out.print(sum % 1000000007);
    }
}
