package sort;

public class MergeSort {
    private static int count1 =1,count2=1;
    public static void main(String[] args){
        int[] a = {3,5,1,9,-5,2,4,6};
        mergeSort(a,0,a.length-1);
        System.out.println(count1);
        int[] b = {1,2,-2,-4,6,9,10,3};
        mergeSort2(b);
        System.out.println(count2);
    }

    public static void merge(int[] a, int start, int mid, int end){
        int[] help = new int[end-start+1];              //一个辅助数组，所以空间复杂度为O(n）
        int m=start,n=mid+1,k=0;
        while(m<=mid&&n<=end){
            if(a[m]<a[n])
                help[k++]=a[m++];
            else
                help[k++]=a[n++];
        }
        while(m<=mid){
            help[k++]=a[m++];
        }
        while(n<=end){
            help[k++]=a[n++];
        }
        for(int i=start;i<=end;i++){
            a[i]=help[i-start];
        }
    }
    //递归版本的归并过程有点像二叉树的后根遍历，只不过把 "输出" 变成了 "合并"
    public static void mergeSort(int[] a,int start,int end){
        if(start==end)
            return;
        int mid = start + (end-start)/2;
        mergeSort(a,start,mid);
        mergeSort(a,mid+1,end);
        merge(a,start,mid,end);
        System.out.println("a,start1:"+start+",end1:"+mid+",start2:"+(mid+1)+",end2:"+end);
    }

    //迭代版本，枚举步长（1,2,4,8）,
    //当步长为1的时候， 合并 0,1  2,3  4,5  6,7
    //当步长为2的时候,  合并 01,23   45,67
    //当步长为4的时候,  合并 0123 4567
    public static void mergeSort2(int[] a){
        for(int step=1;step<a.length;step*=2){
            for(int i=0;i<a.length;i+=step*2){
                int start = i,mid = Math.min(i+step-1,a.length-1), end = Math.min(i+2*step-1,a.length-1);   //key
                merge(a,start,mid,end);
                System.out.println("a,start1:"+start+",end1:"+mid+",start2:"+(mid+1)+",end2:"+end);
            }
        }
    }
}

