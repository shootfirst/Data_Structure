class Solution {
    public int fib(int n) {
        // 1.确定dp数组及其下标含义：dp数组的值就是fib(n)的值，而n则是下标

        // 2.确定递推公式：根据fib函数的定义，fib(n) = fib(n - 1) + fib(n - 2)

        // 3.初始化：通过fib函数定义和递推公式，初始化时fib(0) = 0, fib(1) = 1

        // 4.确定遍历顺序：dp[i]是依赖 dp[i - 1] 和 dp[i - 2]，那么遍历的顺序一定是从前到后遍历的

        // 5.举例推导dp数组：求fib(3), fib0 = 0 fib1 = 1， fib2 = fib0 + fib1 = 1 fib3 = fib1 + fib2 = 2

        if (n == 0) return 0;
        int[] dp = new int [n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }
}