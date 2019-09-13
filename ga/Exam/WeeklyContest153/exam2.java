package Exam.WeeklyContest153;

public class exam2 {
    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(31, 8, 2019));
    }
    public static String dayOfTheWeek(int day, int month, int year) {
        String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        if (month == 1) {
            month=13;
            year--;
        }
        if(month == 2) {
            month=14;
            year--;
        }
        int week = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;
        return weekdays[week];
    }
}
