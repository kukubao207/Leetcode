package Offer;

/**表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class StringIsOrNotNumeric {
    public boolean isNumeric(char[] str) {
        int state = 0;
        int[][] matrix = {{2,1, -1, 4},
                {-1, 1, 10, 8},
                {-1, 3, -1, 6},
                {-1, 3, 10, 9},
                {-1, 5, -1, -1},
                {-1, 5, 10, -1},
                {-1, 7, -1, -1},
                {-1, 7, 10, -1},
                {-1, 8, 10, -1},
                {-1, 9, 10, -1},
                {11, 13, -1, -1},
                {-1, 12, -1, -1},
                {-1, 12, -1, -1},
                {-1, 13, -1, -1}
        };
        for(char c : str){
            int n = charToInt(c);
            if(state == -1 || n == -1)
                return false;
            state = matrix[state][n];
        }
        return state == 1 || state == 3 || state == 5 || state == 7 || state == 8 || state == 9 || state == 12 ||state == 13;
    }
    public int charToInt(char c){
        if(c == '+' || c == '-')
            return 0;
        if(Character.isDigit(c))
            return 1;
        if(c == 'E' || c == 'e')
            return 2;
        if(c == '.')
            return 3;
        return -1;
    }
}
