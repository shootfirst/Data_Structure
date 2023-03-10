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
private:
    int max_val = INT_MIN;
    int findMax(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        int left_val = max(0, findMax(root->left));
        int right_val = max(0, findMax(root->right));

        int val = left_val + root->val + right_val;
        max_val = max(max_val, val);

        return root->val + max(left_val, right_val);
    }


public:
    int maxPathSum(TreeNode* root) {
        findMax(root);
        return max_val;
    }
};