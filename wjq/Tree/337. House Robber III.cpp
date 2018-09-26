337. House Robber III

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.

����
�����ڵĽ��͵����ֵ

˼·1
����һ����һ�����˵������͵���߲�͵����ѡ��
͵����ô�����ӽڵ�Ͳ���͵�ˡ�͵�ļ�ֵ=���ڵ��ֵ+ �ݹ�������������� + �ݹ��ҽ�������������
��͵����ô�����ӽڵ�Ϳ���͵����͵�ļ�ֵ=�ݹ�����������
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int rob(TreeNode* root) {
        return robHouse(root);
    }

    int robHouse(TreeNode *root){
        if(root==NULL)
            return 0;
        //͵��ǰ�ڵ�
        int r=root->val;
        if(root->left!=NULL)
            r+=robHouse(root->left->left)+robHouse(root->left->right);
        if(root->right!=NULL)
            r+=robHouse(root->right->left)+robHouse(root->right->right);
        //��͵��ǰ�ڵ�
        int nr = robHouse(root->left)+robHouse(root->right);
        return r>nr?r:nr;

    }
};

˼·2
����˼·1�����ǻᷢ�֣�����robHouse(root)����Ҫ�ݹ�������Щ����
robHouse(root->left->left),robHouse(root->left->right),
robHouse(root->right->left),robHouse(root->right->left),
robHouse(root->left),robHouse(root->right).
���ڼ���robHouse(root->left)ʱ��ͬ����Ҫ��
robHouse(root->left->left),robHouse(root->left->right)
ͬ����ڼ���robHouse(root->right)����Ҫ
robHouse(root->right->left),robHouse(root->right->right)
���������
ֱ�Ӱѵ�ǰ�ڵ���͵������ֵ������unordered_map�У��������ݵ���һ��ʱ��
�������ýڵ������ֵ����Ҫ�����ֵ�ͻ�ֱ�ӷ������ֵ��������Ҫ�ظ����㡣
class Solution {
public:
    unordered_map <TreeNode *,int> m;
    int rob(TreeNode* root) {
        return robHouse(root);
    }
    int robHouse(TreeNode *root){
        if(root==NULL)
            return 0;
        if(m.find(root)!=m.end())
            return m[root];
        //͵��ǰ�ڵ�
        int r=root->val;
        if(root->left!=NULL)
            r+=robHouse(root->left->left)+robHouse(root->left->right);
        if(root->right!=NULL)
            r+=robHouse(root->right->left)+robHouse(root->right->right);
        //��͵��ǰ�ڵ�
        int nr = robHouse(root->left)+robHouse(root->right);
        //������ֵ
        int maxValue = max(r,nr);
        m[root]=maxValue;
        return maxValue;
    }
};

˼·3
̰�ķ���������ÿһ����㣬���Ƕ���͵��͵����ѡ�񣬰�������ѡ���ֵ����¼��������������
�����е�һ��Ԫ�ر�ʾ��͵������ֵ���ڶ���Ԫ�ر�ʾ͵������ֵ��
��ô�ڶԵ�ǰ�Ľ�������ߵ�ʱ�����Ǿ��ܹ���������������¼��ֵ�����о��ߡ�
class Solution {
public:
    int rob(TreeNode* root) {
        vector<int> res=robHouse(root);
        return max(res[0],res[1]);
    }
    vector<int> robHouse(TreeNode *root){
        if(root==NULL)
        {
            vector<int> a(2,0);
            return a;
        }

        vector<int> robLeft = robHouse(root->left);
        vector<int> robRight = robHouse(root->right);
        vector<int> res(2,0);
        //��ǰ�ڵ㲻͵������������ѡ��͵��͵��ȡ�����
        res[0] = max(robLeft[0],robLeft[1])+max(robRight[0],robRight[1]);
        //��ǰ�ڵ�͵������������ѡ��͵
        res[1] = root->val + robLeft[0] + robRight[0];
        return res;
    }
};




