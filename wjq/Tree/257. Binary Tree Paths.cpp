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

我的思路
用dfs搜索整个树。递归写法思路。
1.当前节点若为NULL，返回。
2.当前节点不为NULL，把当前节点转换成字符串并入字符串。
3.当前节点为叶子节点（左右子树均为空），把整个字符串并入结果集。
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

别人的思路，基本思路一致，都是DFS
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
