class Solution {
public:
    double minimalExecTime(TreeNode* root) {
        auto res = dfs(root);
        return res[1];
    }

    vector<double> dfs(TreeNode* root) {
        vector<double> res(2, 0);
        if (root == nullptr) return res;
        auto l = dfs(root->left);
        auto r = dfs(root->right);
        res[0] = root->val + l[0] + r[0];
        res[1] = max((l[0] + r[0]) / 2.0, max(l[1], r[1])) + root->val;
        return res;
    }
};