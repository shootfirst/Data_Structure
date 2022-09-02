class Solution {
    public List<String> summaryRanges(int[] nums) {
        List <String> ret=new ArrayList();
        int dis=0;
        for(int i=0;i<nums.length;i++){
            while(i+1<nums.length&&nums[i+1]-nums[i]==1){
                i++;
                dis++;
            }
            if(dis==0) ret.add(""+nums[i]);
            else ret.add(""+nums[i-dis]+"->"+nums[i]);
            dis=0;
        }
        return ret;
    }
}