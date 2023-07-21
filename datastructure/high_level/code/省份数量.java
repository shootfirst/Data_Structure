class Solution {
    // https://leetcode.cn/problems/number-of-provinces/
public:
    // 并查集
    class UnionFind {
    public:
        int n;
        vector<int> root;
        vector<int> rank;

        UnionFind(int num) {
            n = num;
            root = vector<int>(n);
            rank = vector<int>(n);
            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        void unionn(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }

        int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }
    };

    int findCircleNum(vector<vector<int>>& isConnected) {
        int n = isConnected.size();
        UnionFind u(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    u.unionn(i, j);
                }
            }
        }

        unordered_set<int> s;
        for (int i = 0; i < n; i++) {
            s.insert(u.find(i));
        }

        return s.size();
    }
};