class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        QueueInteger q = new LinkedList();
        q.add(amount);
        boolean [] visit = new boolean [amount + 1];
        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i  size; i++) {
                amount = q.poll();

                for (int money  coins) {
                    if (amount  money) continue;
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