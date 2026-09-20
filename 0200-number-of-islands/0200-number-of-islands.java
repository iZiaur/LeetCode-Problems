class Solution {
    public void dfs(char[][]grid,boolean[][] visited,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||visited[i][j]||grid[i][j]!='1'){
            return;
        }
        visited[i][j]=true;
        dfs(grid,visited,i,j-1);
        dfs(grid,visited,i,j+1);
        dfs(grid,visited,i-1,j);
        dfs(grid,visited,i+1,j);
    }
    public int numIslands(char[][] grid) {
        int ans=0;
        boolean visited[][]=new boolean[grid.length][grid[0].length];
         for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
            if(!visited[i][j] && grid[i][j]=='1'){
                ans++;
                dfs(grid,visited,i,j);
            }
            }
        }

        return ans;
    }
}