class Solution {
    class Pair{
        int row;
        int col;
        int time;
        public Pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }

    }
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int  dist[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        dist[0][0]=grid[0][0];
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.time-b.time);
        pq.offer(new Pair(0,0,grid[0][0]));
        int drow[]={-1,1,0,0};
        int dcol[]={0,0,-1,1};
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int row=p.row;
            int col=p.col;
            int time=p.time;
            if(row==n-1 && col==n-1){
                return time;
            }
            if(time>dist[row][col]) continue;

            for(int i=0;i<4;i++){
                int nrow=row+drow[i];
                int ncol=col+dcol[i];

                if(nrow>=0 & nrow<n && ncol>=0 && ncol<n){

                    int newtime=Math.max(time,grid[nrow][ncol]);

                    if(newtime<dist[nrow][ncol]){
                        dist[nrow][ncol]=newtime;

                        pq.offer(new Pair(nrow,ncol,newtime));
                    }
                }
            }
        }

        return -1;
    }
}