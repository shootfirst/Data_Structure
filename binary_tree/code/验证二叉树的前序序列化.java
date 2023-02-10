class Solution {
    private int idx = 0;
    public boolean isValidSerialization(String preorder) {
        String[] node = preorder.split(",");
        if (node[idx].equals("#") && node.length != 1) {
            return false;
        } else if (node[idx].equals("#") && node.length == 1) {
            return true;
        }
        idx++;
        return check(node) && check(node) && idx == node.length;
    }

    public boolean check(String[] node) {
        if (idx >= node.length) {
            return false;
        }
        if (node[idx].equals("#")) {
            idx++;
            return true;
        } else {
            idx++;
            return check(node) && check(node);
        }
    }
}