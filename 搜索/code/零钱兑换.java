class Solution {
    // bfs
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Queue<Integer> q = new LinkedList();
        q.add(amount);
        boolean [] visit = new boolean [amount + 1];
        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                amount = q.poll();

                for (int money : coins) {
                    if (amount < money) continue;
                    else if (amount == money) return step;
                    else {
                        if (!visit[amount - money]) {
                            visit[amount - money] = true;
                            q.add(amount - money);
                        }
                    }
                }

            }

            step++;
        }

        return -1;
    }
}

class Solution {
    // dfs
    int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        dfs(coins, coins.length - 1, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    void dfs(int[] coins, int index, int amount, int count) {
        if (amount == 0) {
            res = Math.min(res, count);
            return;
        }
        if (index < 0) return;
        
        // i + count < res 剪枝
        for (int i = amount / coins[index]; i >= 0 && i + count < res; i--){
            dfs(coins, index - 1, amount - i * coins[index], count + i);
        }
    }
}

class Solution {
    // 记忆化搜索
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        memo = new int[amount];

        return dfs(coins,amount);
    }
    // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
    // findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
    public int dfs(int[] coins,int amount){
        if(amount < 0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }
        // 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
        // 直接的返回memo[n] 的最优值
        if (memo[amount-1] != 0) {
            return memo[amount-1];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < coins.length;i++){
            int res = dfs(coins,amount-coins[i]);
            if(res >= 0 && res < min){
                min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
            }
        }
        memo[amount-1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount-1];
    }
}

class Solution {
    // 一维背包
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int n = coins.length;
        int[] dp = new int [amount + 1];

        for (int j = 1; j <= amount; j++) {
            if (j % coins[0] == 0) dp[j] = j / coins[0];
            else dp[j] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i])
                    dp[j] = Math.min(dp[j],
                            dp[j - coins[i]] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[j - coins[i]] + 1);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    // 二维背包
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int n = coins.length;
        int[][] dp = new int [n][amount + 1];

        for (int j = 1; j <= amount; j++) {
            if (j % coins[0] == 0) dp[0][j] = j / coins[0];
            else dp[0][j] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.min(dp[i - 1][j],
                    dp[i][j - coins[i]] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[i][j - coins[i]] + 1);
            }
        }

        return dp[n - 1][amount] == Integer.MAX_VALUE ? -1 : dp[n - 1][amount];
    }
}