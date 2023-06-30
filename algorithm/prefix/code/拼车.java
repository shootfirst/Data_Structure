class Solution {
    // https://leetcode.cn/problems/car-pooling/
    public boolean carPooling(int[][] trips, int capacity) {
        int [] place = new int [1001];
        int [] cap = new int [1001];

        int len = trips.length;

        for (int i = 0; i < len; i++) {
            place[trips[i][1]] += trips[i][0];
            place[trips[i][2]] -= trips[i][0];
        }

        for (int i = 0; i < 1001; i++) {
            if (i != 0)
                place[i] += place[i - 1];
            if (place[i] > capacity) return false;
        }
        return true;
    }
}