/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p|| root==q){
            return root;
        }

        TreeNode lcaleft=lowestCommonAncestor(root.left,p,q);
        TreeNode lcaright=lowestCommonAncestor(root.right,p,q);

        if(lcaleft==null){
            return lcaright;
        }
        if(lcaright==null){
            return lcaleft;
        }

        return root;
    }
}