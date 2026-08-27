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
    public boolean getPath(TreeNode root,TreeNode n1,ArrayList<TreeNode>path){
        if(root==null){
            return false;
        }
        path.add(root);
        if(root==n1){
            return true;
        }

        boolean left=getPath(root.left,n1,path);
        boolean right=getPath(root.right,n1,path);
        if(left||right){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1=new ArrayList<>();
        ArrayList<TreeNode> path2=new ArrayList<>();

        getPath(root,p,path1);
        getPath(root,q,path2);
        int i=0;
        for(;i<path1.size() && i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }

        return path1.get(i-1);
    }
}