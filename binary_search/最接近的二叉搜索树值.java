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
    public int closestValue(TreeNode root, double target) {
        int pre=root.val;
        while(root!=null){
            if(target<root.val){
                root=root.left;
                if(root!=null)
                    pre=Math.abs(target-(double)root.val)<Math.abs(target-(double)pre)?root.val:pre;
            }else{
                root=root.right;
                if(root!=null)
                    pre=Math.abs(target-(double)root.val)<Math.abs(target-(double)pre)?root.val:pre;
            }
        }
        return pre;
    }
}
