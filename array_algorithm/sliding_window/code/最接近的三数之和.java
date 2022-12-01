// class Solution {
//     public int threeSumClosest(int[] nums, int target) {
//         int ret=0,n=nums.length,min=10000;
//         for(int first=0;first<n;first++){
//             if(first>0&&nums[first]==nums[first-1]) continue;
//             int third=n-1;
//             for(int second=first+1;second<third;second++){
//                 if(second>first+1&&nums[second]>nums[second-1]) continue;
//                 while(second<third&&nums[first]+nums[second]+nums[third]>target) third--;
//                 if(second==third){
//                     third++;
//                     int val=Math.abs(target-nums[first]-nums[second]-nums[third]);
//                     if(min>val){
//                         ret=nums[first]+nums[second]+nums[third];
//                     }
//                     break;
//                 }else{
//                     int val1=Math.abs(target-nums[first]-nums[second]-nums[third]);
//                     int val2=Math.abs(target-nums[first]-nums[second]-nums[third+1]);
//                     if(val1>val2&&val2<min){
//                         min=val2;
//                         ret=nums[first]+nums[second]+nums[third+1];
//                     }
//                     else if(val2>val1&&val1<min){
//                         min=val1;
//                         ret=nums[first]+nums[second]+nums[third];
//                     }
//                 }
//             }
//         }
//         return ret;
//     }
// }


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        for (int i = 0; i < n; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    int k0 = k - 1;
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    int j0 = j + 1;
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }
}