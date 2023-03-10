class Solution {
    // public int countTriplets(int[] arr) {
    //     if (arr.length == 0) return 0;

    //     int len = arr.length;

    //     int [] xorarr = new int [len + 1];

    //     for (int i = 1; i <= len; i++) {
    //         xorarr[i] = xorarr[i - 1] ^ arr[i - 1];
    //     }

    //     int ans = 0;

    //     for (int i = 0; i < len - 1; i++) {
    //         for(int j = i + 2; j <= len; j++) {
    //             for (int k = j; k <= len; k++) {
    //                 int left = xorarr[j - 1] ^ xorarr[i];
    //                 int right = xorarr[k] ^ xorarr[j - 1];
    //                 if (left == right) ans++;
    //             }
    //         }
    //     }

    //     return ans;
    // }

    public int countTriplets(int[] arr) {
        if (arr.length == 0) return 0;
        int len = arr.length;
        int [] xorarr = new int [len + 1];

        for (int i = 1; i <= len; i++) {
            xorarr[i] = xorarr[i - 1] ^ arr[i - 1];
        }

        int ans = 0;

        for (int i = 0; i < len; i++) {
            for(int j = i + 1; j <= len; j++) {
                if ((xorarr[j] ^ xorarr[i]) == 0) ans += j - i - 1;
            }
        }

        return ans;
    }
}