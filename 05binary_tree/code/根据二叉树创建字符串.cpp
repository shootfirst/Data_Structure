/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    string tree2str(TreeNode* root) {
        string ans = "";
        if (root == nullptr) {
            return "";
        }

        if (root->left == nullptr && root->right == nullptr){
            ans += std::to_string(root->val);
        } else if (root->right == nullptr) {
            ans += std::to_string(root->val);
            ans += "(";
            ans += tree2str(root->left);
            ans += ")";
        } else {
            ans += std::to_string(root->val);
            ans += "(";
            ans += tree2str(root->left);
            ans += ")";
            ans += "(";
            ans += tree2str(root->right);
            ans += ")";
        }
            
        return ans;
    }
};