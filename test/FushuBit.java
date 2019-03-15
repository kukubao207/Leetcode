public class FushuBit {
    public static void main(String[] args){
        int count=0,n=-3;
        while(n!=0){
            count++;
            n=n&(n-1);
            System.out.println(n);
        }
        System.out.println(count);
    }
}


//在Java中,int 用32表示 ，
//  -3  用原码表示为   1000 0000 0000 0000 0000 0000 0000 0011
//  -3  用补码表示未   1111 1111 1111 1111 1111 1111 1111 1101（最高位符号位不变，其他位取反+1） 3+7*4=31

//