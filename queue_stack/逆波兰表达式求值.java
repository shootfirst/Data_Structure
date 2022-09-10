class Solution {
    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        int ans = 0;
        Deque<Integer> stack = new LinkedList();
        int a, b;
        for (String s : tokens) {
            switch (s) {

                case "+" :
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a + b);
                    break;
                case "-" :
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                    break;
                case "*" :
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a * b);
                    break;
                case "/" :
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b / a);
                    break;

                default :
                    stack.push(Integer.parseInt(s));

            }
        }

        return stack.pop();

    }
}