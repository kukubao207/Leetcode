package Offer;

import java.util.*;

public class YizhixingHash {
    private static class Computer {
        String name;
        int id;     // hash
        int state;  // 0 代表正常 1 代表宕机

        Computer(String name, int id, int state) {
            this.name = name;
            this.id = id;
            this.state = state;
        }
    }

    private static Map<String, Computer> nameMap = new HashMap<>();
    private static Map<Integer, Computer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        init();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        switch (input.charAt(0)) {
            case '1':
                System.out.println(indexName(String.valueOf(input.substring(2))));
                break;
            case '2':
                System.out.println(hashToken(input.substring(2)));
                break;
            case '3':
                String content = input.substring(2);
                String[] str = content.split(";");
                String[] downs = str[0].split(",");
                for (String down : downs) {
                    int downId = nameMap.get(down).id;
                    String ne = nameMap.get(down).name;
                    nameMap.put(down, new Computer(ne, downId, 1));
                    hashMap.put(downId, new Computer(ne, downId, 1));
                }
                System.out.println(chooseComputer(str[1]));
                break;
            case '4':
                System.out.println(addComputer(input.substring(2)));
                break;
            case '5':
                String[] temp = input.substring(2).split(";");
                addComputer(temp[0]);
                System.out.println(chooseComputer(temp[1]));
                break;
            default:
                break;
        }
    }

    public static void init() {
        String prefix = "redis_0";
        for (int i = 1; i <= 20; i++) {
            String name = prefix + i;
            int id = (i - 1) * 50;
            nameMap.put(name, new Computer(name, id, 0));
            hashMap.put(id, new Computer(name, id, 0));
        }
    }

    public static int indexName(String name) {
        if (nameMap.containsKey(name))
            return nameMap.get(name).id;
        return -1;
    }

    public static int hashToken(String token) {
        int sum = 0;
        for (int i = 0; i < token.length(); i++)
            sum += (int) token.charAt(i);
        return sum % 999;
    }

    public static int addComputer(String name) {
        int id = Integer.parseInt(name.substring(name.length() - 2));
        String prefix = "add_redis_0";
        for (int i = 0; i <= id; i++) {
            String str = prefix + i;
            int x = 50 * i - 25;
            nameMap.put(str, new Computer(str, x, 0));
            hashMap.put(x, new Computer(str, x, 0));
        }
        return 50 * id - 25;
    }

    public static int chooseComputer(String token) {
        int id = hashToken(token);
        if (hashMap.containsKey(id) && hashMap.get(id).state == 0) {
            return id;
        } else {
            for (int i = id + 1; i != id; i = (i + 1) % 999)
                if (hashMap.containsKey(i) && hashMap.get(i).state == 0)
                    return i;
        }
        return -1;
    }
}
