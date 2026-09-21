class Solution {
    public void dfsutil(int i,int j,int[][] grid,boolean visited[][]){
            if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0||visited[i][j]){
                return;
            }

            



        visited[i][j]=true;
        dfsutil(i-1,j,grid,visited);
        dfsutil(i+1,j,grid,visited);
        dfsutil(i,j-1,grid,visited);
        dfsutil(i,j+1,grid,visited);

        
        
    }
    public int numEnclaves(int[][] grid) {
        int count=0;
      
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
               
               if(grid[i][j]==1 && (i==0||j==0||i==grid.length-1||j==grid[0].length-1)){

                dfsutil(i,j,grid,visited);
               }
            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j]==false && grid[i][j]==1){
                    count++;
                }
            }
        }

        return count;
    }
}