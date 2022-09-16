class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> s = new HashMap();

        for (int i : nums) {
            s.put(i, s.getOrDefault(i, 0) + 1);
        }

        MaxHeap heap = new MaxHeap(s.size(), s);
        int [] arr = new int[s.size()];

        Iterator it = s.keySet().iterator();

        while(it.hasNext()) {
            heap.add((int)it.next());
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) ans[i] = heap.pop();

        return ans;


    }
}

class MaxHeap {
    Map<Integer, Integer> s;
    int size;
    int len;
    int[] arr;

    MaxHeap(int n, Map<Integer, Integer> m) {
        s = m;
        size = n;
        len = 0;
        arr = new int[size + 1];
    }

    void add(int e) {
        if (len == size) return;

        len++;
        arr[len] = e;

        int index = len;
        int parent = index / 2;

        while (index > 1 && s.get(arr[index]) > s.get(arr[parent])) {
            int tmp = arr[parent];
            arr[parent] = arr[index];
            arr[index] = tmp;
            index /= 2;
            parent /= 2;
        }
    }

    int pop() {
        if (len == 0) return -1;
        int ans = arr[1];
        arr[1] = arr[len];
        len--;
        int index = 1;
        while (index <= len / 2) {
            int left = index * 2;
            int right = index * 2 + 1;

            if (s.get(arr[index]) < s.get(arr[left]) || s.get(arr[index]) < s.get(arr[right])) {
                if (s.get(arr[left]) > s.get(arr[right])) {
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