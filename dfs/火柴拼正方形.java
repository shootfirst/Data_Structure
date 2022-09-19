class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int i : matchsticks) sum += i;

        if (sum == 0 || sum % 4 != 0) return false;

        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int tmp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = tmp;
        }
        int [] visit = new int[matchsticks.length];
        return dfs(0, 0, 0, visit, matchsticks, sum / 4);
    }

    public boolean dfs(int pos, int cnt, int sum, int [] visit, int[] matchsticks, int edge) {
        if (cnt == 4) return true;

        if (sum == edge) {
            return dfs(0, cnt + 1, 0, visit, matchsticks, edge);
        }

        for (int i = pos; i < matchsticks.length; i++) {
            if (sum + matchsticks[i] > edge) {
                continue;
            }
            if (visit[i] == 0) {
                visit[i] = 1;
                if (dfs(i + 1, cnt, sum + matchsticks[i], visit, matchsticks, edge)) return true;
                visit[i] = 0;
                // 重复去除，剪枝
                while (i + 1 < matchsticks.length && matchsticks[i + 1] == matchsticks[i]) i++;
            }
        }
        return false;

    }
}