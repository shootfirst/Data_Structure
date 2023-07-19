# include <iostream>
# include <cstring>
using namespace std;

int main() {
    // https://www.acwing.com/problem/content/284/
    int n;
    cin >> n;
    int stones[n + 1];
    stones[0] = 0;
    for (int i = 1; i <= n; i++) {
        cin >> stones[i];
        stones[i] += stones[i - 1];
    }
    int dp[n][n]; // 合并石头[i, j]的成本
    memset(dp, 0x3f3f3f3f, sizeof(dp));
    
    for (int i = 0; i < n; i++) {
        dp[i][i] = 0;
    }
    
    for (int len = 2; len <= n; len++) {
        for (int i = 0; i + len - 1 < n; i++) {
            int left = i, right = i + len - 1;
            for (int mid = left + 1; mid <= right; mid++) {
                dp[left][right] = min(dp[left][right], dp[left][mid - 1] + dp[mid][right] + stones[right + 1] - stones[left]);
            }
            
        }
    }
    
    cout << dp[0][n - 1] << endl;
}