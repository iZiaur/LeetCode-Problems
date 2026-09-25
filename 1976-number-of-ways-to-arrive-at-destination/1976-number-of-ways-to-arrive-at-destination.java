class Solution {
    class Pair{
        int v;
        int wt;

        public Pair(int v,int wt){
            this.v=v;
            this.wt=wt;
        }
    }

    class Edge{
        int node;
        long wt;
        public Edge(int node,long wt){
            this.node=node;
            this.wt=wt;
        }
    }
    public int countPaths(int n, int[][] roads) {
        
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int road[]:roads){
            int u=road[0];
            int v=road[1];
            int wt=road[2];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }

        long dist[]=new long[n];
        long ways[]=new long[n];
        ways[0]=1;
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        PriorityQueue<Edge>pq=new PriorityQueue<>((a,b)->Long.compare(a.wt,b.wt));
        pq.offer(new Edge(0,0));
        int counter=0;
        long mod = 1_000_000_007L;
        while(!pq.isEmpty()){
            Edge e=pq.poll();
            int node=e.node;
            long dis=e.wt;
            if(dis>dist[node]) continue;
            ArrayList<Pair>temp=adj.get(node);
            for(int i=0;i<temp.size();i++){
                Pair p=temp.get(i);
                int v=p.v;
                int wt=p.wt;
                if(dist[node]+wt<dist[v]){
                    dist[v]=dist[node]+wt;
                    
                    pq.offer(new Edge(v,dist[v]));
                    ways[v]=ways[node];
                }else if(dist[node]+wt==dist[v]){
                    ways[v]=(ways[v]+ways[node])%mod;
                }
            }
        }

        return (int)(ways[n-1]%mod);
    }
}