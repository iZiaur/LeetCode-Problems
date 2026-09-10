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
    public int sum(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=sum(root.left);
        int right=sum(root.right);
        int ans=left+right+root.val;
        return ans;
    }
    public int count(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=count(root.left);
        int right=count(root.right);
        int ans=left+right+1;
        return ans;
    }
    public void preorder(TreeNode root,ArrayList<TreeNode> arr){
        if(root==null){
            return;
        }
        arr.add(root);
        preorder(root.left,arr);
        preorder(root.right,arr);
    }
    public int averageOfSubtree(TreeNode root) {
        if(root==null){
            return 0;
        }
        ArrayList<TreeNode>arr=new ArrayList<>();
        preorder(root,arr);
        // Set<Integer> values = new HashSet<>();
        // for (TreeNode node : arr) {
        // if (node != null) {
        // values.add(node.val);
        // }
        
        // HashSet<Integer> finalset=new HashSet<>();
        int counter=0;
        for(int i=0;i<arr.size();i++){
        TreeNode curr=arr.get(i);
           int nodecount=count(curr);
           if(nodecount==0) continue;
           Integer average=sum(curr)/nodecount;
           System.out.println(average);
           if(average==curr.val) counter++;
            
        }
        return counter;
    }
}