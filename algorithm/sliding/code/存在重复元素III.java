class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n=nums.length;
        TreeSet<Long> set=new TreeSet();
        for(int i=0;i<n;++i){
            Long ceil=set.ceiling((long)nums[i]-(long)t);
            if(ceil!=null&&ceil<=(long)nums[i]+(long)t) return true;
            set.add((long)nums[i]);
            if(i>=k) set.remove((long)nums[i-k]);
        }
        return false;
    }
}