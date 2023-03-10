class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int [] ans = new int[n];
        int [] ns = new int[n + 2];
        int len = bookings.length;

        for (int i = 0; i < len; i++) {
            ns[bookings[i][0]] += bookings[i][2];
            ns[bookings[i][1] + 1] -= bookings[i][2];
        }

        for (int i = 1; i <= n; i++) {
            if (i == 1) ans[0] = ns[1];
            else ans[i - 1] = ns[i] + ans[i - 2];
        }

        return ans;
    }
}