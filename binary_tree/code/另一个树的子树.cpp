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
    bool isSubtree(TreeNode* root, TreeNode* subRoot) {
        if (root == nullptr) {
            return false;
        }
        return isSameTree(root, subRoot) 
            || isSubtree(root->left, subRoot) || isSubtree(root->right, subRoot);
    }
private:
    bool isSameTree(TreeNode* a, TreeNode* b) {
        if (a == nullptr && b == nullptr) {
            return true;
        }
        if (a == nullptr || b == nullptr || a->val != b->val) {
            return false;
        }
        return isSameTree(a->left, b->left) && isSameTree(a->right, b->right); 
    }
};