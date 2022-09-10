class MyQueue {
    Deque<Integer> s1 = new LinkedList();
    Deque<Integer> s2 = new LinkedList();

    public MyQueue() {

    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if (!s2.isEmpty()) {
            return s2.pop();
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        return s2.pop();
    }

    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}