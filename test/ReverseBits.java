public class ReverseBits {
    public static void main(String[] args){
        Solution solution = new Solution();
        //00000010100101000001111010011100
        int n = 43261596;
        solution.reverseBits(n);

    }
    public static class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {

            //判断符号
            boolean flag = false;
            if(n<0) {
                flag = true;
                n*=-1;
            }

            //转2进制
            char[] bits = new char[32];
            for(int i=bits.length-1;i>=0;i--){
                if(n!=0) {
                    bits[i] = (char) (n % 2 + '0');
                    n /= 2;
                }else {
                    bits[i] = '0';
                }
            }

            //取反+1
            if(flag = true){
                for(int i=0;i<bits.length;i++){
                    bits[i]= bits[i]=='1'?'0':'1';
                }
                int l=bits.length-1;
                while(true){
                    if(bits[l]=='0'){
                        bits[l]='1';
                        break;
                    }else{
                        bits[l]='0';
                        l++;
                    }
                }
            }

            //   964173168 (00111001011110000010100101000000)
            reverse(bits,0,31);
            //转十进制
            int ans=0,mul=1;
            for(int i=bits.length-1;i>=0;i--){
                ans+=(bits[i]-'0')*mul;
                mul*=2;
            }
            return ans;
        }
        public void reverse(char[] bits,int left,int right){
            while(left<right){
                char temp=bits[left];
                bits[left]=bits[right];
                bits[right]=temp;
                left++;
                right--;
            }
        }
    }
}
