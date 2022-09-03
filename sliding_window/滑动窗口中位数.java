class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        double[] ret=new double[n-k+1];
        DualHeap heap=new DualHeap(k);
        for(int i=0;i<k;i++) heap.insert(nums[i]);
        ret[0]=heap.getMedian();
        for(int i=k;i<n;i++){
            heap.insert(nums[i]);
            heap.erase(nums[i-k]);
            ret[i-k+1]=heap.getMedian();
        }
        return ret;
    }
}

class DualHeap{
    private PriorityQueue <Integer> small;
    private PriorityQueue <Integer> large;
    private int k;
    private int smallSize;
    private int largeSize;
    private Map <Integer,Integer> delayed;

    public DualHeap(int k){
        this.small=new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                return b.compareTo(a);
            }
        });
        this.large=new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                return a.compareTo(b);
            }
        });
        this.k=k;
        this.smallSize=0;
        this.largeSize=0;
        this.delayed=new HashMap<Integer,Integer>();
    }

    public double getMedian(){
        return (k&1)==1? small.peek():((double)small.peek()+large.peek())/2;
    }

    public void insert(int num){
        if(small.isEmpty()||small.peek()>=num){
            small.offer(num);
            ++smallSize;
        }else{
            large.offer(num);
            ++largeSize;
        }
        makeBalance();
    }

    public void erase(int num){
        delayed.put(num,delayed.getOrDefault(num,0)+1);
        if(small.peek()>=num){
            --smallSize;
            if(num==small.peek()){
                prune(small);
            }
        }else{
            --largeSize;
            if(num==large.peek()){
                prune(large);
            }
        }
        makeBalance();
    }

    public void prune(PriorityQueue<Integer> heap){
        while(!heap.isEmpty()){
            int num=heap.peek();
            if(delayed.containsKey(num)){
                delayed.put(num,delayed.get(num)-1);
                if(delayed.get(num)==0) delayed.remove(num);
                heap.poll();
            }else break;
        }
    }

    public void makeBalance(){
        if(largeSize>smallSize){
            small.offer(large.poll());
            largeSize--;
            smallSize++;
            prune(large);
        }
        else if(largeSize+1<smallSize){
            large.offer(small.poll());
            largeSize++;
            smallSize--;
            prune(small);
        }
    }

}
