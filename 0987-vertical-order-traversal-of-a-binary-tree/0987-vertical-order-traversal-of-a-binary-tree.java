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
    class Pair{
        TreeNode node;
        int vertical;
        int horizontol;
        public Pair(TreeNode node,int vertical,int horizontol){
            this.node=node;
            this.vertical=vertical;
            this.horizontol=horizontol;

        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        List<List<Integer>> arr=new ArrayList<>();
        if(root==null){
            return arr;
        }

        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0,0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            TreeNode node=p.node;
            int data=p.node.val;
            int x=p.vertical;
            int y=p.horizontol;

            map.putIfAbsent(x,new TreeMap<>());
            map.get(x).putIfAbsent(y,new PriorityQueue<>());
            map.get(x).get(y).offer(data);

            if(node.left!=null){
                q.offer(new Pair(node.left,x-1,y+1));
            }
            if(node.right!=null){
                q.offer(new Pair(node.right,x+1,y+1));
            }
        }

        for(TreeMap<Integer,PriorityQueue<Integer>> cs:map.values()){
            List<Integer> temp=new ArrayList<>();
             for (PriorityQueue<Integer> pq : cs.values()) {
                while (!pq.isEmpty()) {
                    temp.add(pq.poll());
                }
                
            }
            arr.add(temp);
        }

        return arr;

        
    }
}