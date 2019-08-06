package String;

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
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String[] testarray = {"0",
                " 0.1 ",
                "abc",
                "1 a",
                "2e10",
                " -90e3   ",
                " 1e",
                "e3",
                " 6e-1",
                " 99e2.5 ",
                "53.5e93",
                " --6",
                " -+3",
                "95a54e53"};
        for (String testcase : testarray) {
            System.out.println(testcase + " : " + isNumber(testcase));
        }
    }

    public static boolean isNumber(String s) {
        return false;
    }
}

