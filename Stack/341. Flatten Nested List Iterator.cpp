341. Flatten Nested List Iterator

Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *   public:
 *     // Return true if this NestedInteger holds a single integer, rather than a nested list.
 *     bool isInteger() const;
 *
 *     // Return the single integer that this NestedInteger holds, if it holds a single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     int getInteger() const;
 *
 *     // Return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     const vector<NestedInteger> &getList() const;
 * };
 */

class NestedIterator {
public:
    stack<NestedInteger> s;
    NestedIterator(vector<NestedInteger> &nestedList) {
        for(int i=nestedList.size()-1;i>=0;i--)
            s.push(nestedList[i]);
    }

    int next() {
        int val=s.top().getInteger();
        s.pop();
        return val;
    }

    bool hasNext() {
        while(!s.empty())
        {
            NestedInteger node=s.top();
            if(node.isInteger())
                return true;
            s.pop();
            vector<NestedInteger>& v=node.getList();
            for(int i=v.size()-1;i>=0;i--)
                s.push(v[i]);
        }
        return false;
    }
};

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i(nestedList);
 * while (i.hasNext()) cout << i.next();
 */

���������һֱû��⣬���˱��˵Ĵ���֮��������ˡ�
�ⷨ˼·����
����[[3,4],2,[1,6]]
��ѹջ����
[3,4]
2
[1,6]
hasNext()�����У���ȡ��ջ��Ԫ�أ�ͨ��isInteger()�ж��Ƿ�Ϊ���Σ�
��������εĻ���ֱ�ӷ���true��
������ǵĻ�����[3,4]����ջ����Ȼ������List��β����ʼ��Ԫ��ѹ��ջ��
3
4
2
[1,6]

����ÿ��next()��������ջ����Ԫ��ֵһ��Ϊ���Σ�����ֱ�ӷ��ء�



�پٸ�����
����[1,[4,[6]]] ջ�ı仯
[1,[4,[6]]]  ->  1          ->     4     ->6
                [4,[6]]           [6]
