class Solution {
    public boolean dfsutil(int start,int [] [] graph,boolean visited[],boolean[] stack){
        visited[start]=true;
        stack[start]=true;
        for(int i=0;i<graph[start].length;i++){
           int n=graph[start][i];
           if(stack[n]) return  true;
           if(!visited[n] && dfsutil(n,graph,visited,stack)) return true;
        }
        stack[start]=false;
        return false;
        
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans=new ArrayList<>();
        boolean visited[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];
        
        for(int i=0;i<graph.length;i++){
            
                if(dfsutil(i,graph,visited,stack)) continue;
                else ans.add(i);
            
        }

       

        return ans;
    }
}