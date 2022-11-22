// https://leetcode.cn/problems/russian-doll-envelopes/

//最长上升子序列lis问题

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]) {
                    // 宽度升序
                    return e1[0] - e2[0];
                } else {
                    // 若宽度相等，则高度降序(理解高度降序)
                    return e2[1] - e1[1];
                }
            }
        });

        // 存储可被套娃的信封序列
        List<Integer> f = new ArrayList<Integer>();
        f.add(envelopes[0][1]);
        for (int i = 1; i < n; ++i) {
            int num = envelopes[i][1];
            // 直接满足条件，加到最后
            if (num > f.get(f.size() - 1)) {
                f.add(num);
            // 否则找到刚好大于等于的替换之，理解这一步，精髓！！！
            } else {
                int index = binarySearch(f, num);
                f.set(index, num);
            }
        }
        return f.size();
    }

    public int binarySearch(List<Integer> f, int target) {
        int low = 0, high = f.size() - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (f.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
