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
    public void inorder(TreeNode root,ArrayList<Integer>arr){
        if(root==null) return;

        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }

    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return true;
        }
        ArrayList<Integer> arr=new ArrayList<>();
        inorder(root,arr);
        int i=0;
        int j=arr.size()-1;
        while(i<j){
            int sum=arr.get(i)+arr.get(j);
            if(sum==k) return true;
            if(sum>k) j--;
            if(sum<k) i++;
        }

        return false;
        

        
    }
}