class Solution {
public:
    bool checkPowersOfThree(int n) {
        // int i = 1;
        // while (i < n) {
        //     i *= 3;
        // }
        // if (i == n) return true;

        // i /= 3;
        // n -= i;
        // i /= 3;
        
        // while (i > 0) {
        //     while (i > n) {
        //         i /= 3;
        //     }
        //     if (n > i) {
        //         n -= i;
        //         i /= 3;
        //     } else {
        //         return true;
        //     }
        // }
        // return false;

        // 高效三进制解法

        while (n > 1) {
            if (n % 3 == 2) return false;
            n /= 3;
        }
        return true;
    }
};
