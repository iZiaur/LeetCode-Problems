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
    public void preorder(TreeNode root,ArrayList<TreeNode> preorder){
        if(root==null){
            return;
        }
        preorder.add(root);
        preorder(root.left,preorder);
        preorder(root.right,preorder);

    }
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        ArrayList<TreeNode> preorder=new ArrayList<>();
        preorder(root,preorder);
        for(int i=0;i+1<preorder.size();i++){
            TreeNode curr=preorder.get(i);
            curr.left=null;
            curr.right=preorder.get(i+1);
        }
    }
}