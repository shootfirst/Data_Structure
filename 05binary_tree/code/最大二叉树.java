class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[max] < nums[i]) max = i;
        }
        TreeNode root = new TreeNode(nums[max]);
        int[] nums1 = Arrays.copyOfRange(nums, 0, max);
        int[] nums2 = Arrays.copyOfRange(nums, max + 1, nums.length);
        root.left = constructMaximumBinaryTree(nums1);
        root.right = constructMaximumBinaryTree(nums2);
        return root;
    }
}