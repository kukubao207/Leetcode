449. Serialize and Deserialize BST

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

题意
实现序列化和反序列化一个BST的方法。

我的思路
序列化就用中根遍历的迭代实现（栈）。
反序列化用到了BST的一个特性，比他当前节点小的插入到左子树中，比当前节点大的插入到右子树中。
当然我的思路只能应用在BST上，因为BST中不具备相同大小的元素。
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
        string result="";
        if(root==NULL)
            return result;
        stack<TreeNode *> s;
        s.push(root);
        while(!s.empty())
        {
            TreeNode *cur = s.top();
            s.pop();
            result+=to_string(cur->val)+",";
            if(cur->right!=NULL)
                s.push(cur->right);
            if(cur->left!=NULL)
                s.push(cur->left);
        }
        return result;
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        TreeNode *root=NULL;
        int num=0;
        for(int i=0;i<data.length();i++)
        {
            if(data[i]>='0'&&data[i]<='9')
                num=num*10+data[i]-'0';
            else if(data[i]==',')
            {
                TreeNode *newNode = new TreeNode(num);
                TreeNode *temp=root;
                while(true)
                {
                    if(temp==NULL)
                    {
                        root=newNode;
                        break;
                    }
                    if(num<temp->val)
                    {
                        if(temp->left!=NULL)
                            temp=temp->left;
                        else
                        {
                            temp->left=newNode;
                            break;
                        }

                    }
                    else
                    {
                        if(temp->right!=NULL)
                            temp=temp->right;
                        else
                        {
                            temp->right=newNode;
                            break;
                        }
                    }
                }
                num=0;
            }

        }
        return root;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.deserialize(codec.serialize(root));

别人的递归写法 JAVA代码
// Encodes a tree to a single string.
public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    dfs(root, sb);
    return sb.toString();
}
private void dfs(TreeNode root, StringBuilder sb) {
    if (root == null) {
        return;
    }
    sb.append(root.val + ",");
    dfs(root.left, sb);
    dfs(root.right, sb);
    return;
}

// Decodes your encoded data to tree.
public TreeNode deserialize(String data) {
    String[] arr = data.split(",");
    TreeNode root = null;
    for (String s : arr) {
        if (s.length() > 0) {
            root = buildBST(root, Integer.parseInt(s));
        }
    }
    return root;
}

public TreeNode buildBST(TreeNode root, int v) {
    if (root == null) return new TreeNode(v);
    if (v < root.val) {
        root.left = buildBST(root.left, v);
    } else {
        root.right = buildBST(root.right, v);
    }
    return root;
}
