class Solution {
public:
    vector<int> pos = vector(80000, -1);
    int minIncrementForUnique(vector<int>& nums) {
        int len = nums.size();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += findPos(nums[i]) - nums[i];
        }
        return ans;
    }

    int findPos(int num) {
        // 未冲突
        if (pos[num] == -1) {
            pos[num] = num;
            return num;
        // 冲突
        } else {
            int b = findPos(num + 1);
            pos[num] = b;
            return b;
        }
    }
};