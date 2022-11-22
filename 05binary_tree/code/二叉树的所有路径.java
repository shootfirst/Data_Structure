class Solution {
    // 递归法
    // public List<String> binaryTreePaths(TreeNode root) {
    //     List<Integer> path = new ArrayList();
    //     List<String> ans = new ArrayList();
    //     tranversal(root, path, ans);
    //     return ans;
    // }

    // public void tranversal(TreeNode root, List<Integer> path, List<String> ans) {
    //     path.add(root.val);

    //     if (root.left == null && root.right == null) {
    //         StringBuilder s = new StringBuilder();
    //         for (int i = 0; i < path.size() - 1; i++) {
    //             s.append(path.get(i));
    //             s.append("->");
    //         }
    //         s.append(path.get(path.size() - 1));
    //         ans.add(s.toString());
    //     }

    //     if (root.left != null) {
    //         tranversal(root.left, path, ans);
    //         // 回溯！！！
    //         path.remove(path.size() - 1);
    //     }

    //     if (root.right != null) {
    //         tranversal(root.right, path, ans);
    //         // 回溯！！！
    //         path.remove(path.size() - 1);
    //     }
    // }


    // 迭代法
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> path = new ArrayList();
        List<String> ans = new ArrayList();
        List<TreeNode> nd = new ArrayList();
        if (root == null) return ans;

        path.add("" + root.val);
        nd.add(root);
        while (!nd.isEmpty()) {
            root = nd.remove(nd.size() - 1);
            String s = path.remove(path.size() - 1);
            if (root.left == null && root.right == null) {
                ans.add(s);
            }

            if (root.left != null) {
                nd.add(root.left);
                path.add(s + "->" + root.left.val);
            }

            if (root.right != null) {
                nd.add(root.right);
                path.add(s + "->" + root.right.val);
            }
        }

        return ans;
    }
}