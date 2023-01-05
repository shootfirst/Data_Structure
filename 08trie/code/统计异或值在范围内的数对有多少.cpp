class Tire {
    public:
    array<Tire*, 2> child {nullptr, nullptr};
    int sum = 0;
};

class Solution {
public:
    Tire *root = nullptr;
    static const int HIGH_BIT = 14;

    void add(int num) {
        Tire *cur = root;
        for (int k = HIGH_BIT; k >= 0; k--) {
            int bit = (num >> k) & 1;
            if (cur->child[bit] == nullptr) {
                cur->child[bit] = new Tire;
            }
            cur = cur->child[bit];
            cur->sum++;
        }
    }

    int get(int num, int x) {
        Tire *cur = root;
        int sum = 0;

        for (int k = HIGH_BIT; k >= 0; k--) {
            int r = (num >> k) & 1;

            if ((x >> k) & 1) {
                if (cur->child[r] != nullptr) {
                    sum += cur->child[r]->sum;
                }
                if (cur->child[r ^ 1] == nullptr) {
                    return sum;
                }
                cur = cur->child[r ^ 1];
            } else {
                if (cur->child[r] == nullptr) {
                    return sum;
                }
                cur = cur->child[r];
            }
        }

        sum += cur->sum;
        return sum;
    }

    int f(vector<int>& nums, int x) {
        root = new Tire;
        int ans = 0;
        for (int i = 1; i < nums.size(); i++) {
            add(nums[i - 1]);
            ans += get(nums[i], x);
        }
        return ans;
    }


    int countPairs(vector<int>& nums, int low, int high) {
        return f(nums, high) - f(nums, low - 1);
    }
};