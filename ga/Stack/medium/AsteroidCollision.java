package Stack.medium;

import java.util.Stack;

//735. Asteroid Collision
//We are given an array asteroids of integers representing asteroids in a row.
//
//For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
//
//Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
//
//Example 1:
//Input:
//asteroids = [5, 10, -5]
//Output: [5, 10]
//Explanation:
//The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
//Example 2:
//Input:
//asteroids = [8, -8]
//Output: []
//Explanation:
//The 8 and -8 collide exploding each other.
//Example 3:
//Input:
//asteroids = [10, 2, -5]
//Output: [10]
//Explanation:
//The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
//Example 4:
//Input:
//asteroids = [-2, -1, 1, 2]
//Output: [-2, -1, 1, 2]
//Explanation:
//The -2 and -1 are moving left, while the 1 and 2 are moving right.
//Asteroids moving the same direction never meet, so no asteroids will meet each other.
//Note:
//
//The length of asteroids will be at most 10000.
//Each asteroid will be a non-zero integer in the range [-1000, 1000]..
public class AsteroidCollision {
    public static void main(String[] args){test();}
    private static Stack<Integer> stack = new Stack<Integer>();
    public static int[] asteroidCollision(int[] asteroids) {
        for(int i = 0; i < asteroids.length; i++){
            stack.push(asteroids[i]);
            while(stack.size() > 1 && stack.peek() < 0 && stack.get(stack.size() - 2) > 0){
                if(Math.abs(stack.peek()) > stack.get(stack.size() - 2)){
                    int tmp = stack.pop();
                    stack.pop();
                    stack.push(tmp);
                }else if(Math.abs(stack.peek()) < stack.get(stack.size() - 2))
                    stack.pop();
                else{
                    stack.pop();
                    stack.pop();
                }
            }
        }
        int[] res = new int[stack.size()];
        int i = res.length - 1;
        while(!stack.isEmpty()){
            res[i] = stack.pop();
            i--;
        }
        return res;
    }

    public static void test(){
        int[] asteroids = new int[]{10, 2, -5};
        int[] res = asteroidCollision(asteroids);
        for(int n : res)
            System.out.print(n + " ");
    }

}
