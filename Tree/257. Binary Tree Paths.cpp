257. Binary Tree Paths

Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]

�ҵ�˼·
��dfs�������������ݹ�д��˼·��
1.��ǰ�ڵ���ΪNULL�����ء�
2.��ǰ�ڵ㲻ΪNULL���ѵ�ǰ�ڵ�ת�����ַ��������ַ�����
3.��ǰ�ڵ�ΪҶ�ӽڵ㣨����������Ϊ�գ����������ַ�������������
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
    vector<string> res;
    vector<string> binaryTreePaths(TreeNode* root) {
        if(root==NULL)
            return res;
        dfs(root,"");
        return res;
    }
    void dfs(TreeNode *root,string str){
        if(root==NULL)
            return;
        str=str+"->"+to_string(root->val);
        if(root->left==NULL&&root->right==NULL)
        {
            res.push_back(str.substr(str.find_first_of(">")+1));
            return;
        }
        dfs(root->left,str);
        dfs(root->right,str);
    }
};

���˵�˼·������˼·һ�£�����DFS
class Solution {
public:
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> paths;
        dfs(root, "", paths);
        return paths;
    }
private:
    void dfs(TreeNode* root, string path, vector<string>& paths) {
        if(!root) return;
        if(!path.empty()) {
            path += "->";
        }
        path += to_string(root->val);
        if(!root->left&&!root->right) {
            paths.push_back(path);
            return;
        }
        dfs(root->left,path,paths);
        dfs(root->right,path,paths);
    }
};
