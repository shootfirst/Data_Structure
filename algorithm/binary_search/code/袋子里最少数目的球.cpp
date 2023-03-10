class Solution {
public:
    int minimumSize(vector<int>& nums, int maxOperations) {
        int left = 1, right = *max_element(nums.begin(), nums.end());
        int ans = 0;
        while (left <= right) {
            int mid = (right + left) / 2;
            int cnt = 0;
            for (int i = 0; i < nums.size(); i++) {
                cnt += (nums[i] - 1) / mid;
            }
            if (cnt <= maxOperations) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
};