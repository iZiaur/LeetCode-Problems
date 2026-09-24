class Solution {
   

   class Pair{
    int dis;
    int row;
    int col;

    public Pair(int dis,int row,int col){
        this.dis=dis;
        this.row=row;
        this.col=col;
    }
   }

    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[][]dist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=0;
        int drow[]={-1,1,0,0};
        int dcol[]={0,0,-1,1};
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.dis-b.dis);
        pq.offer(new Pair(0,0,0));

        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int dis=p.dis;
            int col=p.col;
            int row=p.row;
            if(row==n-1 &&col==m-1){
                return dist[row][col];
            }
            for(int i=0;i<4;i++){
                int nrow=row+drow[i];
                int ncol=col+dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){

                    int cost=Math.max(dis,Math.abs(heights[row][col]-heights[nrow][ncol]));

                    if(cost<dist[nrow][ncol]){
                        dist[nrow][ncol]=cost;
                        pq.offer(new Pair(dist[nrow][ncol],nrow,ncol));
                    }

                    
                }
            }
        }

        return -1;
    }
}