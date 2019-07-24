package Greedy;
// 134. Gas Station
// There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
//
//You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
//
//Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
//
//Note:
//
//If there exists a solution, it is guaranteed to be unique.
//Both input arrays are non-empty and have the same length.
//Each element in the input arrays is a non-negative integer.
//Example 1:
//
//Input:
//gas  = [1,2,3,4,5]
//cost = [3,4,5,1,2]
//
//Output: 3
//
//Explanation:
//Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
//Travel to station 4. Your tank = 4 - 1 + 5 = 8
//Travel to station 0. Your tank = 8 - 2 + 1 = 7
//Travel to station 1. Your tank = 7 - 3 + 2 = 6
//Travel to station 2. Your tank = 6 - 4 + 3 = 5
//Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
//Therefore, return 3 as the starting index.
//Example 2:
//
//Input:
//gas  = [2,3,4]
//cost = [3,4,3]
//
//Output: -1
//
//Explanation:
//You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
//Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
//Travel to station 0. Your tank = 4 - 3 + 2 = 3
//Travel to station 1. Your tank = 3 - 3 + 3 = 3
//You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
//Therefore, you can't travel around the circuit once no matter where you start.
public class GasStation {
    //  车能开完全程需要满足两个条件：
    //1.车从i站能开到i+1。
    //2.所有站里的油总量要>=车子的总耗油量。
    //那么，假设从编号为0站开始，一直到k站都正常，在开往k+1站时车子没油了。这时，应该将起点设置为k+1站。
    //为什么应该将起始站点设为k+1？
    //因为k->k+1站耗油太大，0->k站剩余油量都是不为负的，每减少一站，就少了一些剩余油量。
    // 所以如果从k前面的站点作为起始站，剩余油量不可能冲过k+1站。
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int left = 0;
        int start = 0;
        for(int i = 0;i < gas.length; i++){
            sum += gas[i] - cost[i];
            left += gas[i] - cost[i];
            if(left < 0){
                start = i + 1;
                left = 0;
            }
        }
        return sum < 0 ? -1 : start;
    }
}
