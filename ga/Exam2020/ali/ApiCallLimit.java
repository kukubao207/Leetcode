package Exam2020.ali;

//1、接口限流实现有一个API网关，出于对API接口的保护，需要建立一个流控功能，根据API名称，每分钟最多只能请求指定的次数（如1000次），
//        超过限制则这分钟内返回错误，但下一分钟又可以正常请求。

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApiCallLimit {
    public static void main(String[] args) {
        test();
    }

    //这个类用于记录每一个被调用的方法的两个指标，一个是该方法统计调用次数的分钟的起始时间，一个是当前这个分钟的调用次数
    public static class ApiValue {
        private long startTime;//当前分钟的起始时间
        private int calNum;//当前分钟的调用次数

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public int getCalNum() {
            return calNum;
        }

        public void setCalNum(int calNum) {
            this.calNum = calNum;
        }

        public boolean judge() {
            this.calNum = calNum + 1;
            if (System.currentTimeMillis() / 1000 <= startTime + 60) {//当前时间在一分钟之内
                if (calNum <= 1000)
                    return true;
                else {
                    return false;
                }
            } else {//当前时间在一分钟之外 可以调用方法  但是要重置调用次数和起始时间
                this.calNum = 1;
                this.startTime = System.currentTimeMillis() / 1000;
                return true;
            }
        }
    }

    private static Map<String, ApiValue> map = new ConcurrentHashMap<>();

    //每次方法调用之前，需要调用这个函数判断是否一分钟内调用超过1000次
    public static boolean beforeCallApi(String apiName) {
        if (apiName == null || apiName.length() == 0)
            return false;
        ApiValue oldValue = map.get(apiName);
        if (oldValue == null) {//从来没有调用过
            ApiValue newValue = new ApiValue();
            newValue.setStartTime(System.currentTimeMillis() / 1000);//设置为秒
            newValue.setCalNum(1);
            map.put(apiName, newValue);
            return true;
        } else {//判断
            return oldValue.judge();
        }
    }

    public static void test() {
        for (int i = 0; i < 1005; i++) {
            System.out.print(beforeCallApi("123") + ",");
        }
        System.out.println();
        try {
            Thread.sleep(61 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 1005; i++) {
            System.out.print(beforeCallApi("456") + ",");
        }
    }
}