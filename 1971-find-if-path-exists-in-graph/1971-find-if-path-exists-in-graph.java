class Solution {
    public boolean solve(List<List<Integer>>adj,int start,int dest,boolean[] visited){
        if(start==dest){
            return true;
        }
        visited[start]=true;
        for(int i=0;i<adj.get(start).size();i++){
            int neighbour=adj.get(start).get(i);
            if(!visited[neighbour]  && solve(adj,neighbour,dest,visited) ){
                return true;
            }
        }

        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination) return true;
        boolean visited[]=new boolean[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return solve(adj,source,destination,visited);

    }
}