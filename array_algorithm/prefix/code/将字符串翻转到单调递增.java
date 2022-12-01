class Solution {
    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        int [] zero = new int[len + 1];
        int [] one = new int[len + 1];
        int ans = len;

        for(int i = 1; i <= len; i++) {
            if (s.charAt(i - 1) == '1') one[i] = one[i - 1] + 1;
            else one[i] = one[i - 1];
        }

        for(int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') zero[i] = zero[i + 1] + 1;
            else zero[i] = zero[i + 1];
        }

        for (int i = 0; i <= len; i++) {
            ans = Math.min(ans, one[i] + zero[i]);
        }

        return ans;
    }
}