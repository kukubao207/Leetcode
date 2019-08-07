package String.hard;

import java.util.ArrayList;

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


    //1.把当前的输入分成几类，再用几个标志位来判断当前是否合法
    //判断前置(只判断前面的是否正确 不然前后判断容易混乱)
    public static boolean isNumber(String s) {
        s = s.trim();
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        for(int i = 0; i < s.length(); i++){
            if('0' <= s.charAt(i) && s.charAt(i) <= '9'){
                numberSeen = true;
                numberAfterE = true;
            }else if(s.charAt(i) == '.') {
                if(eSeen || pointSeen)
                    return false;
                pointSeen = true;
            }else if(s.charAt(i) == 'e'){
                if(eSeen || !numberSeen)
                    return false;
                numberAfterE = false;
                eSeen = true;
            }else if(s.charAt(i) == '-' || s.charAt(i) == '+'){
                if(i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            }else
                return false;
        }
        return numberSeen && numberAfterE;
    }

    //2.自动机
    //状态机
    public static boolean isNumber1(String s) {
        int state = 0;
        s = s.trim();//去除头尾的空格
        //遍历所有字符，当做输入
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                //输入正负号
                case '+':
                case '-':
                    if (state == 0) {
                        state = 1;
                    } else if (state == 4) {
                        state = 6;
                    } else {
                        return false;
                    }
                    break;
                //输入数字
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    //根据当前状态去跳转
                    switch (state) {
                        case 0:
                        case 1:
                        case 2:
                            state = 2;
                            break;
                        case 3:
                            state = 3;
                            break;
                        case 4:
                        case 5:
                        case 6:
                            state = 5;
                            break;
                        case 7:
                            state = 8;
                            break;
                        case 8:
                            state = 8;
                            break;
                        default:
                            return false;
                    }
                    break;
                //小数点
                case '.':
                    switch (state) {
                        case 0:
                        case 1:
                            state = 7;
                            break;
                        case 2:
                            state = 3;
                            break;
                        default:
                            return false;
                    }
                    break;
                //e
                case 'e':
                    switch (state) {
                        case 2:
                        case 3:
                        case 8:
                            state = 4;
                            break;
                        default:
                            return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        //橙色部分的状态代表合法数字
        return state == 2 || state == 3 || state == 5 || state == 8;
    }
    //3.责任链
    //每个类只判断一种类型。
    // 比如判断是否是正数的类，判断是否是小数的类，判断是否是科学计数法的类，这样每个类只关心自己的部分，出了问题很好排查，而且互不影响。

    //每个类都实现这个接口
    interface NumberValidate{
        boolean validate(String s);
    }
    //定义一个抽象类，用来检查一些基础的操作，是否为空，去掉首尾空格，去掉 +/-
    //doValidate 交给子类自己去实现
    abstract class  NumberValidateTemplate implements NumberValidate{
        public boolean validate(String s)
        {
            if (checkStringEmpty(s))
            {
                return false;
            }
            s = checkAndProcessHeader(s);
            if(s.length() == 0)
                return false;
            return doValidate(s);
        }
        private boolean checkStringEmpty(String s)
        {
            if (s.equals(""))
            {
                return true;
            }

            return false;
        }
        private String checkAndProcessHeader(String value)
        {
            value = value.trim();

            if (value.startsWith("+") || value.startsWith("-"))
            {
                value = value.substring(1);
            }
            return value;
        }
        protected abstract boolean doValidate(String s);
    }
    //实现 doValidate 判断是否是整数
    class IntegerValidate extends NumberValidateTemplate{
        protected boolean doValidate(String integer){
            {
                for (int i = 0; i < integer.length(); i++)
                {
                    if(Character.isDigit(integer.charAt(i)) == false)
                    {
                        return false;
                    }
                }

                return true;
            }
        }
    }
    //实现 doValidate 判断是否是科学计数法
    class SienceFormatValidate extends NumberValidateTemplate{
        protected boolean doValidate(String s){
            s = s.toLowerCase();
            int pos = s.indexOf("e");
            if (pos == -1)
            {
                return false;
            }

            if (s.length() == 1)
            {
                return false;
            }
            String first = s.substring(0, pos);
            String second = s.substring(pos + 1, s.length());
            if (validatePartBeforeE(first) == false || validatePartAfterE(second) == false){
                return false;
            }
            return true;
        }
        private boolean validatePartBeforeE(String first){
            if (first.equals("") == true)
            {
                return false;
            }
            if (checkHeadAndEndForSpace(first) == false)
            {
                return false;
            }
            NumberValidate integerValidate = new IntegerValidate();
            NumberValidate floatValidate = new FloatValidate();
            if (integerValidate.validate(first) == false && floatValidate.validate(first) == false)
            {
                return false;
            }
            return true;
        }
        private boolean checkHeadAndEndForSpace(String part)
        {

            if (part.startsWith(" ") ||
                    part.endsWith(" "))
            {
                return false;
            }

            return true;
        }

        private boolean validatePartAfterE(String second){
            if (second.equals("") == true)
            {
                return false;
            }

            if (checkHeadAndEndForSpace(second) == false)
            {
                return false;
            }
            NumberValidate integerValidate = new IntegerValidate();
            if (integerValidate.validate(second) == false)
            {
                return false;
            }
            return true;
        }
    }

    //实现 doValidate 判断是否是小数
    class FloatValidate extends NumberValidateTemplate {
        protected boolean doValidate(String floatVal){
            int pos = floatVal.indexOf(".");
            if (pos == -1)
            {
                return false;
            }

            if (floatVal.length() == 1)
            {
                return false;
            }
            String first = floatVal.substring(0, pos);
            String second = floatVal.substring(pos + 1, floatVal.length());
            if (checkFirstPart(first) == true && checkFirstPart(second) == true)
            {
                return true;
            }
            return false;
        }
        private boolean checkFirstPart(String first)
        {
            if (first.equals("") == false && checkPart(first) == false)
            {
                return false;
            }

            return true;
        }
        private boolean checkPart(String part){
            //. 1
            if (Character.isDigit(part.charAt(0)) == false ||
                    Character.isDigit(part.charAt(part.length() - 1)) == false)
            {
                return false;
            }
            NumberValidate nv = new IntegerValidate();
            if (nv.validate(part) == false)
            {
                return false;
            }
            return true;
        }
    }
    //定义一个执行者，我们把之前实现的各个类加到一个数组里，然后依次调用
    class NumberValidator implements NumberValidate {
        private ArrayList<NumberValidate> validators = new ArrayList<NumberValidate>();
        public NumberValidator()
        {
            addValidators();
        }
        private  void addValidators(){
            NumberValidate nv = new IntegerValidate();
            validators.add(nv);
            nv = new FloatValidate();
            validators.add(nv);
            nv = new SienceFormatValidate();
            validators.add(nv);
        }
        @Override
        public boolean validate(String s)
        {
            for (NumberValidate nv : validators)
            {
                if (nv.validate(s) == true)
                {
                    return true;
                }
            }
            return false;
        }

    }
    public boolean isNumber2(String s) {
        NumberValidate nv = new NumberValidator();
        return nv.validate(s);
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
    public static boolean isNumber3(String s) {
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
}

