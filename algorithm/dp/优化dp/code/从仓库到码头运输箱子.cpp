class Solution {
public:
    // https://leetcode.cn/problems/delivering-boxes-from-storage-to-ports/
    int boxDelivering(vector<vector<int>>& boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.size();
        int dp[n]; // dp[i] = 运输[0, i]箱子所需要的最小费用
        memset(dp, 0x3f3f3f3f, sizeof(dp));
        dp[0] = 2;

        for (int i = 1; i < n; i++) {
            int res = 0;
            int right = i, left = i;
            for (left = i; left >= 0; left--) {
                if (res + boxes[left][1] > maxWeight || right - left + 1 > maxBoxes) {
                    break;
                }
                res += boxes[left][1];

                int between_left_right = 2;
                for (int j = left + 1; j <= right; j++) {
                    between_left_right += (boxes[j][0] != boxes[j - 1][0]);
                }
                dp[i] = min(dp[i], (left == 0 ? 0 : dp[left - 1]) + between_left_right);
                // printf("%d %d %d %d\n", left, right, dp[i], between_left_right);
            }
        }

        return dp[n - 1];

        
    }
    
};