class Solution {
    class Pair{
        int dis;
        int row;
        int col;
        public Pair(int dist,int row,int col){
            this.dis=dist;
            this.row=row;
            this.col=col;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length==0||grid[0].length==0) return -1;
        if(grid[0][0]!=0) return -1;
        if(grid[0][0]==0 && grid.length==1) return 1;

        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(0,0,0));
        int desrow=grid.length-1;
        int descol=grid.length-1;

        int [] [] dist=new int [grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=0;
        while(!q.isEmpty()){
            Pair p=q.remove();
            int dis=p.dis;
            int row=p.row;
            int col=p.col;

            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    if(i==0 && j==0) continue;
                    int nrow=row+i;
                    int ncol=col+j;
                    if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid.length && grid[nrow][ncol]==0 && dis+1<dist[nrow][ncol]){
                        dist[nrow][ncol]=dis+1;
                        if(nrow==desrow && ncol==descol){
                            return dist[nrow][ncol]+1;
                        }

                        q.offer(new Pair(dist[nrow][ncol],nrow,ncol));
                    }
                }
            }
        }

        return -1;
    }
}