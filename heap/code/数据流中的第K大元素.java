class KthLargest {
    MinHeap heap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new MinHeap(20000);
        for (int i : nums) heap.add(i);

    }

    public int add(int val) {
        heap.add(val);
        while(heap.getLen() > k) heap.pop();
        return heap.peek();
    }
}

class MinHeap {

    private int[] arr;
    private int size;
    private int len;

    public MinHeap(int size) {
        arr = new int[size + 1];
        len = 0;
        // no use
        arr[0] = 0;
        this.size = size;
    }

    public int getLen() {
        return len;
    }

    public int peek() {
        return arr[1];
    }


    public void add(int e) {
        if (len == size) return;
        len++;
        arr[len] = e;
        int index = len, parent = index / 2;
        while (arr[index] < arr[parent] && index > 1) {
            int tmp = arr[parent];
            arr[parent] = arr[index];
            arr[index] = tmp;

            index /= 2;
            parent /= 2;
        }
    }

    public int pop() {
        if (len == 0) return -1;
        len--;
        int ans = arr[1];
        arr[1] = arr[len];


        int index = 1;

        while (index <= len / 2) {
            int left = index * 2;
            int right = index * 2 + 1;
            if (arr[index] > arr[left] || arr[index] > arr[right]) {
                if (arr[left] < arr[right]) {
                    int tmp = arr[left];
                    arr[left] = arr[index];
                    arr[index] = tmp;
                    index = left;
                } else {
                    int tmp = arr[right];
                    arr[right] = arr[index];
                    arr[index] = tmp;
                    index = right;
                }
            } else {
                break;
            }
        }

        return ans;
    }
}

