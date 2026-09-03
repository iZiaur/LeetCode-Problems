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
    // public int sum(TreeNode root){
    //     if(root==null){
    //         return 0;
    //     }
    //     int left=sum(root.left);
    //     int right=sum(root.right);
    //     int sum=left.val+right.val;

    //     return sum;
    // }
    public boolean checkTree(TreeNode root) {
        if(root==null){
            return true;
        }
        
        if(root.val!=root.left.val+root.right.val){
            return false;
        }
        return true;
    }
}