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

    public TreeNode build(int[] postorder,int startingpost,int endingpost,int[]inorder,int startinginorder,int endinginorder,HashMap<Integer,Integer>map){
        if(startingpost>endingpost||startinginorder>endinginorder){
            return null;
        }

        TreeNode root=new TreeNode(postorder[endingpost]);
        int indexofroot=map.get(postorder[endingpost]);
        int numsleft=indexofroot-startinginorder;
        root.left=build(postorder,startingpost,startingpost+numsleft-1,inorder,startinginorder,indexofroot-1,map);

        root.right=build(postorder,startingpost+numsleft,endingpost-1,inorder,indexofroot+1,endinginorder,map);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }


        return build(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);


    }
}