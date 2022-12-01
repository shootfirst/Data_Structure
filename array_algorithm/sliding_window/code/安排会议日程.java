class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Arrays.sort(slots2, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        List<Integer> ans = new ArrayList();
        int[] time1 = new int[2];
        int[] time2 = new int[2];

        int ptr1 = 0, ptr2 = 0, leng1 = slots1.length, leng2 = slots2.length;

        while (ptr1 < leng1 && ptr2 < leng2) {
            time1 = slots1[ptr1];
            time2 = slots2[ptr2];

            if (time1[1] <= time2[0]) {
                ptr1++;
            } else if (time2[1] <= time1[0]) {
                ptr2++;
            } else {
                // 时间有重叠
                int min = Math.max(time1[0], time2[0]);
                int max = Math.min(time1[1], time2[1]);
                if (max - min >= duration) {
                    ans.add(min);
                    ans.add(min + duration);
                    return ans;
                } else {
                    // 注意时间重叠但是不满足不能覆盖duration时，我们两个指针移动的条件判断
                    if (time1[0] <= time2[0] && time1[1] > time2[1]) {
                        ptr2++;
                    } else if (time2[0] <= time1[0] && time2[1] > time1[1]) {
                        ptr1++;
                    } else if (time1[0] <= time2[0]) {
                        ptr1++;
                    } else {
                        ptr2++;
                    }
                }
            }
        }

        return ans;
    }
}