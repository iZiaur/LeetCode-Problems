class Solution {

    public void dfs(int i,int j, int[][] grid,boolean[][] visited){
        visited[i][j]=true;

        int drow[]={-1,1,0,0};
        int dcol[]={0,0,-1,1};
        for(int k=0;k<drow.length;k++){
            int newrow=i+drow[k];
            int newcol=j+dcol[k];
            if(newrow<grid.length && newcol<grid[0].length && newrow>=0 && newcol>=0 && grid[newrow][newcol]==0 && !visited[newrow][newcol]){
                dfs(newrow,newcol,grid,visited);
            }
        }
    }
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean [][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || i==n-1 || j==0 || j==m-1)&& grid[i][j]==0 && !visited[i][j]){
                    dfs(i,j,grid,visited);
                }
            }
        }

        int counter=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0 && !visited[i][j]){
                    counter++;
                    dfs(i,j,grid,visited);
                }
            }
        }

        return counter;
    }
}