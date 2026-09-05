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

    public TreeNode build(int[] preorder,int startingpreorder,int endingpreorder,int[] inorder,int startinginorder,int endinginorder,HashMap<Integer,Integer>map){
        
        if(startingpreorder>endingpreorder||startinginorder>endinginorder){
            return  null;
        }

        TreeNode root=new TreeNode(preorder[startingpreorder]);
        int indexofroot=map.get(preorder[startingpreorder]);
        int numsleft=indexofroot-startinginorder;

        root.left=build(preorder,startingpreorder+1,startingpreorder+numsleft,inorder,startinginorder,indexofroot-1,map);
        root.right=build(preorder,startingpreorder+numsleft+1,endingpreorder,inorder,indexofroot+1,endinginorder,map);

        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }
}