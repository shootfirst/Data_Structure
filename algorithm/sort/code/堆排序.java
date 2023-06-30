private void heapSort(int [] nums) {
    int len = nums.length;
    PriorityQueue<Integer> q = new PriorityQueue();
    for (int i = 0; i < len; i++) {
        q.add(nums[i]);
    }
    for (int i = 0; i < len; i++) {
        nums[i] = q.poll();
    }
}