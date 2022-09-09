class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> p = new PriorityQueue();
        int[] ans = new int[k];

        for (int i = 0; i < arr.length; i++) {
            p.add(arr[i]);
        }

        for (int i = 0; i < k; i++) {
            ans[i] = p.poll();
        }

        return ans;
    }
}