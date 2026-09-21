class Solution {
    static class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public void bfs(char[][]grid,boolean[][] visited,int i,int j){
       
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i,j));
        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, -1, 1};
        while(!q.isEmpty()){
            Pair p=q.remove();
            int row=p.x;
            int col=p.y;
            if(!visited[row][col]){
                visited[row][col]=true;
                
                for(int deltarow=0;deltarow<4;deltarow++)
                    {
                        int nrow=row+drow[deltarow];
                        int ncol=col+dcol[deltarow];
                        if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]=='1' && !visited[nrow][ncol]){
                            q.add(new Pair(nrow,ncol));
                        }
                    
                }
            }
        }

    }
    public int numIslands(char[][] grid) {
        int ans=0;
        boolean visited[][]=new boolean[grid.length][grid[0].length];
         for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
            if(!visited[i][j] && grid[i][j]=='1'){
                ans++;
                bfs(grid,visited,i,j);
            }
            }
        }

        return ans;
    }
}