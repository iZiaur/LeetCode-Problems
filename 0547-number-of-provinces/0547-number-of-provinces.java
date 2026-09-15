class Solution {

    public void dfs(List<List<Integer>>adj,boolean[] visited,int start){
        visited[start]=true;
        List<Integer>temp=adj.get(start);
        for(int i=0;i<temp.size();i++){
            if(!visited[temp.get(i)]){
                dfs(adj,visited,temp.get(i));
            }
        }

    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            adj.add(new ArrayList<>());
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[i][j]==1){
                    adj.get(i).add(j);
                }
            }
        }

        boolean visited[]=new boolean[isConnected.length];
        int ans=0;
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                ans++;
                dfs(adj,visited,i);
            }
        }

        return ans;
    }
}