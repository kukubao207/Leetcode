package Math;
//223. Rectangle Area
//Find the total area covered by two rectilinear rectangles in a 2D plane.
//
//Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
//
//Rectangle Area
//
//Example:
//
//Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
//Output: 45
//Note:
//
//Assume that the total area is never beyond the maximum possible value of int.
public class RectangleArea {
    public static void main(String[] args){
        test();
    }
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int l1 = C - A;
        int w1 = D - B;
        int l2 = G - E;
        int w2 = H - F;
        //如果不重叠
        if(A >= G || E >= C || F >= D || B >= H){
            return (l1 * w1) + (l2 * w2);
        }
        //重叠部分的四个边界
        int left = E > A ? E : A;
        int right = G > C ? C : G;
        int top = H > D ? D : H;
        int down = F > B ? F : B;
        return (l1 * w1) + (l2 * w2) - (right - left) * (top - down);
    }

    public static void test(){
        int A = -3;
        int B = 0;
        int C = 3;
        int D = 4;
        int E = 0;
        int F = -1;
        int G = 9;
        int H = 2;
        System.out.println(computeArea(A, B, C, D, E, F, G, H));
    }
}
