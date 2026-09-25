class Solution {
    class Pair{
        int vertex;
        int count;

        public Pair(int vertex,int count){
            this.vertex=vertex;
            this.count=count;
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // int n=edges.length;
        
        int dist[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) dist[i][j]=0;
                else dist[i][j]=Integer.MAX_VALUE;
            }
        }

      
        for(int [] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            dist[u][v]=wt;
            dist[v][u]=wt;
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){

                    if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE){


                        dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
        }

        
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
            if(a.count!=b.count){
                return a.count-b.count;
            }
                
                return b.vertex-a.vertex;
            
        });
        boolean isFound=false;
        
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(dist[i][j]==0) continue;
                if(dist[i][j]<=distanceThreshold) count++;
            }
           
            pq.offer(new Pair(i,count));
        }
        Pair p=pq.peek();
      

       return p.vertex;
    }
}