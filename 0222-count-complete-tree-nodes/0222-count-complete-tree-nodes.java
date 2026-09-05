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
    public int getLeft(TreeNode root){
        int count=0;
        TreeNode curr=root;
        while(curr!=null){
            count++;
            curr=curr.left;
        }
        return count;
    }

    public int getRight(TreeNode root){
        int count=0;
        TreeNode curr=root;
        while(curr!=null){
            count++;
            curr=curr.right;
        }

        return count;
    }
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=getLeft(root);
        int right=getRight(root);
        if(left==right){
            return ((1<<left)-1);
        }

        return 1+countNodes(root.left)+countNodes(root.right);

    }
}