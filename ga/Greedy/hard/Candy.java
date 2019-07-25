package Greedy.hard;
// 135. Candy
// There are N children standing in a line. Each child is assigned a rating value.
//
//You are giving candies to these children subjected to the following requirements:
//
//Each child must have at least one candy.
//Children with a higher rating get more candies than their neighbors.
//What is the minimum candies you must give?
//
//Example 1:
//
//Input: [1,0,2]
//Output: 5
//Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
//Example 2:
//
//Input: [1,2,2]
//Output: 4
//Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
//             The third child gets 1 candy because it satisfies the above two conditions.
public class Candy {
}

//以后我把题做了思路也记录下来，我们可以讨论讨论。
//简单分析可知题意要求的每一个位置的糖果数为  max(candy[i-1], candy[i+1]);
//a.考虑左边权重小，右边权重大的情况，从左到右遍历数组.
//b.考虑左边权重大，右边权重小的情况，从右到左遍历数组.
//由于根据权重计算糖果是一个累计的过程，所以第二次要倒序遍历这个数组
//class Solution {
//public:
//    int candy(vector<int>& ratings) {
//        if (ratings.empty())
//            return 0;
//        vector<int> l(ratings.size(), 1);
//        for (int i = 1; i < ratings.size(); i++) {
//            if (ratings[i-1] < ratings[i])
//                l[i] = l[i-1] + 1;
//        }
//
//        vector<int> r(ratings.size(), 1);
//        for (int i = ratings.size() - 1; i>0; i--) {
//            if (ratings[i-1] > ratings[i])
//                r[i-1] = r[i] + 1;
//        }
//        int sum = 0;
//        for (int i = 0; i < ratings.size(); i++) {
//            sum += max(l[i], r[i]);
//        }
//        return sum;
//    }
//};