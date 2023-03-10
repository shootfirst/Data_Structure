class Solution {
public:
    unordered_map<TreeNode*, pair<int, int>> mem;
    int longestZigZag(TreeNode* root) {
        dfs(root);
        int max_num = 0;
        for (auto it = mem.begin(); it != mem.end(); it++) {
            max_num = max(max_num, it->second.first);
            max_num = max(max_num, it->second.second);
        }
        return max_num - 1;
    }

    pair<int, int> dfs(TreeNode* node){
        if (node == nullptr) return {0, 0};

        auto l = dfs(node->left);
        mem[node->left] = l;
        auto r = dfs(node->right);
        mem[node->right] = r;
        mem[node] = {l.second + 1, r.first + 1};
        return mem[node];
    }
};