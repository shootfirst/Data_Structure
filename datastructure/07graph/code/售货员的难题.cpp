#include <iostream>
#include <string.h>
#include <vector>
using namespace std;
int main() {
    int vil_num = 0;
    cin >> vil_num;
    vector<vector<int>> graph(vil_num, vector<int>(vil_num, 0));
    for (int i = 0; i < vil_num; i++) {
        for (int j = 0; j < vil_num; j++) {
            cin >> graph[i][j];
        }
    }
    int mask = 1 << vil_num;
    int dp [mask][vil_num];
    memset(dp, 0x3f, sizeof(dp));
    
    dp[1][0] = 0;
    
    for (int m = 3; m < mask; m += 2) {
        for (int i = 1; i < vil_num; i++) {
            if ((m & (1 << i)) != 0) {
                for (int j = 0; j < vil_num; j++) {
                    if ((m & (1 << j)) != 0 && i != j) {
                        dp[m][i] = min(dp[m][i], dp[m - (1 << i)][j] + graph[j][i]);
                    }
                }
            }
        }
    }
    
    int ans = 0x3f3f3f3f;
    for (int i = 1; i < vil_num; i++) {
        ans = min(ans, dp[mask - 1][i] + graph[i][0]);
    }
    
    cout << ans << endl;
}