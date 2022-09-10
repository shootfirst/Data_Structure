class MyCircularQueue {

    int [] nums;
    int len;
    int head = -1, tail = -1;
    public MyCircularQueue(int k) {
        nums = new int [k];
        len = k;
    }

    public boolean enQueue(int value) {
        if (isEmpty()) {
            head = tail = 0;
            nums[head] = value;
            return true;
        } else if(isFull()) {
            return false;
        } else {
            tail = (tail + 1) % len;
            nums[tail] = value;
            return true;
        }
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else if(head == tail) {
            head = tail = -1;
            return true;
        } else {
            head = (head + 1) % len;
            return true;
        }
    }

    public int Front() {
        if (head == tail && head == -1) {
            return -1;
        }
        return nums[head];
    }

    public int Rear() {
        if (head == tail && head == -1) {
            return -1;
        }
        return nums[tail];
    }

    public boolean isEmpty() {
        return head == tail && head == -1;
    }

    public boolean isFull() {
        return (tail + 1) % len == head;
    }
}