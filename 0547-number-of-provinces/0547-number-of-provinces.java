class Solution {

    public void dfs(int [][] matrix,boolean[] visited,int start){
        visited[start]=true;
        
        for(int i=0;i<matrix.length;i++){
            if(matrix[start][i]==1 && !visited[i]){
                dfs(matrix,visited,i);
            }
        }

    }
    public int findCircleNum(int[][] isConnected) {
       

        boolean visited[]=new boolean[isConnected.length];
        int ans=0;
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                ans++;
                dfs(isConnected,visited,i);
            }
        }

        return ans;
    }
}