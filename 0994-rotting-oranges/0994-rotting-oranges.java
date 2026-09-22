class Solution {
    static class Pair{
        int x;
        int y;
        int time;
        public Pair(int x,int y,int time){
            this.x=x;
            this.y=y;
            this.time=time;
        }
    }

    
    public int orangesRotting(int[][] grid) {
        boolean visited[][]=new boolean[grid.length][grid[0].length];

        int count=0;
        Queue<Pair> q=new LinkedList<>();
        int drow[]={-1,1,0,0};
        int dcol[]={0,0,-1,1};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    visited[i][j]=true;
                    q.add(new Pair(i,j,0));
                }
            }
        }

        while(!q.isEmpty()){
            Pair p=q.remove();
            int x=p.x;
            int y=p.y;
            int time=p.time;
            count=Math.max(count,time);
            for(int i=0;i<4;i++){
                int nrow=x+drow[i];
                int ncol=y+dcol[i];
                if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && !visited[nrow][ncol] && grid[nrow][ncol]==1){
                    visited[nrow][ncol]=true;
                    q.add(new Pair(nrow,ncol,time+1));
                }
            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]==1) return -1;
            }

        }

        return count;
    }
}