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
    public boolean lca(TreeNode root,TreeNode p,ArrayList<TreeNode>arr){
        if(root==null){
            return false;
        }
        arr.add(root);
        if(root==p){
            return true;
        }

        boolean left=lca(root.left,p,arr);
        boolean right=lca(root.right,p,arr);
        if(left||right){
            return true;
        }

        arr.remove(arr.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        ArrayList<TreeNode> arr1=new ArrayList<>();
        ArrayList<TreeNode> arr2=new ArrayList<>();
        lca(root,p,arr1);
        lca(root,q,arr2);
        int i=0;
        for(;i<Math.min(arr1.size(),arr2.size());i++){
            if(arr1.get(i)!=arr2.get(i)){
                break;
            }
        }

        return arr1.get(i-1);
    }
}