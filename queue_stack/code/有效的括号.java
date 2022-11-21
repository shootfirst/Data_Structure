class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            switch (c) {
                case ')' :
                    if (stack.isEmpty() || (char)stack.pop() != '(') return false;
                    break;
                case ']' :
                    if (stack.isEmpty() || (char)stack.pop() != '[') return false;
                    break;
                case '}' :
                    if (stack.isEmpty() || (char)stack.pop() != '{') return false;
                    break;
                default :
                    stack.push(c);
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}