class MinStack {
    Deque<Integer> stack1 = new LinkedList();
    Deque<Integer> stack2 = new LinkedList();

    public MinStack() {
        stack2.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack1.push(val);
        stack2.push(Math.min(stack2.peek(), val));
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}