class Solution {
    Map<Character, char[]> m = new HashMap();
    List<String> ans = new ArrayList();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return ans;

        m.put('2', new char[]{'a','b','c'});
        m.put('3', new char[]{'d','e','f'});
        m.put('4', new char[]{'g','h','i'});
        m.put('5', new char[]{'j','k','l'});
        m.put('6', new char[]{'m','n','o'});
        m.put('7', new char[]{'p','q','r','s'});
        m.put('8', new char[]{'t','u','v'});
        m.put('9', new char[]{'w','x','y','z'});

        StringBuilder s = new StringBuilder();
        dfs(0, digits, s);
        return ans;
    }

    private void dfs(int pos, String digits,  StringBuilder s) {
        if (pos == digits.length()) {
            ans.add(s.toString());
            return;
        }

        char num = digits.charAt(pos);
        for (char c : m.get(num)) {
            s.append(c);
            dfs(pos + 1, digits, s);
            s.deleteCharAt(pos);
        }
    }
}