class Solution {
    public String decodeString(String s) {

        int num = 0;
        StringBuilder res = new StringBuilder();
        Deque<Integer> numStack = new ArrayDeque();
        Deque<StringBuilder> resStack = new ArrayDeque();

        char [] arr = s.toCharArray();

        for (char c : arr) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                numStack.push(num);
                num = 0;
                resStack.push(res);
                res = new StringBuilder();

            } else if (c == ']') {
                StringBuilder b = new StringBuilder();
                b = resStack.pop();
                int n = numStack.pop();
                for (int i = 0; i < n; i++) {
                    b.append(res);
                }

                res = b;

            } else {
                res.append(c);
            }
        }

        return res.toString();
    }
}