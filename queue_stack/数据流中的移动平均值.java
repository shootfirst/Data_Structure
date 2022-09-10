class MovingAverage {

    int [] nums;
    int head = -1, tail = -1;
    int sum = 0;
    int len = 0;
    int size = 0;

    public MovingAverage(int size) {
        nums = new int [size];
        this.size = size;
    }

    public double next(int val) {
        if (len == 0) {
            head = tail = 0;
            nums[tail] = val;
            sum += val;
            len++;
            return (double)val;
        } else if (len == nums.length) {
            sum -= nums[head];
            head = (head + 1) % size;
            tail = (tail + 1) % size;
            nums[tail] = val;
            sum += val;
            return (double)sum / (double)len;
        } else {
            tail = (tail + 1) % size;
            nums[tail] = val;
            sum += val;
            len++;
            return (double)sum / (double)len;
        }
    }

}