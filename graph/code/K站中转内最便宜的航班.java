class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (src == dst) {
            return 0;
        }

        int[] previous = new int[n];
        int[] current = new int[n];
        for (int i = 0; i < n; i++) {
            previous[i] = Integer.MAX_VALUE;
            current[i] = Integer.MAX_VALUE;
        }
        previous[src] = 0;
        for (int m = 0; m <= k; m++) {
            current[src] = 0;
            for (int i = 0; i < flights.length; i++) {
                int cur = flights[i][1];
                int pre = flights[i][0];
                int dest = flights[i][2];

                if (previous[pre] != Integer.MAX_VALUE)
                    // 注意如果题目这里没有说最多经过k次，那么这里可以改成 current[cur] = Math.min(current[cur], current[pre] + dest);
                    current[cur] = Math.min(current[cur], previous[pre] + dest); 
            }
            previous = current.clone();
        }
        return current[dst] == Integer.MAX_VALUE ? -1 : current[dst];
    }
}
