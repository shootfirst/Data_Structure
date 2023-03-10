class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int len = nums.size();
        vector<int> maxV(nums), minV(nums);

        for (int i = 1; i < len; i++) {
            maxV[i] = max(maxV[i - 1] * nums[i], max(nums[i], minV[i - 1] * nums[i]));
            minV[i] = min(maxV[i - 1] * nums[i], min(nums[i], minV[i - 1] * nums[i]));
        }

        return *max_element(maxV.begin(), maxV.end());
    }
};