package Math.hard;
//65. Valid Number
//Validate if a given string can be interpreted as a decimal number.
//
//Some examples:
//"0" => true
//" 0.1 " => true
//"abc" => false
//"1 a" => false
//"2e10" => true
//" -90e3   " => true
//" 1e" => false
//"e3" => false
//" 6e-1" => true
//" 99e2.5 " => false
//"53.5e93" => true
//" --6 " => false
//"-+3" => false
//"95a54e53" => false
//
//Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:
//
//Numbers 0-9
//Exponent - "e"
//Positive/negative sign - "+"/"-"
//Decimal point - "."
//Of course, the context of these characters also matters in the input.
//
//Update (2015-02-10):
//The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.
public class ValidNumber {
    public static boolean isNumber(String s) {
        s = s.trim();
        int state = 0;
        for (int i = 0; i < s.length(); i++) {
            int input = index(s.charAt(i));
            if (input == -1)
                return false;
            state = state_transfer_matrix[state][input];
            if (state == -1)
                return false;
        }
        return state == 1 || state == 3 || state == 4 || state == 7;
    }
    // 状态机
    public static int[][] state_transfer_matrix = {
            {-1, 5, 2, 1},
            {6, 3, -1, 1},
            {-1, 5, -1, 1},
            {6, -1, -1, 4},
            {6, -1, -1, 4},
            {-1, -1, -1, 4},
            {-1, -1, 8, 7},
            {-1, -1, -1, 7},
            {-1, -1, -1, 7}};
    public static int index(char input) {
        if (input == 'e')
            return 0;
        else if (input == '.')
            return 1;
        else if (input == '+' || input == '-')
            return 2;
        else if (Character.isDigit(input))
            return 3;
        else
            return -1;
    }
}
