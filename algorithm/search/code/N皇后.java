class Solution {
    // https://leetcode.cn/problems/n-queens/
    // 皇后数量
    int n;
    // 列是否有皇后
    int [] col;
    // 主对角线是否有皇后
    int [] main;
    // 副对角线是否有皇后
    int [] sub;
    // 答案
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        ans= new ArrayList();
        if (n == 0) return ans;

        this.n = n;
        this.col = new int [n];
        this.main = new int [2 * n - 1];
        this.sub = new int [2 * n - 1];

        Deque<Integer> stack = new LinkedList();

        dfs(0, stack);

        return ans;
    }

    private void dfs(int row, Deque<Integer> stack) {
        // 走到n，表明成功，保存结果我们返回
        if (row == n) {
            ans.add(convert2board(stack));
            return;
        }

        // 尝试当前行的所有列

        for (int i = 0; i < n; i++) {
            // 若当前位置(row, i)可以放置皇后，我们开始下一轮dfs
            if (col[i] == 0 && main[row - i + n - 1] == 0 && sub[row + i] == 0) {
                // 我们状态变量
                col[i] = 1;
                main[row - i + n - 1] = 1;
                sub[row + i] = 1;
                stack.addLast(i);
                // 注意这里的row也是状态变量，但是这是基本类型，底层会复制，所以我们不需要恢复
                dfs(row + 1, stack);
                // 这个是全局唯一的对象，故我们需要回退状态变量
                stack.removeLast();
                col[i] = 0;
                main[row - i + n - 1] = 0;
                sub[row + i] = 0;
            }
        }
    }

    private List<String> convert2board(Deque<Integer> path) {
        List<String> ret = new ArrayList();
        for (int i : path) {
            StringBuilder res = new StringBuilder();
            int j;
            for (j = 0; j < i; j++) {
                res.append(".");
            }
            res.append("Q");
            for (j = j + 1; j < n; j++) {
                res.append(".");
            }
            ret.add(res.toString());
        }
        return ret;
    }
}