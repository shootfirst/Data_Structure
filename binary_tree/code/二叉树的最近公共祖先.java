class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 首先这个题目最好是要能够进行自底向上地查找，这里就使用回溯
        if (root == null || root == p || root == q) return root;

        // 注意这里为啥是两个孩子都搜索，而不是选择性地搜索
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        else if (left == null && right != null) return right;
        else return left;


    }
}

// 摘自代码随想录
/**
 * 这道题目刷过的同学未必真正了解这里面回溯的过程，以及结果是如何一层一层传上去的。
 *
 * 那么我给大家归纳如下三点：
 *
 * 1.求最小公共祖先，需要从底向上遍历，那么二叉树，只能通过后序遍历（即：回溯）实现从低向上的遍历方式。
 *
 * 2.在回溯的过程中，必然要遍历整棵二叉树，即使已经找到结果了，依然要把其他节点遍历完，因为要使用递归函数的返回值（也就是代码中的left和right）做逻辑判断。
 *
 * 3.要理解如果返回值left为空，right不为空为什么要返回right，为什么可以用返回right传给上一层结果。
 *
 * 可以说这里每一步，都是有难度的，都需要对二叉树，递归和回溯有一定的理解。
 *
 * 本题没有给出迭代法，因为迭代法不适合模拟回溯的过程。理解递归的解法就够了。
 */