package Stack.medium;

import java.util.*;

//636. Exclusive Time of Functions
//On a single threaded CPU, we execute some functions.  Each function has a unique id between 0 and N-1.
//
//We store logs in timestamp order that describe when a function is entered or exited.
//
//Each log is a string with this format: "{function_id}:{"start" | "end"}:{timestamp}".  For example, "0:start:3" means the function with id 0 started at the beginning of timestamp 3.  "1:end:2" means the function with id 1 ended at the end of timestamp 2.
//
//A function's exclusive time is the number of units of time spent in this function.  Note that this does not include any recursive calls to child functions.
//
//The CPU is single threaded which means that only one function is being executed at a given time unit.
//
//Return the exclusive time of each function, sorted by their function id.
//
//
//
//Example 1:
//
//
//
//Input:
//n = 2
//logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
//Output: [3, 4]
//Explanation:
//Function 0 starts at the beginning of time 0, then it executes 2 units of time and reaches the end of time 1.
//Now function 1 starts at the beginning of time 2, executes 4 units of time and ends at time 5.
//Function 0 is running again at the beginning of time 6, and also ends at the end of time 6, thus executing for 1 unit of time.
//So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.
//
//
//Note:
//
//1 <= n <= 100
//Two functions won't start or end at the same time.
//Functions will always log when they exit.
public class ExclusiveTimeOfFunctions {
    public static void main(String[] args){test();}
    public static int[] exclusiveTime(int n, List<String> logs) {
        //写的乱七八糟 die了
//        Map<Integer, Integer> map = new HashMap();
//        Stack<String[]> stack = new Stack<>();
//        int v = 0;
//        int[] res = new int[n];
//        for(int i = 0; i < logs.size(); i++){
//            String[] strings = logs.get(i).split(":");
//            if(!stack.isEmpty() && stack.peek()[0].equals(strings[0]) && stack.peek()[1].equals("start") && strings[1].equals("end")){
//                String tmp[] = stack.pop();
//                if(stack.isEmpty()) {
//                    map.put(Integer.parseInt(strings[0]), map.getOrDefault(Integer.parseInt(strings[0]), 0) + Integer.parseInt(strings[2]) - Integer.parseInt(tmp[2]) + 1 - v);
//                    v = 0;
//                }else{
//                    map.put(Integer.parseInt(strings[0]), map.getOrDefault(Integer.parseInt(strings[0]), 0) + Integer.parseInt(strings[2]) - Integer.parseInt(tmp[2]) + 1);
//                    v += Integer.parseInt(strings[2]) - Integer.parseInt(tmp[2]) + 1;
//                }
//            }else{
//                stack.push(strings);
//            }
//            System.out.println(map);
//        }
//        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
//        while(iterator.hasNext()){
//            Map.Entry<Integer, Integer> next = iterator.next();
//            res[next.getKey()] = next.getValue();
//        }
//        return res;
        int[] results = new int[n];
        Stack<String[]> stack = new Stack<>();
        for (String s : logs) {
            String[] str = s.split(":");
            if (str[1].equals("start")) {
                stack.push(new String[]{str[0], str[2], str[2]});//index_1:放修改的， index_2：放未修改的
            } else {
                String[] pop = stack.pop();
                int value = Integer.parseInt(str[2]) - Integer.parseInt(pop[1]) + 1;
                results[Integer.parseInt(pop[0])] += value;
                if (stack.size() > 0) {
                    String[] p = stack.pop();
                    p[1] = Integer.parseInt(p[1]) + Integer.parseInt(str[2]) - Integer.parseInt(pop[2]) + 1 + "";
                    stack.push(p);
                }
            }
        }
        return results;
    }
    public static void test(){
        int n = 8;
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:5");
        logs.add("2:start:6");
        logs.add("3:start:9");
        logs.add("4:start:11");
        logs.add("5:start:12");
        logs.add("6:start:14");
        logs.add("7:start:15");
        logs.add("1:start:24");
        logs.add("1:end:29");
        logs.add("7:end:34");
        logs.add("6:end:37");
        logs.add("5:end:39");
        logs.add("4:end:40");
        logs.add("3:end:45");
        logs.add("0:start:49");
        logs.add("0:end:54");
        logs.add("5:start:55");
        logs.add("5:end:59");
        logs.add("4:start:63");
        logs.add("4:end:66");
        logs.add("2:start:69");
        logs.add("2:end:70");
        logs.add("2:start:74");
        logs.add("6:start:78");
        logs.add("0:start:79");
        logs.add("0:end:80");
        logs.add("6:end:85");
        logs.add("1:start:89");
        logs.add("1:end:93");
        logs.add("2:end:96");
        logs.add("2:end:100");
        logs.add("1:end:102");
        logs.add("2:start:105");
        logs.add("2:end:109");
        logs.add("0:end:114");
        int[] res = exclusiveTime(n, logs);
        for(int i : res)
            System.out.print(i + " ");
    }
}
