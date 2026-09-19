class Solution {
    static class Pair{
        int node;
        int cost;
        int stops;
        public Pair(int node,int cost,int stops){
            this.node=node;
            this.cost=cost;
            this.stops=stops;
        }
    }

    static class EdgeInfo{
        int node;
        int cost;

        public EdgeInfo(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<EdgeInfo>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int [] edge:flights){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            adj.get(u).add(new EdgeInfo(v,wt));
        }

        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.stops-b.stops);
        pq.add(new Pair(src,0,0));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            if(p.stops>k) continue;
           
                
                ArrayList<EdgeInfo> temp=adj.get(p.node);
                for(int i=0;i<temp.size();i++){
                    EdgeInfo e=temp.get(i);
                    int v=e.node;
                    int wt=e.cost;
                    if(p.cost+wt<dist[v] && p.stops<=k){
                        dist[v]=p.cost+wt;
                        pq.add(new Pair(v,dist[v],p.stops+1));
                    }
                }
            
        }

        if(dist[dst]==Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}