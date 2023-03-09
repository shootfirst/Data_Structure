class Solution {
public:
    int boxDelivering(vector<vector<int>>& boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.size();
        vector<int> dp(n + 1, 100000000);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; i - j <= maxBoxes - 1 && j >= 1; j--) {
                sum += boxes[j - 1][1];
                if (sum > maxWeight) break;
                dp[i] = min(dp[i], dp[j - 1] + cost(boxes, j, i));
            } 
        }
        return dp[n];
    }

    int cost(vector<vector<int>>& boxes, int left, int right) {
        int res = 2, pre = boxes[left - 1][0];
        while (++left <= right) {
            if (pre != boxes[left - 1][0]) {
                res++;
            }
            pre = boxes[left - 1][0];
        }
        return res;

    
    }
};

// 优化：前缀和，单调队列


class Solution {
public:
    int boxDelivering(vector<vector<int>>& boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.size();
        vector<int> dif(n + 1), w(n + 1), p(n + 1);
        vector<long long> W(n + 1);
        for (int i = 1; i <= n; i++) {
            p[i] = boxes[i - 1][0];
            w[i] = boxes[i - 1][1];
            if (i > 1) dif[i] = dif[i - 1] + (p[i] != p[i - 1]);
            W[i] = W[i - 1] + w[i];
        }
        // dp[i] = min{dp[j] + dif{j + 1, i} + 2} 
        //       = min{dp[j] + dif[i] - dif[j + 1] + 2} 
        //       = min{dp[j] - dif[j + 1]} + dif[i] + 2
        //       = min{g[j]} + dif[i] + 2
        vector<int> dp(n + 1), g(n + 1);
        deque<int> opt {0};
        for (int i = 1; i <= n; i++) {
            while (i - opt.front() > maxBoxes || W[i] - W[opt.front()] > maxWeight) {
                opt.pop_front();
            }
            dp[i] = g[opt.front()] + dif[i] + 2;

            if (i != n) {
                g[i] = dp[i] - dif[i + 1];

                while (!opt.empty() && g[opt.back()] >= g[i]) opt.pop_back();
                opt.push_back(i);
            }
        }
        return dp[n];
    }
};