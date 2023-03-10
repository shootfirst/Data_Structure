class Solution {
public:
    /**
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
    vector<vector<int>> verticalOrder(TreeNode *root) {
        vector<vector<int>> ans;
        if (root == nullptr) return ans;
        map<int, vector<int>> m;
        deque<pair<TreeNode *, int>> q;
        q.push_back({root, 0});
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                auto p = q.front();
                q.pop_front();
                if (m.count(p.second) == 0) m[p.second] = vector<int>(0);
                m[p.second].push_back(p.first->val);
                if (p.first->left != nullptr) {
                    q.push_back({p.first->left, p.second - 1});
                }
                if (p.first->right != nullptr) {
                    q.push_back({p.first->right, p.second + 1});
                }
            }
        }
        for (auto it = m.begin(); it != m.end(); it++) {
            ans.push_back(it->second);
        }
        return ans;
    }
};