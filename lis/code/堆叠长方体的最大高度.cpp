class Solution {
public:
    int maxHeight(vector<vector<int>>& cuboids) {
        sort(cuboids.begin(), cuboids.end(), cmp);

        

    }

    static bool cmp(vector<int>&a, vector<int>&b) {
        sort(a.begin(), a.end());
        sort(b.begin(), b.end());

        if (a[2] < b[2]) return true;

        else if (a[2] > b[2]) return false;

        else {
            if (a[1] < b[1]) return true;

            else if (a[1] > b[1]) return false;

            else {
                if (a[0] <= b[0]) return true;

                else return false;
            }
        }
    }
};