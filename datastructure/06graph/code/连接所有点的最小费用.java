class Solution {
    // kruscal算法
   public int minCostConnectPoints(int[][] points) {
       if (points == null || points.length == 0) {
           return 0;
       }
       int size = points.length;
       PriorityQueue<Edge> pq = new PriorityQueue<Edge>((x, y) -> x.cost - y.cost);
       UnionFind uf = new UnionFind(size);

       for (int i = 0; i < size; i++) {
           for (int j = i+1; j < size; j++) {
               int[] coordinate1 = points[i];
               int[] coordinate2 = points[j];
               int cost = Math.abs(coordinate1[0] - coordinate2[0]) + Math.abs(coordinate1[1] - coordinate2[1]);
               Edge edge = new Edge(i, j, cost);
               pq.add(edge);
           }
       }

       int result = 0;
       int count = size - 1;
       while ( pq.size() > 0 && count > 0 ) {
           Edge e = pq.poll();
           if ( !uf.connected(e.point1, e.point2)) {
               uf.union(e.point1, e.point2);
               result += e.cost;
               count--;
           }
       }
       return result;
   }

    class Edge {
        int point1;
        int point2;
        int cost;

        Edge(int point1, int point2, int cost) {
            this.point1 = point1;
            this.point2 = point2;
            this.cost = cost;
        }
    }

    class UnionFind {
        int root[];
        int rank[];

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}