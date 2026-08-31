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

    public int maxpathdown(TreeNode root,int arr[]){
        if(root==null){
            return 0;
        }
        int left=Math.max(0,maxpathdown(root.left,arr));
        int right=Math.max(0,maxpathdown(root.right,arr));
        arr[0]=Math.max(arr[0],left+right+root.val);
        return root.val+Math.max(left,right);

    }
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        int arr[]=new int[1];
        arr[0]=Integer.MIN_VALUE;
        maxpathdown(root,arr);
        return arr[0];
    }
}