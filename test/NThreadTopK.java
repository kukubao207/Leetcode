package tx;

public class HasStatic{
    private static int x=100;
    private boolean flag = false;
    public static void main(String args[])
    {
        HasStatic hs1 = new HasStatic();
        hs1.x++;
        HasStatic hs2 = new HasStatic();
        hs2.x++;
        hs1 = new HasStatic();
        hs1.x++;
        HasStatic.x--;
        System.out.println("x=" + x);
    }
    public int test () throws InterruptedException{
        HasStatic hasStatic = new HasStatic();
        synchronized (hasStatic){
            while(true){
                if(this.flag){
                    hasStatic.wait();
                }
            }
        }
    }
    public void setFlag(){
        this.flag=!this.flag;
    }
}