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
    public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ans=new ArrayList<>();
    if(root==null){
        return ans;
    }
     ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
     Queue<TreeNode> q=new LinkedList<>();
     q.offer(root);
     while(!q.isEmpty()){
        int size=q.size();
        ArrayList<Integer> temp=new ArrayList<>();
        for(int i=0;i<size;i++){
            TreeNode node=q.poll();
            temp.add(node.val);
            if(node.left!=null){
                q.offer(node.left);
            }
            if(node.right!=null){
                q.offer(node.right);
            }
        }
        

        arr.add(temp);
     
     }

     for(int i=0;i<arr.size();i++){
        ArrayList<Integer> temp=arr.get(i);
        ans.add(temp.get(temp.size()-1));
     }
     return ans;   

    }
}