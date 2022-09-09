class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, len1 = arr1.length, len2 = arr2.length;

        for (int i = 0; i < len1; i++) {
            if (arr1[i] > max) max = arr1[i];
            if (arr1[i] < min) min = arr1[i];
        }

        int[] copy = new int [len1];
        int[] cnt1 = new int[max - min + 1];

        for (int i = 0; i < len2; i++) {
            cnt1[arr2[i] - min] = -1;
        }

        for (int i = 0; i < len1; i++) {
            if (cnt1[arr1[i] - min] != 0) {
                if (cnt1[arr1[i] - min] == -1) cnt1[arr1[i] - min] = 1;
                else cnt1[arr1[i] - min] += 1;
            }
        }

        int k = 0;
        for (int i = 0; i < len2; i++) {
            for (int j = 0; j < cnt1[arr2[i] - min]; j++) {
                copy[k++] = arr2[i];
            }
        }



        int [] cnt = new int[max - min + 1];
        for (int i = 0; i < len1; i++) {
            cnt[arr1[i] - min] += 1;
        }

        for (int i = 0; i < len2; i++) {
            cnt[arr2[i] - min] = 0;
        }

        int pre = 0;
        int [] cnt2 = new int[max - min + 1];
        for (int i = 0; i <= max - min; i++) {
            pre += cnt[i];
            cnt2[i] = pre - cnt[i];
        }

        for (int i = 0; i < len1; i++) {
            if (cnt[arr1[i] - min] != 0) {
                copy[cnt2[arr1[i] - min] + k] = arr1[i];
                cnt2[arr1[i] - min]++;
            }
        }

        for (int i = 0; i < len1; i++) {
            arr1[i] = copy[i];
        }

        return arr1;

    }
}