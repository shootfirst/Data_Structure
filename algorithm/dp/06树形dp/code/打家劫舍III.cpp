class Solution {
public:
    int rob(TreeNode* root) {
        vector<int> res = dfs(root);
        return max(res[0], res[1]);
    }

    vector<int> dfs(TreeNode* node) {
        vector<int> res(2, 0);
        if (node == nullptr) return res;
        auto l = dfs(node->left);
        auto r = dfs(node->right);

        res[0] = max(l[0], l[1]) + max(r[0], r[1]);
        res[1] = l[0] + r[0] + node->val;
        return res;
    }
};