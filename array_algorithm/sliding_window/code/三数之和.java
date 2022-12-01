class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List <List<Integer>> ret=new ArrayList();
        int n=nums.length;
        for(int first=0;first<n;first++){
            if(first>0&&nums[first]==nums[first-1]) continue;
            int third=n-1;
            for(int second=first+1;second<third;second++){
                if(second>first+1&&nums[second]==nums[second-1]) continue;
                while(second<third&&nums[first]+nums[second]+nums[third]>0) third--;
                if(second==third) break;
                if(nums[first]+nums[second]+nums[third]==0){
                    List <Integer> ad=new ArrayList();
                    ad.add(nums[first]);
                    ad.add(nums[second]);
                    ad.add(nums[third]);
                    ret.add(ad);
                }
            }
        }
        return ret;
    }
}