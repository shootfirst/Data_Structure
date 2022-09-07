class Solution {

    private static final int MAX_LENGTH = 100000 + 1;
    private int[][] cnt = new int[26][MAX_LENGTH];

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> ans = new ArrayList();
        int len = s.length();
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < 26; j++) {
                cnt[j][i] = cnt[j][i - 1];
            }
            cnt[s.charAt(i - 1) - 'a'][i]++;
        }

        len = queries.length;
        for (int i = 0; i < len; i++) {
            int ocnt = 0;
            for (int j = 0; j < 26; j++) {
                if ((cnt[j][queries[i][1] + 1] - cnt[j][queries[i][0]]) % 2 == 1) ocnt++;
            }
            if (ocnt - (queries[i][1] + 1 - queries[i][0]) % 2 <= 2 * queries[i][2]) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }

        return ans;

    }
}