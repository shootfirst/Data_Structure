class Solution {
    //求左边界：向下取整，等号归右，左加一
    //求右边界：向上取整，等号归左，右减一
    //总是右侧为所求
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[]{-1,-1};
        if(n == 0) return res;
        int left = 0, right = n-1;
        while(left<right){//求左边界
            int mid = (left+right)>>1;//向下取整
            if(nums[mid] >= target) right = mid;//等号归右
            else left = mid+1;//左加一
        }
        if(nums[right] != target) return res;
        res[0] = right;//总是右侧为所求
        left = right;//（上一步已经求出来左边界了）
        right = n-1;
        while(left<right){//求右边界
            int mid = (left + right +1)>>1;//向上取整
            if(nums[mid] <= target) left = mid;//等号归左
            else right = mid-1;//右减一
        }
        res[1] = right;//总是右侧为所求
        return res;
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[2];
        res[0]=leftSearch(nums,target);
        res[1]=rightSearch(nums,target);
        return res;
    }

    private int leftSearch(int[] nums, int target){
        if(nums==null||nums.length==0) return -1;

        int l=0,r=nums.length-1;
        while(l+1<r){
            int mid=l+(r-l)/2;
            if(nums[mid]<target){
                l=mid;
            }
            else{
                r=mid;
            }
        }
        if(nums[l]==target) return l;
        if(nums[r]==target) return r;

        return -1;
    }

    private int rightSearch(int[] nums, int target){
        if(nums==null||nums.length==0) return -1;

        int l=0,r=nums.length-1;
        while(l+1<r){
            int mid=l+(r-l)/2;
            if(nums[mid]<=target){
                l=mid;
            }
            else{
                r=mid;
            }
        }
        if(nums[r]==target) return r;
        if(nums[l]==target) return l;

        return -1;
    }
}
