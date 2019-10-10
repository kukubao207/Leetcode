package Exam2020.ali;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Shell {
    public static void main(String[] args) {
        String filePath = "/Users/gongai/biz.log";
//        System.out.println(cat(filePath));
//        System.out.println(grep(cat(filePath), "Login"));
//        System.out.println(uniq(grep(cat(filePath), "Login")));
//        System.out.println(sort(uniq(grep(cat(filePath), "Login"))));
        Map<String, Integer> map = sort(uniq(grep(cat(filePath), "Login")));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

    //实现cat读取路径下的文件，并把每一行字符串保存在list当中
    public static List<String> cat(String path) {
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    if (line.equals(""))
                        continue;
                    else
                        list.add(line);
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //实现grep查找包含关键字的行
    public static List<String> grep(List<String> list, String keyWords) {
        if (list == null || list.size() == 0 || keyWords == null || keyWords.equals(""))
            return null;
        List<String> lines = new ArrayList<>();
        for (String s : list) {
            if (s.contains(keyWords))
                lines.add(s);
        }
        return lines;
    }

    //实现uniq统计每一行重复的次数
    public static Map<String, Integer> uniq(List<String> lines) {
        Map<String, Integer> map = new HashMap<>();
        for (String line : lines) {
            map.put(line, map.getOrDefault(line, 0) + 1);
        }
        return map;
    }

    //实现sort -nr将行数据按行次数逆序排列
    public static Map<String, Integer> sort(Map<String, Integer> map) {
        Map<String, Integer> treeMap = new TreeMap<>(new sortByValue(map));
        treeMap.putAll(map);
        return treeMap;
    }

    public static class sortByValue implements Comparator<String> {
        private Map<String, Integer> map;

        public sortByValue(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(String o1, String o2) {
            if (map.get(o1) < map.get(o2))
                return 1;
            return -1;
        }
    }

}