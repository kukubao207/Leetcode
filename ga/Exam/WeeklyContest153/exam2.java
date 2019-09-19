package Exam.WeeklyContest153;

/**
 *
 */
public class exam2 {
    public static void main(String[] args){
        test();
    }
    public static void test(){
//        int day = 31;
//        int month = 8;
//        int year = 2019;
        int day = 15;
        int month = 8;
        int year = 1993;
        System.out.print(dayOfTheWeek(day, month, year));
    }
    //基姆拉尔森计算公式
//    Week=(Day + 2*Month + 3*(Month+1）/5 + Year + Year/4 - Year/100 + Year/400) % 7
//            （其中的Year是4位数的，如2009。“%”号是等式除7取余数）
//    注意：
//    i. 该公式中要把1月和2月分别当成上一年的13月和14月处理。
//    例如：2008年1月4日要换成 2007年13月4日带入公式。
//    ii.该式对应的与蔡勒公式有点区别：“0”为星期1，……，“6”为星期日。
    public static String dayOfTheWeek(int day, int month, int year) {
        if(month == 1) {
            month = 13;
            year--;
        }//2008年1月4日要换成 2007年13月4日带入公式。
        if(month == 2){
            month = 14;
            year--;
        }
        int week = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;
        String weekstr = "";
        switch(week)
        {
            case 0: weekstr="Monday"; break;
            case 1: weekstr="Tuesday"; break;
            case 2: weekstr="Wednesday"; break;
            case 3: weekstr="Thursday"; break;
            case 4: weekstr="Friday"; break;
            case 5: weekstr="Saturday"; break;
            case 6: weekstr="Sunday"; break;
        }
        return weekstr;
    }
}
