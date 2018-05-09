699. Falling Squares

On an infinite number line (x-axis), we drop given squares in the order they are given.

The i-th square dropped (positions[i] = (left, side_length)) is a square with the left-most

point being positions[i][0] and sidelength positions[i][1].

The square is dropped with the bottom edge parallel to the number line, and from a higher height

than all currently landed squares. We wait for each square to stick before dropping the next.

The squares are infinitely sticky on their bottom edge, and will remain fixed to any positive length

surface they touch (either the number line or another square). Squares dropped adjacent to each other

will not stick together prematurely.

Return a list ans of heights. Each height ans[i] represents the current highest height of any

square we have dropped, after dropping squares represented by positions[0], positions[1], ..., positions[i].

Example 1:
Input: [[1, 2], [2, 3], [6, 1]]
Output: [2, 5, 5]
Explanation:

After the first drop of positions[0] = [1, 2]:
_aa
_aa
-------
The maximum height of any square is 2.


After the second drop of positions[1] = [2, 3]:
__aaa
__aaa
__aaa
_aa__
_aa__
--------------
The maximum height of any square is 5.
The larger square stays on top of the smaller square despite where its center
of gravity is, because squares are infinitely sticky on their bottom edge.


After the third drop of positions[1] = [6, 1]:
__aaa
__aaa
__aaa
_aa
_aa___a
--------------
The maximum height of any square is still 5.

Thus, we return an answer of [2, 5, 5].


Example 2:
Input: [[100, 100], [200, 100]]
Output: [100, 100]
Explanation: Adjacent squares don't get stuck prematurely - only their bottom edge can stick to surfaces.
Note:

1 <= positions.length <= 1000.
1 <= positions[i][0] <= 10^8.
1 <= positions[i][1] <= 10^6.


题意
给定一个数组，数组中每个元素是一个 数对，
数对中第一个元素表示横坐标，第二个元素表示这个正方形的边长，
求出每一个正方形（数对）落下后，当前所有正方形的最大高度。

思路，使用TreeMap来做类似这种区间的题。
The basic idea here is pretty simple,
for each square i,
    find all the maximum height from previously dropped squares range
    from floorKey(i_start) (inclusive) to end (exclusive),
    then I will update the height
    and delete all the old heights.

class Solution {

    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> height = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        int max_height=0;
        for(int[] pos : positions)
        {
            int start = pos[0],h = pos[1],end=pos[0]+pos[1];
            int left = map.floorKey(start);
            int maxCurHeight = map.subMap(left,end).values().stream().max(Integer::compare).get() + h;
            max_height = Math.max(maxCurHeight,max_height);

            int lastHeight = map.floorEntry(end).getValue();

            map.put(start,maxCurHeight);
            map.put(end,lastHeight);

            map.keySet().removeAll(new HashSet<>(map.subMap(start,false,end,false).keySet()));
            height.add(max_height);
        }
        return height;
    }

}
