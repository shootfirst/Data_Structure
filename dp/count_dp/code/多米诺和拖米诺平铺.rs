impl Solution {
    pub fn num_tilings(n: i32) -> i32 {
        // 第i列前面的正方形都被覆盖，第i列后面的正方形都没有被覆盖，第i列有这么几种状态
        /*
            1.没有一个被覆盖
            2.上面的被覆盖
            3.下面的被覆盖
            4.全部被覆盖
            
            自己试着铺一铺
            dp[i][0] = dp[i - 1][3]
            dp[i][1] = dp[i - 1][0] + dp[i - 1][2]
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1]
            dp[i][3] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]
         */
        let p = 1000000007;
        // let mut dp = vec![vec![0; 4]; n as usize + 1];
        let mut dp = vec![vec![0_i64; 4]; n as usize + 1];
        dp[0][3] = 1;
        for i in 1..=n as usize {
            dp[i][0] = dp[i - 1][3];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % p;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % p;
            dp[i][3] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % p;
        }
        dp[n as usize][3] as i32
    }
}


