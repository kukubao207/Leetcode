297. Serialize and Deserialize Binary Tree

Serialization is the process of converting a data structure or object into a sequence
of bits so that it can be stored in a file or memory buffer, or transmitted across a
network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree.
There is no restriction on how your serialization/deserialization algorithm should work.
You just need to ensure that a binary tree can be serialized to a string and this string
can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree.
You do not necessarily need to follow this format, so please be creative and come up with
different approaches yourself.



Note: Do not use class member/global/static variables to store states. Your serialize
 and deserialize algorithms should be stateless.

题意，序列化和反序列化二叉树

我的思路 先根遍历进行序列化，
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        string result=preOrder(root);
        return result+",";
    }
    string preOrder(TreeNode *root){
        if(root==NULL)
            return "#";
        string leftstr=preOrder(root->left);
        string rightstr=preOrder(root->right);
        return to_string(root->val)+","+leftstr+","+rightstr;
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        return mydes(data);
    }
    TreeNode* mydes(string &data)
    {
        if(data[0]=='#')
        {
            data=data.substr(2);
            return NULL;
        }
        TreeNode *root=new TreeNode(helper(data));
        root->left=mydes(data);
        root->right=mydes(data);
        return root;
    }
    int helper(string &data)
    {
        int pos=data.find(',');
        int val=stoi(data.substr(0,pos));
        data=data.substr(pos+1);
        return val;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.deserialize(codec.serialize(root));

另一种方式 BFS
public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
