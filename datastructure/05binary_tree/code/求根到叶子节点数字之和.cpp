class Solution {
public:
// https://leetcode.cn/problems/sum-root-to-leaf-numbers/
    int sumNumbers(TreeNode* root) {
        stack<int> st;
        int ans = 0;
        function<void(TreeNode*)> dfs = [&](TreeNode* root) {
            st.push((st.empty() ? 0 : st.top()) * 10 + root->val);
            if(root->left == nullptr && root->right == nullptr) {
                ans += st.top();
            }
            if (root->left != nullptr) {
                dfs(root->left);
            }
            if (root->right != nullptr) {
                dfs(root->right);
            }
            st.pop();
        };
        dfs(root);
        return ans;
    }
};