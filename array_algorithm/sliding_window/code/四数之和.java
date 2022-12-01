class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length<4) return new ArrayList();
        Arrays.sort(nums);
        List <List<Integer>> ret=new ArrayList();
        int n=nums.length;
        for(int a=0;a<n-3;a++){
            if(a>0&&nums[a]==nums[a-1]) continue;
            for(int b=a+1;b<n-2;b++){
                if(b>a+1&&nums[b]==nums[b-1]) continue;
                int c=b+1,d=n-1;
                while(c<d){
                    if(nums[a]+nums[b]-target<-(nums[c]+nums[d]))
                        c++;
                    else if(nums[a]+nums[b]-target>-(nums[c]+nums[d]))
                        d--;
                    else{
                        List <Integer> ad=new ArrayList();
                        ad.add(nums[a]);
                        ad.add(nums[b]);
                        ad.add(nums[c]);
                        ad.add(nums[d]);
                        ret.add(ad);
                        while(c<d&&nums[c+1]==nums[c])
                            c++;
                        while(c<d&&nums[d-1]==nums[d])
                            d--;
                        c++;
                        d--;
                    }
                }
            }
        }
        return ret;
    }
}