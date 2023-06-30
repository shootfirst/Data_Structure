class MyStack {
    // https://leetcode.cn/problems/implement-stack-using-queues/
    Queue<Integer> q1 = new LinkedList();
    Queue<Integer> q2 = new LinkedList();

    public MyStack() {

    }

    public void push(int x) {
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}