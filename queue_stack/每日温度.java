class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int [] ans = new int [len];
        Deque<Integer> stack = new LinkedList();
        Deque<Integer> temp = new LinkedList();
        ans[len - 1] = 0;
        stack.push(0);
        temp.push(temperatures[len - 1]);

        for (int i = len - 2; i >= 0; i--) {
            if (temp.peek() > temperatures[i]) {
                ans[i] = 1;
            } else {
                ans[i] += stack.pop() + 1;
                temp.pop();
                while (!temp.isEmpty() && temp.peek() <= temperatures[i]) {
                    ans[i] += stack.pop();
                    temp.pop();
                }
                if (stack.isEmpty()) {
                    ans[i] = 0;
                }
            }
            stack.push(ans[i]);
            temp.push(temperatures[i]);
        }

        return ans;
    }
}