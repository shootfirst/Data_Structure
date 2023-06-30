class Solution {
    // https://leetcode.cn/problems/number-of-provinces/
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind u = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) u.union(i, j);
            }
        }

        Set<Integer> s = new HashSet();
        for (int i = 0; i < n; i++) {
            s.add(u.find(i));
        }
        return s.size();
    }

    class UnionFind {
        int [] root;
        int [] rank;

        UnionFind(int size) {
            root = new int [size];
            rank = new int [size];

            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (x == root[x]) return x;
            // 路径压缩
            return root[x] = find(root[x]);
        }

        void union(int x, int y) {
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

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}