class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] ret=new int[n-k+1];
        Deque<Integer> deque=new LinkedList();
        for(int i=0;i<k;i++){
            while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]) deque.pollLast();
            deque.offerLast(i);
        }
        ret[0]=nums[deque.peekFirst()];
        for(int i=k;i<n;i++){
            while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]) deque.pollLast();
            deque.offerLast(i);
            if(deque.peekFirst()<=i-k) deque.pollFirst();
            ret[i-k+1]=nums[deque.peekFirst()];
        }
        return ret;
    }
}