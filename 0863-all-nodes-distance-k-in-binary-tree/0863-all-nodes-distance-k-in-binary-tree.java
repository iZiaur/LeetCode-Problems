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
    public void markParent(TreeNode root,HashMap<TreeNode,TreeNode>map){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr.left!=null){
                map.put(curr.left,curr);
                q.add(curr.left);
            }
            if(curr.right!=null){
                map.put(curr.right,curr);
                q.add(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parentmap=new HashMap<>();
        markParent(root,parentmap);
        HashMap<TreeNode,Boolean> visited=new HashMap<>();
        visited.put(target,true);
        int currcount=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(target);
        while(!q.isEmpty()){
            int size=q.size();
            
            if(currcount==k) break;
            currcount++;
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null && visited.get(curr.left)==null){
                    visited.put(curr.left,true);
                    q.add(curr.left);
                }
                if(curr.right!=null && visited.get(curr.right)==null){
                    visited.put(curr.right,true);
                    q.add(curr.right);
                }
                if(parentmap.get(curr)!=null && visited.get(parentmap.get(curr))==null){
                    visited.put(parentmap.get(curr),true);
                    q.add(parentmap.get(curr));
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }

        return ans;
    }
}