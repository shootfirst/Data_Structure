class Solution {
    int maxCount = 0;
    int count = 0;
    ArrayList<Integer> res = new ArrayList();
    TreeNode pre = null;
    public int[] findMode(TreeNode root) {
        traversal(root);
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public void traversal(TreeNode root) {

        if (root == null) return;

        traversal(root.left);

        if (pre == null) {
            count = 1;
        } else if (pre.val == root.val) {
            count++;
        } else {
            count = 1;
        }

        pre = root;

        if (count == maxCount) res.add(root.val);

        if (count > maxCount) {
            res.clear();
            maxCount = count;
            res.add(root.val);
        }

        traversal(root.right);
    }
}