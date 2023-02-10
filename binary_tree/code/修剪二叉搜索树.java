/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 递归法
    // public TreeNode trimBST(TreeNode root, int low, int high) {
    //     if (root == null) return null;
    //     if (root.val < low) return trimBST(root.right, low, high);
    //     if (root.val > high) return trimBST(root.left, low, high);

    //     root.left = trimBST(root.left, low, high);
    //     root.right = trimBST(root.right, low, high);

    //     return root;
    // }

    // 迭代法

    public TreeNode trimBST(TreeNode root, int low, int high) {
        while (root != null && (root.val < low || root.val > high)) {
            if (root.val < low) root = root.right;
            else root = root.left;
        }
        if (root == null) return null;

        // 现在的root的val在区间中
        // 我们修剪左子树
        TreeNode cur = root;
        while (cur != null) {
            while (cur.left != null && cur.left.val < low) {
                cur.left = cur.left.right;
            }
            cur = cur.left;
        }

        // 我们修剪右子树
        cur = root;
        while (cur != null) {
            while (cur.right != null && cur.right.val > high) {
                cur.right = cur.right.left;
            }
            cur = cur.right;
        }

        return root;
    }
}