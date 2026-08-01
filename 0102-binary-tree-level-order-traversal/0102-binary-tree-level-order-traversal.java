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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> arr=new ArrayList<>();

        if(root==null){
            return arr;
        }

        Queue<TreeNode>q=new ArrayDeque<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<size;i++){
            TreeNode el=q.remove();
            temp.add(el.val);
            if(el.left!=null){
                q.add(el.left);
            }
            if(el.right!=null){
                q.add(el.right);
            }

            
        }
        arr.add(temp);
        }
        

        return arr;
        
    }
}